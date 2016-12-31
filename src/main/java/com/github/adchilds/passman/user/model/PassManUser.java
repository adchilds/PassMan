package com.github.adchilds.passman.user.model;

import com.github.adchilds.passman.io.PassManIO;

import java.util.Date;

/**
 *
 */
public class PassManUser {

    private Long id;
    private String username;
    private char[] password; // Hashed
    private String emailAddress;
    private String secretPhrase; // Hashed
    private Date createdDate;
    private Date lastLoginDate;
    private Credentials[] credentials;

    /**
     * Creates a new {@link PassManUser} with the given {@code username} and {@code password}.
     *
     * @param username the username
     * @param password the password
     * @return a new {@link PassManUser} with the given credentials
     */
    public static PassManUser create(String username, char[] password) {
        PassManUser user = new PassManUser();

        user.setId(PassManIO.determineNextUserId());
        user.setUsername(username);
        user.setPassword(password);
        user.setCreatedDate(new Date());

        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

}