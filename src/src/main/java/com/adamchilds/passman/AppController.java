package com.adamchilds.passman;

import com.adamchilds.passman.authentication.model.PassManUser;
import com.adamchilds.passman.ui.MainFrame;

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

        frame.showLoginScreen();

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