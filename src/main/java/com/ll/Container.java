import com.ll.db.DBConnection;
import com.ll.member.Member;

import java.util.Scanner;

public class Container {
    private static Scanner sc;
    private static DBConnection dbConnection;
    public static Member loginedMember;

    public static void init() {
        sc = new Scanner(System.in);
        dbConnection = new DBConnection();
        dbConnection.connect();
    }

    public static void close() {
        sc.close();
        dbConnection.close();
    }

    public static Scanner getSc() {
        return sc;
    }

    public static DBConnection getDBConnection() {
        return dbConnection;
    }
}
