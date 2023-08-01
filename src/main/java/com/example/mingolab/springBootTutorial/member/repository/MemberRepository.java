package com.example.mingolab.springBootTutorial.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mingolab.springBootTutorial.member.repository.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
}
