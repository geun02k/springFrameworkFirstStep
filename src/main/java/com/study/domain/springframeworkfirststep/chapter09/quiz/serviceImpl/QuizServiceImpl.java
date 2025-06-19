package com.study.domain.springframeworkfirststep.chapter09.quiz.serviceImpl;

import com.study.domain.springframeworkfirststep.chapter09.quiz.entity.Quiz;
import com.study.domain.springframeworkfirststep.chapter09.quiz.repository.QuizRepository;
import com.study.domain.springframeworkfirststep.chapter09.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
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
        //Integer randomId = quizRepository.getRandomId();
        Random random = new Random();
        Long randomId = random.nextLong(quizRepository.count());

        if(randomId < 0) {
            return Optional.empty(); // 빈 Optional 인스턴스 반환
        }
        return quizRepository.findById(randomId.intValue());
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
