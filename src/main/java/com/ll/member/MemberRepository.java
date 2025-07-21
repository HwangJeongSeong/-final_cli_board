package com.ll.member;

import com.ll.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    public int save(String userId, String password) {
        String sql = String.format("INSERT INTO member SET userId = '%s', password = '%s', regDate = NOW()", userId, password);
        return Container.getDBConnection().insert(sql);
    }

    public Member findByUserId(String userId) {
        String sql = String.format("SELECT * FROM member WHERE userId = '%s'", userId);
        Map<String, Object> row = Container.getDBConnection().selectRow(sql);

        if (row.isEmpty()) return null;

        return new Member(row);
    }

    public Member findById(int id) {
        String sql = String.format("SELECT * FROM member WHERE id = %d", id);
        Map<String, Object> row = Container.getDBConnection().selectRow(sql);

        if (row.isEmpty()) return null;

        return new Member(row);
    }

    public List<Member> findAll() {
        String sql = "SELECT * FROM member ORDER BY id DESC";
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows(sql);

        List<Member> members = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            members.add(new Member(row));
        }

        return members;
    }
}
