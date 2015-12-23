package com.adamchilds.passman.form.model;

/**
 *
 */
public class LoginForm extends AbstractForm {

    private String username;
    private char[] password;

    public LoginForm(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

}