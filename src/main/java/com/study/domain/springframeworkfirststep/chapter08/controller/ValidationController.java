package com.study.domain.springframeworkfirststep.chapter08.controller;

import com.study.domain.springframeworkfirststep.chapter08.form.CalcForm;
import com.study.domain.springframeworkfirststep.chapter08.validator.CalcValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("validation")
public class ValidationController {

    // 커스텀 유효성 검사기 CalcValidator 주입(injection)
    @Autowired
    CalcValidator calcValidator;

    // 커스텀 유효성 검사기 CalcValidator 등록
    // @InitBinder("calcForm")
    // 어노테이션에 체크 대상 Form 클래스의 Model 식별명 지정
    // (식별명을 지정하지 않는 경우 Model에 저장되는 모든 객체에 대해 유효성 검사 적용됨.)
    @InitBinder("calcForm")
    public void initBinder(WebDataBinder webDataBinder) {
        // WebDataBinder 인터페이스의 addValidators()에 커스텀 유효성 검사기 등록 -> 스프링 MVC에서 이용가능
        webDataBinder.addValidators(calcValidator);
    }

    // 유효성 검사를 위해 form-backing bean 초기화 설정 필수
    // - @ModelAttribute 어노테이션 부여 메서드에 작성.
    //   : 클래스의 요청 바인딩 메서드가 실행되기 전 호출되어 request scope로 Model에 저장.
    // - HTML form 태그에 바인딩할 Form class 초기화해 반환.
    // - form-backing bean : HTML form 태그에 바인딩되는 Form class 인스턴스
    /** CalcForm 인스턴스 생성 및 초기화 */
    @ModelAttribute
    public CalcForm setUpForm() {
        return new CalcForm();
    }

    /** 입력화면출력 */
    @GetMapping("showForm")
    public String showView() {
        return "chapter08/entry";
    }

    // < 유효성 검사 >
    // : @Validated 어노테이션 부여한 클래스, BindingResult 인터페이스를 함께 인수로 사용.
    // : 인수는 @Validated -> BindingResult 순으로 사용.
    //
    // @Validated : 단일 항목 검사 어노테이션을 설정한 Form 클래스에 부여해 유효성 검사 실행
    // BindingResult : 실행 결과(에러정보)는 해당 인터페이스에 보관됨.
    //               - hassErrors() : 에러 유무 반환
    /** 확인화면출력 : Form class 사용 */
    @PostMapping("calc")
    public String confirmView(@Validated CalcForm form,
                              BindingResult bindingResult,
                              Model model) {
        // 에러발생 시 입력화면으로 이동
        if(bindingResult.hasErrors()) {
            return "chapter08/entry";
        }

        // Service 로직 : 덧셈
        Integer result = form.getLeftNum() + form.getRightNum();
        // Model에 저장
        model.addAttribute("result", result);
        // View 반환
        return "chapter08/confirm";
    }
}
