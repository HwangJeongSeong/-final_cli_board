package com.ll;

public class Util {
    public static String escape(String str) {
        if (str == null) return "";
        return str.replace("\\", "\\\\").replace("'", "\\'");
    }
}
