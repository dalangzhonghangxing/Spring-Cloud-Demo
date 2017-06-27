package org.account.service.service;

import java.util.HashMap;
import java.util.Map;

import org.account.service.model.Account;
import org.account.service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @HystrixCommand
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> res = new HashMap<String, Object>();
        Account account = repository.findByUsername(username);
        if (account == null) {
            res.put("msg", "该用户不存在！");
            res.put("state", 0);
            return res;
        }
        if (!account.getPassword().equals(password)) {
            res.put("msg", "密码错误！");
            res.put("state", 0);
            return res;
        }
        res.put("state", 1);
        res.put("role", account.getType());
        res.put("id", account.getId());
        return res;
    }

}
