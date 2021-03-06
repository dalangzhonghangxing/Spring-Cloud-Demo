package org.account.service.repository;

import org.account.service.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = false)
public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findByUsername(String username);

}
