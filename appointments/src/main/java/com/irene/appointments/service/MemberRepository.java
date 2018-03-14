package com.irene.appointments.service;

import com.irene.appointments.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Bibek on 3/14/2018.
 */
public interface MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findMemberByFirstName(String firstName);
}
