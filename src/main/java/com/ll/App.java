package com.ll;

import com.ll.article.ArticleController;
import com.ll.db.DBConnection;
import com.ll.member.MemberController;
import com.ll.system.SystemController;

public class App {
    private final ArticleController articleController;
    private final SystemController systemController;
    private final MemberController memberController;

    public App() {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";

        Container.init();

        articleController = new ArticleController();
        systemController = new SystemController();
        memberController = new MemberController();
    }

    public void run() {
        System.out.println("== 게시판 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();

            if (command.isEmpty()) continue;

            Request request = new Request(command);
            String action = request.getActionCode();

            switch (action) {
                case "종료" -> {
                    systemController.exit();
                    Container.close();
                    return;
                }
                case "등록" -> {
                    if (!Session.isLoggedIn()) {
                        System.out.println("로그인 후 이용해주세요.");
                        break;
                    }
                    articleController.write();
                }
                case "목록" -> articleController.list();
                case "회원가입" -> memberController.join();
                case "로그인" -> memberController.login();
                case "로그아웃" -> memberController.logout();
                default -> {
                    if (action.startsWith("삭제")) {
                        articleController.delete(request);
                    } else if (action.startsWith("수정")) {
                        articleController.modify(request);
                    } else {
                        System.out.println("알 수 없는 명령입니다.");
                    }
                }
            }
        }
    }
}
