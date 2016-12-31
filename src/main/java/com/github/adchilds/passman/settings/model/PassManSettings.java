package com.github.adchilds.passman.settings.model;

import com.github.adchilds.passman.user.model.PassManUser;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class PassManSettings implements Serializable {

    private String randomSalt;
    private Date programFirstOpenDate;
    private PassManUser[] users;

    public String getRandomSalt() {
        return randomSalt;
    }

    public void setRandomSalt(String randomSalt) {
        this.randomSalt = randomSalt;
    }

    public Date getProgramFirstOpenDate() {
        return programFirstOpenDate;
    }

    public void setProgramFirstOpenDate(Date programFirstOpenDate) {
        this.programFirstOpenDate = programFirstOpenDate;
    }

    public PassManUser[] getUsers() {
        return users;
    }

    public void setUsers(PassManUser[] users) {
        this.users = users;
    }

    /**
     *
     * @param user
     */
    public void addUser(PassManUser user) {
        PassManUser[] existingUsers = getUsers();

        if (existingUsers == null) {
            existingUsers = new PassManUser[0];
        }

        PassManUser[] newUsers = new PassManUser[existingUsers.length + 1];

        for (int i = 0; i < existingUsers.length; i++) {
            newUsers[i] = existingUsers[i];
        }

        newUsers[existingUsers.length] = user;

        setUsers(newUsers);
    }

}