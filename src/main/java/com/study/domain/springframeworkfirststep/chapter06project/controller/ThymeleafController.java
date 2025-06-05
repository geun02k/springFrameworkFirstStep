package com.study.domain.springframeworkfirststep.chapter06project.controller;

import com.study.domain.springframeworkfirststep.chapter06project.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("show")
    public String showView(Model model) {
        Member member = new Member(1, "회원1");

        // model에 데이터 추가
        model.addAttribute("name", "이순신");
        model.addAttribute("member", member);

        // view 이름 반환
        return "chapter06project/useThymeleaf";
    }
}
