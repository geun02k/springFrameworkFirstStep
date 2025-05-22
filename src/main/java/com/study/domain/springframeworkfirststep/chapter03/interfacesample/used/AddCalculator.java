package com.study.domain.springframeworkfirststep.chapter03.interfacesample.used;

/**
 * Calculator 구현 클래스 <br/>
 * 덧셈처리
 */
public class AddCalculator implements Calculator {
    @Override
    public Integer calc(Integer x, Integer y) {
        return x+y;
    }
}
