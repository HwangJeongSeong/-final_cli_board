package com.ll.member;

import com.ll.Container;
import com.ll.Request;
import com.ll.Session;

import java.util.Scanner;

public class MemberController {
    private final MemberService memberService;
    private Member loginedMember;

    public MemberController() {
        memberService = new MemberService();
    }

    public void join() {
        Scanner sc = Container.getSc();

        System.out.print("아이디: ");
        String userId = sc.nextLine().trim();

        System.out.print("비밀번호: ");
        String password = sc.nextLine().trim();

        Member existing = memberService.findByUserId(userId);
        if (existing != null) {
            System.out.println("이미 사용 중인 아이디입니다.");
            return;
        }

        int id = memberService.join(userId, password);
        System.out.printf("%d번 회원이 생성되었습니다.\n", id);
    }

    public void login() {
        Scanner sc = Container.getSc();

        System.out.print("아이디: ");
        String userId = sc.nextLine().trim();

        System.out.print("비밀번호: ");
        String password = sc.nextLine().trim();

        Member member = memberService.findByUserId(userId);

        if (member == null || !member.getPassword().equals(password)) {
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
            return;
        }

        Session.login(member);
        System.out.printf("%s님 환영합니다.\n", member.getUserId());
    }

    public void logout() {
        loginedMember = null;
        System.out.println("로그아웃 되었습니다.");
    }

    public Member getLoginedMember() {
        return loginedMember;
    }
}
