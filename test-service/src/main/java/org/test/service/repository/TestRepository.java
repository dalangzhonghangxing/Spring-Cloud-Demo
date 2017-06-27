package org.test.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.test.service.model.Test;


@RepositoryRestResource(exported = false)
public interface TestRepository extends JpaRepository<Test, Long> {

}
