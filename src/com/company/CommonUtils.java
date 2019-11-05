package com.company;

import java.util.regex.Pattern;

public class CommonUtils {
    public static boolean isValidName(String text) {
        Pattern pattern = Pattern.compile("[^/./\\:*?\"<>|]");
        return !pattern.matcher(text).find();
    }
}
