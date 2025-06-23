package com.study.domain.springframeworkfirststep.chapter09.quiz.repository;

import com.study.domain.springframeworkfirststep.chapter09.quiz.entity.Quiz;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

/** Quiz 테이블 repositoryImpl */
public interface QuizRepository extends CrudRepository<Quiz, Integer> {
    // quiz 테이블 랜덤 id 1건 조회
    @Query("SELECT id FROM quiz ORDER BY RAND() limit 1")
    Integer getRandomId();
}
