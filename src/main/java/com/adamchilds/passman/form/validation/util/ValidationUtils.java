package com.adamchilds.passman.form.validation.util;

/**
 *
 */
public class ValidationUtils {

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