package com.github.adchilds.passman;

import com.github.adchilds.passman.authentication.model.PassManUser;
import com.github.adchilds.passman.ui.MainFrame;
import com.github.adchilds.passman.ui.panel.LoginPanel;

/**
 *
 */
public class AppController {

    private MainFrame frame;

    /**
     *
     */
    public void initialize() {
        // Create the secure file


        // Show the UI
        createAndShowGUI();
    }

    /**
     *
     */
    private void createAndShowGUI() {
        frame = new MainFrame();

        MainFrame.displayPanel(
                new LoginPanel(
                        frame,
                        PassManConstants.LOGIN_BORDER_TOP,
                        PassManConstants.LOGIN_BORDER_LEFT,
                        PassManConstants.LOGIN_PANEL_HEIGHT,
                        PassManConstants.LOGIN_PANEL_WIDTH
                )
        );

        frame.setVisible(true);
    }

    /**
     *
     * @param user
     */
    public void createUser(PassManUser user) {

    }

    /**
     *
     * @param username
     * @param password
     */
    public void attemptLogin(String username, String password) {
        // Authenticate the user

        // If successful, show the main view with the user's passwords

        // If not successful, show an error message

    }

    /**
     *
     */
    public void logout() {

    }

}