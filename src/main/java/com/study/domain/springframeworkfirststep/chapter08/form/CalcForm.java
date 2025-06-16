package com.study.domain.springframeworkfirststep.chapter08.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

// 1. @Range
//    표준라이브러리 jakarta의 @Min, @Max 대신 확장라이브러리 @Range 사용 시
//    가독성, 유지보수 측면에서 유리

// 2. 에러 메시지 안 {속성명} 사용 시 속성값 이용가능
//    ex) @Range(min = 1, max = 10, message = "왼쪽: {min}~{max} 범위의 숫자를 입력해주세요.")

@Data
public class CalcForm {
    @NotNull
    @Range(min = 1, max = 10)
    private Integer leftNum;

    @NotNull
    @Range(min = 1, max = 10)
    private Integer rightNum;
}
