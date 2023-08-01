package com.example.mingolab.springBootTutorial.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mingolab.springBootTutorial.member.controller.dto.JoinRequest;
import com.example.mingolab.springBootTutorial.member.repository.MemberRepository;
import com.example.mingolab.springBootTutorial.member.repository.entity.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public String join(JoinRequest joinRequest){
        Member member = Member.builder()
                            .id(joinRequest.getId())
                            .name(joinRequest.getName())
                            .phoneNumber(joinRequest.getPhoneNumber())
                            .build();
        memberRepository.save(member);

        return "Success";
    }

    @Override
    public String delete(String name){

        try {
            List<Member> members = memberRepository.findAll();
            for (Member member: members){
                if(member.getName().equals(name)){
                    memberRepository.delete(member);
                    return "Success";
                }
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointException Caught");
            return "Fail";
        }
        return "Fail";

    }

    @Override
    public String init(){

        for (int i=0;i<10;i++){
            Member member = Member.builder()
                            .id("id"+i)
                            .name("name"+i)
                            .phoneNumber("123-456-789"+i)
                            .build();
            memberRepository.save(member);
        }

        return "Success";
    }
    
}
