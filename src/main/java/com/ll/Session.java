package com.ll;

public class Session {
    private static Member loggedInMember = null;

    public static void login(Member member) {
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