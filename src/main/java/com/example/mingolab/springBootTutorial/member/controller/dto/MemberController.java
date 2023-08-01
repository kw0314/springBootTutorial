package com.example.mingolab.springBootTutorial.member.controller.dto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mingolab.springBootTutorial.member.repository.entity.Member;
import com.example.mingolab.springBootTutorial.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberService memberService;

    @GetMapping("/hello")
    public String getHello(){
        return "Hello, Spring Boot World~!!";
    }

    @PostMapping("/join")
    public String join(@RequestBody JoinRequest joinRequest){

        String result = memberService.join(joinRequest);

        if ("Success".equalsIgnoreCase(result)) return "Success";
        else return "Fail";
    }

    @PutMapping("/delete")
    public String delete(@RequestBody String name){

        String result = memberService.delete(name);

        if ("Success".equalsIgnoreCase(result)) return "Success";
        else return "Fail";
    }

    @GetMapping("/init")
    public String init(){
        String result = memberService.init();

        if ("Success".equalsIgnoreCase(result)) return "Success";
        else return "Fail";
    }

}
