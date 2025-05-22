package com.study.domain.springframeworkfirststep.chapter03.interfacesample.used;

/**
 * Calculator 구현 클래스 <br/>
 * 뺄셈처리
 */
public class SubCalculator implements Calculator {
    @Override
    public Integer calc(Integer x, Integer y) {
        return x-y;
    }
}
