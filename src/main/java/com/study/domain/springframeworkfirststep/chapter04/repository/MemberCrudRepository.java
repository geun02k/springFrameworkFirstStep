package com.study.domain.springframeworkfirststep.chapter04.repository;

import com.study.domain.springframeworkfirststep.chapter04.entity.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * Member 테이블 repository
 * CrudRepository를 상속.
 * 인수로 저장대상 객체타입, 저장대상객체의 기본키타입 지정
 */
public interface MemberCrudRepository extends CrudRepository<Member, Integer> {
}
