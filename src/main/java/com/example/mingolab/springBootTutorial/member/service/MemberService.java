package com.example.mingolab.springBootTutorial.member.service;

import com.example.mingolab.springBootTutorial.member.controller.dto.JoinRequest;

public interface MemberService {
    String join(JoinRequest joinRequest);
    String delete(String name);
    String init();
}
