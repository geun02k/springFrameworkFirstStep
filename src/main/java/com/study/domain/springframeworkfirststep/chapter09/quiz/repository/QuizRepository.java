package com.study.domain.springframeworkfirststep.chapter09.quiz.repository;

import com.study.domain.springframeworkfirststep.chapter09.quiz.entity.Quiz;
import org.springframework.data.repository.CrudRepository;

/** Quiz 테이블 repositoryImpl */
public interface QuizRepository extends CrudRepository<Quiz, Integer> {
}
