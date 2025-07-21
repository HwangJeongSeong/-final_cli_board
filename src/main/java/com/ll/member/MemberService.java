package com.ll.member;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public int join(String userId, String password) {
        return memberRepository.save(userId, password);
    }

    public Member findByUserId(String userId) {
        return memberRepository.findByUserId(userId);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}