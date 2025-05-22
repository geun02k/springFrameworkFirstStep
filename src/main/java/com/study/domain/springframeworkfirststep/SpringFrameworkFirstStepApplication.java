package com.study.domain.springframeworkfirststep;

import com.study.domain.springframeworkfirststep.chapter03.dependencyinjectionsample.used.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 메인 메서드를 포함한 클래스에 해당 어노테이션 부여 시 스프링 부트 애플리케이션으로 인식.
@SpringBootApplication
public class SpringFrameworkFirstStepApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFrameworkFirstStepApplication.class, args)
                .getBean(SpringFrameworkFirstStepApplication.class).execute();
    }

    /**
     * 인터페이스에 구현체 주입
     * 스프링 프레임워크에 의해 생성된 인스턴스를 이용하고 싶은 곳에서
     * 참조를 받는 필드를 선언하고 @Autowired 어노테이션 부여.
     */
    @Autowired
    Greet greet;

    /**
     * 실행 메서드
     */
    private void execute() {
        greet.greeting();
    }

}
