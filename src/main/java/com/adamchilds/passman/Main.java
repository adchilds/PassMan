package com.adamchilds.passman;

import javax.swing.*;

/**
 *
 */
public class Main {

    private static final AppController APP_CONTROLLER = new AppController();

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(APP_CONTROLLER::initialize);
    }

}
