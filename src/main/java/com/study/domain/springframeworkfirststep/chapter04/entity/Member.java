package com.study.domain.springframeworkfirststep.chapter04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Member Entity (DB의 Member 테이블에 대응하는 java Member 객체)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    private Integer id;
    private String name;
}
