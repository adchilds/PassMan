package com.github.adchilds.passman.form.validation;

import com.github.adchilds.passman.form.model.AbstractForm;
import com.github.adchilds.passman.form.model.LoginForm;

/**
 *
 */
public class LoginFormValidator implements PassManValidator {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(AbstractForm form) {
        return (form instanceof LoginForm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(AbstractForm form) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String reason(AbstractForm form) {
        return "";
    }

}