package com.github.adchilds.passman.user.service.impl;

import com.github.adchilds.passman.form.model.RegistrationForm;
import com.github.adchilds.passman.settings.model.PassManSettings;
import com.github.adchilds.passman.settings.service.PassManSettingsService;
import com.github.adchilds.passman.settings.service.PassManSettingsServiceImpl;
import com.github.adchilds.passman.authentication.model.AuthenticationProvider;
import com.github.adchilds.passman.user.model.PassManUser;
import com.github.adchilds.passman.user.service.PassManUserService;

import java.util.Arrays;
import java.util.Date;

/**
 *
 */
public class PassManUserServiceImpl implements PassManUserService {

    private AuthenticationProvider authenticationProvider = AuthenticationProvider.getInstance();
    private PassManSettingsService settingsService = new PassManSettingsServiceImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean authenticate(String username, char[] password) {
        // Find the user that is attempting to authenticate
        PassManUser userAttemptingAuthentication = getUserByUsername(username);

        if (userAttemptingAuthentication == null) {
            return false;
        }

        // Determine if the given password matches the user's actual password
        return Arrays.equals(password, userAttemptingAuthentication.getPassword());
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
    public PassManUser getUserByUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return null;
        }

        PassManSettings settings = settingsService.getCurrentSettings();
        PassManUser[] users = settings.getUsers();

        // Find the user that is attempted to login
        for (PassManUser user : users) {
            if (username.equals(user.getEmailAddress())) {
                return user;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(RegistrationForm form) {
        PassManUser user = new PassManUser();

        user.setId(0L);
        user.setEmailAddress(form.getEmailAddress());
        user.setUsername(form.getEmailAddress());
        user.setPassword(form.getPassword());
        user.setCreatedDate(new Date());

        PassManSettings settings = settingsService.getCurrentSettings();
        settings.addUser(user);

        settingsService.updateSettings(settings);
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
    public PassManUser read(String emailAddress) {
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