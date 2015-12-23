package com.adamchilds.passman.authentication.model;

/**
 * Singleton instance of a simple authentication provider/manager. Handles maintaining the authenticated {@link
 * PassManUser}. Allows applications to maintain a single authenticated user at any time.
 */
public class AuthenticationProvider {

    private static AuthenticationProvider PROVIDER;
    private PassManUser user;

    /**
     * Provides the current singleton instance of the {@link AuthenticationProvider}.
     *
     * @return the current instance of the {@link AuthenticationProvider}
     */
    public static AuthenticationProvider getInstance() {
        if (PROVIDER == null) {
            PROVIDER = new AuthenticationProvider();
        }

        return PROVIDER;
    }

    /**
     * Returns the currently authenticated {@link PassManUser}.
     *
     * @return the currently authenticated user
     */
    public PassManUser getAuthenticatedUser() {
        return user;
    }

    public void setAuthenticatedUser(PassManUser user) {
        this.user = user;
    }

    private AuthenticationProvider() { }

}