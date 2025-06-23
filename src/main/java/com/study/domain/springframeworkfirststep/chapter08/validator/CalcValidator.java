package com.study.domain.springframeworkfirststep.chapter08.validator;

import com.study.domain.springframeworkfirststep.chapter08.form.CalcForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// @Component : 인스턴스 생성 대상으로 지정
@Component
public class CalcValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        // 인수로 전달받은 Form class 입력 체크 대상여부 반환
        return CalcForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // 대상 Form class 취득
        CalcForm form = (CalcForm) target;

        // 값의 입력 여부 판단
        if(form.getLeftNum() != null && form.getRightNum() != null) {
            // 에러발생조건 : 왼쪽 입력값이 홀수, 오른쪽 입력값이 짝수가 아닌 경우
            if(!((form.getLeftNum() % 2 ==1) && (form.getRightNum() % 2 == 0))) {
                // 에러메시지 키 지정 : Errors 인터페이스의 reject 메서드에 에러메시지의 key 지정
                //                   (메시지key는 messages.properties에 작성)
                errors.reject("com.study.domain.springframeworkfirststep.chapter08.validator.CalcValidator.message");
            }
        }
    }
}

