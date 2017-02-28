package com.github.adchilds.passman.util;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 *
 */
public class PassManConstants {

    public static final String JFRAME_TITLE = "PassMan v1.0";

    /*
     * General frame
     */
    public static final int JFRAME_WIDTH = 650;
    public static final int JFRAME_HEIGHT = 700;

    /*
     * Panel defaults
     */
    public static final Border PANEL_DEFAULT_BORDER = new EmptyBorder(10, 10, 0, 10);
    public static final Color PANEL_DEFAULT_BACKGROUND_COLOR = new Color(200, 200, 200);

    /*
     * Label defaults
     */
    public static final Color LABEL_DEFAULT_COLOR_ERROR = new Color(255, 0, 0);

    /*
     * Login
     */
    public static final int LOGIN_BORDER_TOP = 235;
    public static final int LOGIN_BORDER_LEFT = 200;
    public static final int LOGIN_PANEL_WIDTH = 250;
    public static final int LOGIN_PANEL_HEIGHT = 275;
    public static final int LOGIN_TEXTFIELD_HEIGHT = 35;
    public static final int LOGIN_TEXTFIELD_WIDTH = 225;

    /*
     * Registration
     */
    public static final int REG_BORDER_TOP = 175;
    public static final int REG_BORDER_LEFT = 200;
    public static final int REG_PANEL_WIDTH = 250;
    public static final int REG_PANEL_HEIGHT = 275;

    public static final String COMMAND_SIGN_IN = "command_signin";
    public static final String COMMAND_REGISTER_SUBMIT = "command_register_submit";
    public static final String COMMAND_REGISTER_CANCEL = "command_register_cancel";

    /*
     * File IO
     */
    public static final String DEFAULT_FILE_LOCATION_UNIX = "/usr/local/PassMan/";
    public static final String DEFAULT_FILE_LOCATION_WIN = "C:\\Documents\\PassMan\\";
    public static final String SETTINGS_FILE_NAME = "settings.passman";

    /*
     * Internal security values
     */
    public static final String PASSMAN_SALT = "p4s5M@n_$4|t-m1]";

}