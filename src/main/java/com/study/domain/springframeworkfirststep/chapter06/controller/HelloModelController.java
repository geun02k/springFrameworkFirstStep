package com.study.domain.springframeworkfirststep.chapter06.controller;

import com.study.domain.springframeworkfirststep.chapter06.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("hello")
public class HelloModelController {

    @GetMapping("model")
    public String helloView(Model model) {
        // Model에 데이터 저장
        model.addAttribute("msg", "타임리프!!");
        // View 이름 반환
        return "chapter06/helloThymeleaf";
    }

    @GetMapping("thymeleaf")
    public String thymeleafSampleView(Model model) {
        // Model 데이터 생성
        User user = new User(1, "한사랑");
        User user2 = new User(2, "두사랑");
        User user3 = new User(3, "세사랑");
        List<Object> sampleList = List.of("동", "서", "남", "북");
        Map<String, Object> sampleMap = new HashMap<>();
        sampleMap.put("kim", "sky");
        sampleMap.put("lee", "rose");
        Iterable<User> members = List.of(user, user2, user3);

        // Model에 데이터 저장
        model.addAttribute("name", "김하늘");
        model.addAttribute("user", user);
        model.addAttribute("sampleList", sampleList);
        model.addAttribute("sampleMap", sampleMap);
        model.addAttribute("members", members);

        // View 이름 반환
        return "chapter06/thymeleafSample";
    }
}
