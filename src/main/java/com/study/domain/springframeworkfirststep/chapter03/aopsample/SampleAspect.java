package com.study.domain.springframeworkfirststep.chapter03.aopsample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Aspect : 횡단적 관심사
 */
@Aspect // Advice 기술 클래스
@Component // DI 컨테이너에서 인스턴스 자동 생성
public class SampleAspect {
    /*
       포인트컷식
       execution(반환타입 패키지.클래스.메서드(인수))
       com.study.domain.springframeworkfirststep.chapter03.dependencyinjectionsample.used 패키지에서
       Greet로 끝나는 클래스의 모든 메서드를 대상으로하는 advice
     */
    @Before("execution(* com.study.domain.springframeworkfirststep.chapter03.dependencyinjectionsample.used.*Greet.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        // Advice 시작부분 표시
        System.out.println("===== Before Advice =====");
        // 날짜 출력
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));
        // 메서드 이름 출력
        System.out.printf("메서드: %s \n", joinPoint.getSignature().getName() );
    }

    @After("execution(* com.study.domain.springframeworkfirststep.chapter03.dependencyinjectionsample.used.*Greet.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        // Advice 시작부분 표시
        System.out.println("===== After Advice =====");
        // 날짜 출력
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));
        // 메서드 이름 출력
        System.out.printf("메서드: %s \n", joinPoint.getSignature().getName() );
    }

    @Around("execution(* com.study.domain.springframeworkfirststep.chapter03.dependencyinjectionsample.used.*Greet.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // Advice 시작부분 표시
        System.out.println("===== Around Advice =====");
        System.out.println("- 중앙적 관심사 처리전");
        // 지정한 클래스의 메서드 실행
        Object result = joinPoint.proceed();
        System.out.println("- 중앙적 관심사 처리후");
        // 반환값을 전달할 필요가 있는 경우 반환값 return
        return result;
    }

}
