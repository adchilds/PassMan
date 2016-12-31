package com.github.adchilds.passman.util;

/**
 *
 */
public class PassManUtil {

    private static final String OS = System.getProperty("os.name").toLowerCase();

    /**
     *
     * @return
     */
    public static boolean isWindows() {
        return OS.contains("win");
    }

    /**
     *
     * @return
     */
    public static boolean isMac() {
        return OS.contains("mac");
    }

    /**
     *
     * @return
     */
    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0 );
    }

    /**
     *
     * @return
     */
    public static boolean isSolaris() {
        return (OS.contains("sunos"));
    }

}