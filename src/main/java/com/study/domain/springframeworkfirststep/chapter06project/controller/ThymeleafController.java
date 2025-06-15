package com.study.domain.springframeworkfirststep.chapter06project.controller;

import com.study.domain.springframeworkfirststep.chapter06project.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {

    @GetMapping("show")
    public String showView(Model model) {
        Member member = new Member(1, "회원1");
        Member member1 = new Member(10, "홍길동");
        Member member2 = new Member(20, "이영희");

        Map<String, Member> memberMap = new HashMap<String, Member>();
        memberMap.put("hong", member1);
        memberMap.put("lee", member2);

        List<Member> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);

        List<String> directionList = new ArrayList<String>();
        directionList.add("동");
        directionList.add("서");
        directionList.add("남");
        directionList.add("북");

        // model에 데이터 추가
        model.addAttribute("name", "이순신");
        model.addAttribute("member", member);
        model.addAttribute("directions", directionList);
        model.addAttribute("memberMap", memberMap);
        model.addAttribute("members", memberList);

        // view 이름 반환
        return "chapter06project/useThymeleaf";
    }

    @GetMapping("showFragment")
    public String showFragment() {
        return "chapter06project/useFragment";
    }

    @GetMapping("a")
    public String showA() {
        return "chapter06project/pageA";
    }
}
