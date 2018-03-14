package com.irene.appointments.controller;

import com.irene.appointments.domain.Member;
import com.irene.appointments.service.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

/**
 * Created by Bibek on 3/13/2018.
 */
@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping("/home")
    public String home(){
        return "hello";
    }

    @PostMapping(value = "member/createMember")
    public Member createMember(@RequestBody Member member){
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }

    @RequestMapping(value = "/member/getAllMember", method = RequestMethod.GET)
    public @ResponseBody Iterable<Member> getAllMember(){
        return memberRepository.findAll();
    }

    @RequestMapping(value = "/member/getMember/{name}", method = RequestMethod.GET)
    public List<Member> getMemberByName(@RequestParam String name){
        return memberRepository.findMemberByFirstName(name);
    }
    @RequestMapping(value = "/member/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMember(@RequestBody Member member, UriComponentsBuilder builder){
        memberRepository.delete(member);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/member/update", method = RequestMethod.PUT)
    public ResponseEntity<Member> updateMember(@RequestBody Member member, UriComponentsBuilder builder){
       Member savedMember = memberRepository.save(member);
        return new ResponseEntity<Member>(savedMember, HttpStatus.CREATED);
    }
}
