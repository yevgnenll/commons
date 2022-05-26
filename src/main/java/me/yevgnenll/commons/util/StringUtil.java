package me.yevgnenll.commons.util;

import java.util.regex.Pattern;

public class StringUtil {

    private StringUtil() {}

    private static final Pattern pattern = Pattern.compile("(^[\\p{Alnum}.\\-_]+@[\\p{Alnum}]+(\\.[\\p{Alnum}]+)+$)");

    public static boolean isEmailFormat(String email) {
        Checks.notNull(email, "Email param must not be null.");
        return pattern.matcher(email).matches();
    }

}
