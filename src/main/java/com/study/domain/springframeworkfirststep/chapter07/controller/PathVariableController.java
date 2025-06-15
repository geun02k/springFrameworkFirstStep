package com.study.domain.springframeworkfirststep.chapter07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** URL에 포함된 값 받기 */
@Controller
@RequestMapping("pathVariable")
public class PathVariableController {

    /** 입력화면호출 */
    @GetMapping("showForm")
    public String showView() {
        return "chapter07/show";
    }

    /** 출력화면호출 */
    // {} 자리표시자(placeholder) : URL에 포함된 값 저장.
    // @PathVariable : 자리표시자와 동일한 변수명으로 지정 시 변수에 값이 저장됨.
    @GetMapping("function/{no}")
    public String selectFunction(@PathVariable Integer no) {
        String view = null;

        switch (no) {
            case 1:
                view = "chapter07/function1";
                break;
            case 2:
                view = "chapter07/function2";
                break;
            case 3:
                view = "chapter07/function3";
                break;
        }

        return view;
    }
}
