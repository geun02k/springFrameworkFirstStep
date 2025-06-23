package com.study.domain.springframeworkfirststep.chapter07.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

// @Data : getter/setter 자동생성
@Data
public class UserForm {
    private String name;

    private Integer age;

    // yyyy-MM-dd 날짜형식 지정
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birth;
}
