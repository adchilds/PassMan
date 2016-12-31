package com.github.adchilds.passman.authentication.service;

import com.github.adchilds.passman.authentication.model.PassManUser;

/**
 *
 */
public interface PassManUserService {

    /**
     *
     * @param username
     * @param password
     * @return
     */
    boolean authenticate(String username, char[] password);

    /**
     *
     * @return
     */
    boolean isUserAuthenticated();

    /**
     *
     * @param user
     */
    void create(PassManUser user);

    /**
     *
     * @param id
     * @return
     */
    PassManUser read(long id);

    /**
     *
     * @param user
     * @return
     */
    PassManUser read(PassManUser user);

    /**
     *
     * @param user
     */
    void update(PassManUser user);

    /**
     *
     * @param user
     */
    void delete(PassManUser user);

}