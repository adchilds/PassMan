package com.github.adchilds.passman.form.validation.util;

import java.util.regex.Pattern;

/**
 *
 */
public class ValidationUtils {

    private static final Pattern PATTERN_EMAIL = Pattern.compile("([a-zA-Z0-9]+)@([a-zA-Z0-9]+).(com|net|org|edu|co\\.uk|gov)");

    /**
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        return value == null || "".equals(value.trim());
    }

    /**
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(char[] value) {
        return value.length <= 0;
    }

    /**
     *
     * @param value
     * @return
     */
    public static boolean isEmail(String value) {
        return PATTERN_EMAIL.matcher(value).matches();
    }

    /**
     *
     * @param value1
     * @param value2
     * @return
     */
    public static boolean valuesMatch(char[] value1, char[] value2) {
        if (value1.length != value2.length) {
            return false;
        }

        for (int i = 0; i < value1.length; i++) {
            if (value1[i] != value2[i]) {
                return false;
            }
        }

        return true;
    }

}