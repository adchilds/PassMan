package com.github.adchilds.passman.user.service;

import com.github.adchilds.passman.form.model.RegistrationForm;
import com.github.adchilds.passman.user.model.PassManUser;

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
     * @param emailAddress
     * @return
     */
    boolean exists(String emailAddress);

    /**
     *
     * @param username
     * @return
     */
    PassManUser getUserByUsername(String username);

    /**
     *
     * @param form
     */
    void create(RegistrationForm form);

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
     * @param emailAddress
     * @return
     */
    PassManUser read(String emailAddress);

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