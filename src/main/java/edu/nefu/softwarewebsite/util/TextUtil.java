package edu.nefu.softwarewebsite.util;

public class TextUtil {
    // 判断字符串是否为空
    public static boolean isEmpty(String str) {
        if (str == null || str.equals(" ")) {
            return true;
        }
        return false;
    }
}
