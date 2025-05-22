package com.study.domain.springframeworkfirststep.chapter03.dependencyinjectionsample.used;

import org.springframework.stereotype.Component;

/**
 * Greet 구현 클래스 <br>
 * 아침 인사 하기
 */
@Component // 인스턴스 생성 어노테이션 (Greet 인터페이스의 객체로 MorningGreet 구현클래스 생성)
public class MorningGreet implements Greet {
    @Override
    public void greeting() {
        System.out.println("--------------");
        System.out.println("좋은 아침입니다.");
        System.out.println("--------------");
    }
}
