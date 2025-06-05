package com.study.domain.springframeworkfirststep.chapter06project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

    private Integer id;
    private String name;
}
