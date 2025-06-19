package com.study.domain.springframeworkfirststep.chapter09.quiz.service;

import com.study.domain.springframeworkfirststep.chapter09.quiz.entity.Quiz;

import java.util.Optional;

public interface QuizService {
    /** 퀴즈전체조회 */
    Iterable<Quiz> selectAll();

    /** 퀴즈단건조회 */
    Optional<Quiz> selectOneById(Integer id);

    /** 랜덤퀴즈단건조회 */
    Optional<Quiz> selectOneRandomQuiz();

    /** 퀴즈 정답여부 판단 */
    Boolean checkQuiz(Integer id, Boolean myAnswer);

    /** 퀴즈등록 */
    void insertQuiz(Quiz quiz);

    /** 퀴즈수정 */
    void updateQuiz(Quiz quiz);

    /** 퀴즈삭제 */
    void deleteQuizById(Integer id);
}
