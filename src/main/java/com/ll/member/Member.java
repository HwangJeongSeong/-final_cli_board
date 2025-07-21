package com.ll.member;

import java.util.Map;

public class Member {
    private int id;
    private String userId;
    private String password;
    private String regDate;

    public Member(Map<String, Object> row) {
        this.id = (int) row.get("id");
        this.userId = (String) row.get("userId");
        this.password = (String) row.get("password");
        this.regDate = (String) row.get("regDate");
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getRegDate() {
        return regDate;
    }
}

