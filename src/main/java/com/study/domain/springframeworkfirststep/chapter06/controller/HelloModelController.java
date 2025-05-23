package com.study.domain.springframeworkfirststep.chapter06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloModelController {

    @GetMapping("model")
    public String helloView(Model model) {
        // Model에 데이터 저장5
        model.addAttribute("msg", "타임리프!!");
        // View 이름 반환
        return "helloThymeleaf";
    }
}
