package com.study.domain.springframeworkfirststep.chapter07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    /** 클릭한 버튼 판별 */
    // @RequestMapping의 params 속성에 뷰의 버튼에 대응하는 name 속성 설정 시,
    // 요청에서 어떤 버튼이 클릭되었는지 판별가능.
    @PostMapping(value="send", params = "a")
    public String showViewByButton1() {
        return "chapter07/submitA";
    }
    @PostMapping(value="send", params = "b")
    public String showViewByButton2() {
        return "chapter07/submitB";
    }
    @PostMapping(value="send", params = "c")
    public String showViewByButton3() {
        return "chapter07/submitC";
    }
}
