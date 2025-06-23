package com.study.domain.springframeworkfirststep.chapter07.controller;

import com.study.domain.springframeworkfirststep.chapter07.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequestParamController {
    /** 입력화면호출 */
    @GetMapping("showForm")
    public String showView() {
        return "chapter07/entry";
    }

    /** 확인화면호출 @RequestParam을 이용한 입력값 받기 */
//    @PostMapping("confirm")
//    public String confirmView(Model model,
//                              @RequestParam String name,
//                              @RequestParam Integer age,
//                              // yyyy-MM-dd 형식으로 데이터 받음
//                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birth) {
//
//        model.addAttribute("name", name);
//        model.addAttribute("age", age);
//        model.addAttribute("birth", birth);
//
//        return "chapter07/confirm";
//    }

    /** 확인화면호출 : Form class를 이용한 입력값 받기 */
    @PostMapping("confirm")
    public String confirmView(UserForm user) {
        return "chapter07/confirm2";
    }
}
