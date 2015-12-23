package com.adamchilds.passman.form.validation;

import com.adamchilds.passman.form.model.AbstractForm;
import com.adamchilds.passman.form.model.LoginForm;

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

}