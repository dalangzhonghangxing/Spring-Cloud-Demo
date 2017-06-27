package org.account.service;

import org.account.service.model.Account;
import org.account.service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ApplicationInitializer {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    public void run() {
        long count = accountRepository.count();

        if (count < 2) {
            importAccounts();
        }
    }

    private void importAccounts() {
        Account admin = new Account("admin", "admin", "管理员", "18812345678", 0,
                0.0);
        Account tester = new Account("tester", "tester", "托马斯", "18887654321",
                1, 0.0);

        accountRepository.save(admin);
        accountRepository.save(tester);
    }

}
