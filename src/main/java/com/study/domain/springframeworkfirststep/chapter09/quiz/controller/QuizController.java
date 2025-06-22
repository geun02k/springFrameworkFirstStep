package com.study.domain.springframeworkfirststep.chapter09.quiz.controller;

import com.study.domain.springframeworkfirststep.chapter09.quiz.entity.Quiz;
import com.study.domain.springframeworkfirststep.chapter09.quiz.form.QuizForm;
import com.study.domain.springframeworkfirststep.chapter09.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    /** form-bocking bean 초기화 */
    @ModelAttribute
    public QuizForm setUpForm() {
        QuizForm form = new QuizForm();
        form.setAnswer(true); // 정답 라디오버튼 초기화 설정
        return form;
    }

    /** 퀴즈목록조회 */
    @GetMapping
    public String showList(QuizForm quizForm, Model model) {
        // 신규등록설정
        quizForm.setNewQuiz(true);

        // 퀴즈목록조회
        Iterable<Quiz> quizList = quizService.selectAll();

        // model로 전달
        model.addAttribute("title", "등록화면");
        model.addAttribute("quizList", quizList);

        return "chapter09quiz/crud";
    }

    // 유효성검증
    // :@Validated로 Form 클래스의 단일 항목 검사 수행 후 실행결과는 BindingResult 인터페이스에 저장.
    /** 퀴즈등록 */
    @PostMapping("insert")
    public String insertQuiz(@Validated QuizForm quizForm,
                             BindingResult bindingResult,
                             Model model,
                             RedirectAttributes redirectAttributes) {
        // 에러 발생 시 퀴즈목록출력
        if(bindingResult.hasErrors()) {
            return showList(quizForm, model);
        }

        // Form -> Entity 변환
        Quiz quiz = new Quiz();
        quiz.setQuestion(quizForm.getQuestion());
        quiz.setAnswer(quizForm.getAnswer());
        quiz.setAuthor(quizForm.getAuthor());

        // 퀴즈등록
        quizService.insertQuiz(quiz);
        // RedirectAttributes를 요청 메서드 인수로 추가하고, addFlashAttribute() 작성.
        // addFlashAttribute()
        // : 리다이렉트할 화면에 전달할 값 설정 가능.
        // : Flash Scope 범위(한 번의 리다이렉트에서만 유효)
        redirectAttributes.addFlashAttribute("complete", "등록이 완료되었습니다.");
        return "redirect:/quiz";
    }

    /** 퀴즈단건조회 */
    @GetMapping("{id}")
    public String showQuiz(QuizForm quizForm,
                             @PathVariable Integer id,
                             Model model) {
        // Quiz 조회
        Optional<Quiz> quizOpt = quizService.selectOneById(id);

        // Entity -> Form 변환
        Optional<QuizForm> quizFormOpt = quizOpt.map(quiz -> makeQuizForm(quiz));

        // quizForm 값 취득
        if(quizFormOpt.isPresent()) {
            quizForm = quizFormOpt.get();
        }

        // update용 quizForm 모델 생성
        makeUpdateModel(quizForm, model);

        return "chapter09quiz/crud";
    }

    /** 퀴즈수정 */
    @PostMapping("update")
    public String updateQuiz(@Validated QuizForm quizForm,
                             BindingResult result,
                             Model model,
                             RedirectAttributes redirectAttributes) {
        // Form -> Entity 변환
        Quiz quiz = makeQuiz(quizForm);

        if (!result.hasErrors()) { // 입력체크
            // 퀴즈수정
            quizService.updateQuiz(quiz);
            // Flash scope 사용해 redirect 설정
            redirectAttributes.addFlashAttribute("complete", "변경이 완료되었습니다.");
            // 퀴즈단건조회 페이지 이동
            return "redirect:/quiz/" + quiz.getId();
        } else {
           // update용 모델 생성
           makeUpdateModel(quizForm, model);
           return "/chapter09quiz/crud";
        }
    }

    /** 퀴즈삭제 */
    @PostMapping("delete")
    public String deleteQuiz(@RequestParam("id") Integer id,
                             Model model,
                             RedirectAttributes redirectAttributes) {
        // 퀴즈삭제
        quizService.deleteQuizById(id);
        redirectAttributes.addFlashAttribute("delcomplete", "삭제되었습니다.");
        return "redirect:/quiz";
    }

    /** 랜덤퀴즈조회 */
    @GetMapping("play")
    public String showRandomQuiz(QuizForm quizForm,
                                 Model model) {
        // 랜덤퀴즈조회
        Optional<Quiz> quizOpt = quizService.selectOneRandomQuiz();

        // model에 데이터 저장
        if (quizOpt.isPresent()) {
            Optional<QuizForm> quizFormQpt = quizOpt.map(quiz -> makeQuizForm(quiz));
            quizForm = quizFormQpt.get();
            model.addAttribute("quizForm", quizForm);

        } else {
            model.addAttribute("msg", "등록된 문제가 없습니다.");
        }

        return "chapter09quiz/play";
    }

    @PostMapping("check")
    public String checkQuiz(QuizForm quizForm,
                            @RequestParam Boolean answer,
                            Model model) {
        String msg = "오답입니다.";
        // 정답여부체크
        if (quizService.checkQuiz(quizForm.getId(), answer)) {
            msg = "정답입니다.";
        }
        model.addAttribute("msg", msg);
        return "chapter09quiz/answer";
    }

    // quiz Form -> quiz Entity
    private Quiz makeQuiz(QuizForm quizForm) {
        Quiz quiz = new Quiz();
        quiz.setId(quizForm.getId());
        quiz.setQuestion(quizForm.getQuestion());
        quiz.setAnswer(quizForm.getAnswer());
        quiz.setAuthor(quizForm.getAuthor());
        return quiz;
    }

    // quiz Entity -> quiz Form
    private QuizForm makeQuizForm(Quiz quiz) {
        QuizForm form = new QuizForm();
        form.setId(quiz.getId());
        form.setQuestion(quiz.getQuestion());
        form.setAnswer(quiz.isAnswer());
        form.setAuthor(quiz.getAuthor());
        form.setNewQuiz(false);
        return form;
    }

    // update용 모델 생성
    private void makeUpdateModel(QuizForm quizForm, Model model) {
        quizForm.setNewQuiz(false);

        model.addAttribute("id", quizForm.getId());
        model.addAttribute("quizForm", quizForm);
        model.addAttribute("title", "수정화면");
    }
}
