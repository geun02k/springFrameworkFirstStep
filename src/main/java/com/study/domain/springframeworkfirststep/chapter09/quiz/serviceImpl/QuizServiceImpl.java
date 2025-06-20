package com.study.domain.springframeworkfirststep.chapter09.quiz.serviceImpl;

import com.study.domain.springframeworkfirststep.chapter09.quiz.entity.Quiz;
import com.study.domain.springframeworkfirststep.chapter09.quiz.repository.QuizRepository;
import com.study.domain.springframeworkfirststep.chapter09.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

// @Transactional
// 트랜잭션의 경계(시작되고 끝나는 범위)를 설정해 메서드 성공 시 commit, 실패 시 rollback
// 클래스에 부여하는 경우 변경처리를 포함한 서비스 처리 뿐 아니라 실수 등으로 인한 버그 등을 방지하는 목적으로 함
@Service
@Transactional
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Override
    public Iterable<Quiz> selectAll() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> selectOneById(Integer id) {
        return quizRepository.findById(id);
    }

    @Override
    public Optional<Quiz> selectOneRandomQuiz() {
        // 랜덤으로 id값 가져오기
        Integer randomId = quizRepository.getRandomId();

        if(randomId < 0) {
            return Optional.empty(); // 빈 Optional 인스턴스 반환
        }
        return quizRepository.findById(randomId);
    }

    @Override
    public Boolean checkQuiz(Integer id, Boolean myAnswer) {
        // 정답 판별 변수
        Boolean check = false;

        // 대상퀴즈조회
        Optional<Quiz> quiz = quizRepository.findById(id);

        // 퀴즈 가져왔는지 확인
        if(quiz.isPresent()) {
            // 퀴즈 정답 확인
            if(quiz.get().isAnswer() == myAnswer) {
                check = true;
            }
        }
        return check;
    }

    @Override
    public void insertQuiz(Quiz quiz) {
         quizRepository.save(quiz);
    }

    @Override
    public void updateQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    @Override
    public void deleteQuizById(Integer id) {
        quizRepository.deleteById(id);
    }
}
