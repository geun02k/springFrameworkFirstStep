package com.study.domain.springframeworkfirststep.chapter09.quiz.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizForm {

    private Integer id;

    @NotBlank
    private String question;

    private Boolean answer;

    @NotBlank
    private String author;

    private Boolean newQuiz; // 등록,변경 판단용 (true등록, false변경)
}
