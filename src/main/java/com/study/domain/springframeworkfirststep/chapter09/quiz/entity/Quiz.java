package com.study.domain.springframeworkfirststep.chapter09.quiz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/** quiz 테이블용 entity */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    private Integer id; // 식별id

    private String question; // 퀴즈내용

    private boolean answer; //퀴즈답

    private String author; // 작성자
}
