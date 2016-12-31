package com.github.adchilds.passman.authentication.service.impl;

import com.github.adchilds.passman.authentication.model.AuthenticationProvider;
import com.github.adchilds.passman.authentication.model.PassManUser;
import com.github.adchilds.passman.authentication.service.PassManUserService;

/**
 *
 */
public class PassManUserServiceImpl implements PassManUserService {

    private AuthenticationProvider authenticationProvider = AuthenticationProvider.getInstance();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean authenticate(String username, char[] password) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isUserAuthenticated() {
        return authenticationProvider.getAuthenticatedUser() != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(PassManUser user) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PassManUser read(long id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PassManUser read(PassManUser user) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(PassManUser user) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(PassManUser user) {

    }

}