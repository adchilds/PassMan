package com.github.adchilds.passman.form.model;

/**
 *
 */
public class RegistrationForm extends AbstractForm {

    private String emailAddress;
    private char[] password;
    private char[] passwordConfirmation;
    private String secretPhrase;

    public RegistrationForm(String emailAddress, char[] password, char[] passwordConfirmation, String secretPhrase) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.secretPhrase = secretPhrase;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public char[] getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(char[] passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getSecretPhrase() {
        return secretPhrase;
    }

    public void setSecretPhrase(String secretPhrase) {
        this.secretPhrase = secretPhrase;
    }
}