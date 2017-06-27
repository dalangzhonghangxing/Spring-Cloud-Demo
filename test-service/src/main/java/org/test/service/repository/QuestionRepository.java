package org.test.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.test.service.model.Question;


@RepositoryRestResource(exported = false)
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "select * from t_question limit(?1,?2)",nativeQuery=true)
    public List<Question> findAll(int begin, int i);

}
