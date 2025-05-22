package com.study.domain.springframeworkfirststep.chapter03.interfacesample.use;

import com.study.domain.springframeworkfirststep.chapter03.interfacesample.used.AddCalculator;
import com.study.domain.springframeworkfirststep.chapter03.interfacesample.used.Calculator;

public class Call {
    public static void main(String[] args) {

        /*
            자바의 다형성을 이용을 위해 인터페이스에 구현체 저장
         */
        Calculator calculator = new AddCalculator(); // 인터페이스 구현클래스를 인스턴스화
        Integer result = calculator.calc(10, 5);

        System.out.println("계산 결과는 ( " + result + " ) 입니다.");
    }
}
