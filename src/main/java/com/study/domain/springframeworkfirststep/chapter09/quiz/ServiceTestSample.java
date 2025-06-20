package com.study.domain.springframeworkfirststep.chapter09.quiz;

import com.study.domain.springframeworkfirststep.chapter09.quiz.entity.Quiz;
import com.study.domain.springframeworkfirststep.chapter09.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceTestSample {

    @Autowired
    QuizService quizService;

    // SpringFrameworkFirstStepApplication 에서 실행할 메서드
    public void executeQuiz() {
        // insertQuizzes();
        showList();
        doQuiz();
    }

    // 퀴즈등록
    private void insertQuizzes() {
        System.out.println("\n퀴즈 5건 등록");
        System.out.println("=============");

        String question1 = "자바는 객체지향 언어입니다.";
        String question2 = "Spring Data는 데이터 엑세스에 관련된 기능을 제공합니다.";
        String question3 = "프로그램이 많이 등록되어 있는 서버를 라이브러리라고 합니다.";
        String question4 = "@Component는 인스턴스 생성 어노테이션 입니다.";
        String question5 = "스프링 MVC에서 구현하고 있는 디자인 패턴에서 모든 요청을 하나의 컨트롤러에서 받는 것을 싱글 컨트롤러 패턴이라고 합니다.";

        Quiz quiz1 = new Quiz(null, question1, true, "김하늘");
        Quiz quiz2 = new Quiz(null, question2, true, "김하늘");
        Quiz quiz3 = new Quiz(null, question3, false, "김하늘");
        Quiz quiz4 = new Quiz(null, question4, true, "김하늘");
        Quiz quiz5 = new Quiz(null, question5, false, "김하늘");

        // 퀴즈목록생성
        List<Quiz> quizList = new ArrayList<>();
        Collections.addAll(quizList, quiz1, quiz2, quiz3, quiz4, quiz5);

        // 퀴즈등록
        for(Quiz quiz : quizList) {
            quizService.insertQuiz(quiz);
        }
    }

    // 퀴즈전체조회
    private void showList() {
        System.out.println(" \n모든 데이터 조회 시작");
        System.out.println("=============");
        Iterable<Quiz> quizzes = quizService.selectAll();
        quizzes.forEach(System.out::println);
        System.out.println("=============");
    }

    // 퀴즈단건조회
    private void showQuiz() {
        System.out.println("\n단건 조회 시작");
        System.out.println("=============");
        Optional<Quiz> quiz = quizService.selectOneById(1);
        if(quiz.isPresent()) {
            System.out.println(quiz.get());
        } else {
            System.out.println("해당 데이터는 존재하지 않습니다.");
        }
        System.out.println("=============");
    }

    // 퀴즈수정
    private void updateQuiz() {
        System.out.println("\n퀴즈 수정 시작");
        System.out.println("=============");
        Quiz quiz = new Quiz(1, "스프링은 프레임워크입니까?", true, "김사랑");
        quizService.updateQuiz(quiz);
        System.out.println("변경 데이터 : " + quiz);
        System.out.println("=============");
    }

    // 퀴즈삭제
    private void deleteQuiz() {
        System.out.println("\n퀴즈 삭제 시작");
        System.out.println("=============");
        quizService.deleteQuizById(3);
        System.out.println("\n퀴즈 삭제 완료");
        System.out.println("=============");
    }

    // 랜덤퀴즈출력 및 평가
    private void doQuiz() {
        // 퀴즈출력
        System.out.println("\n퀴즈 1건 출력합니다.");
        Optional<Quiz> quiz = quizService.selectOneRandomQuiz();
        if(quiz.isPresent()) {
            System.out.println(quiz.get());
        } else {
            System.out.println("해당 데이터는 존재하지 않습니다.");
        }

        // 답안평가
        Boolean myAnswer = false;
        Integer id = quiz.get().getId();
        if(quizService.checkQuiz(id, myAnswer)) {
            System.out.println("정답입니다!!");
        } else {
            System.out.println("오답입니다.");
        }
        System.out.println("=============");
    }
}
