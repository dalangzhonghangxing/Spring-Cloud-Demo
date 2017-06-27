package org.account.service.controller;

import java.util.Map;

import org.account.service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private AccountService service;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username,
            @RequestParam String password) {
        return service.login(username, password);
    }

    /**
     * 本地服务实例的信息
     * 
     * @return
     */
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = discoveryClient
                .getLocalServiceInstance();
        return localServiceInstance;
    }
}
