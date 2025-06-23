package com.study.domain.springframeworkfirststep.chapter09.quiz;

import com.study.domain.springframeworkfirststep.chapter09.quiz.entity.Quiz;
import com.study.domain.springframeworkfirststep.chapter09.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

// Junit 테스트를 수행해야 하지만 간단히 Application에서 테스트를 수행하기 위한 클래스임.
@Component
public class FunctionTestSample {

    @Autowired
    QuizRepository repository;

    // SpringFrameworkFirstStepApplication 에서 실행할 메서드
    public void executeQuiz() {
//        insertQuiz();
//        updateQuiz();
//        deleteQuiz();
//        showQuiz();
        showList();
    }

    // 퀴즈등록
    private void insertQuiz() {
        Quiz quiz1 = new Quiz(null, "Spring은 프레임워크입니까?", true, "김하늘");
        Quiz savedQuiz1 = repository.save(quiz1);
        System.out.println("\n등록된 퀴즈 : " + savedQuiz1);
    }

    // 퀴즈전체조회
    private void showList(){
        System.out.println(" \n모든 데이터 조회 시작");
        System.out.println("=============");
        repository.findAll().forEach(System.out::println);
        System.out.println("=============");
        System.out.println("모든 데이터 조회 완료");
    }

    // 퀴즈단건조회
    private void showQuiz() {
        System.out.println("\n단건 조회 시작");
        System.out.println("=============");
        Optional<Quiz> quizOpt = repository.findById(1);

        if(quizOpt.isPresent()) {
            System.out.println(quizOpt.get());
        } else {
            System.out.println("해당 데이터는 존재하지 않습니다.");
        }
    }

    // 퀴즈수정
    private void updateQuiz() {
        Quiz quiz = new Quiz(2, "스프링 MVC는 배치 처리를 제공합니까?", false, "윤사랑");
        Quiz updatedQuiz = repository.save(quiz);
        System.out.println("\n변경된 퀴즈 : " + updatedQuiz);
    }

    // 퀴즈삭제
    private void deleteQuiz() {
        repository.deleteById(1);
        System.out.println("\n퀴즈삭제완료");
    }

}
