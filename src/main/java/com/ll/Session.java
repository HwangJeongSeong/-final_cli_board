package com.ll;

import com.ll.member.Member;

public class Session {
    private static Member loggedInMember = null;

    public static void login(Member member) {
        if (member == null) throw new IllegalArgumentException("member는 null안됨");
        loggedInMember = member;
    }

    public static void logout() {
        loggedInMember = null;
    }

    public static Member getLoggedInMember() {
        return loggedInMember;
    }

    public static boolean isLoggedIn() {
        return loggedInMember != null;
    }
}