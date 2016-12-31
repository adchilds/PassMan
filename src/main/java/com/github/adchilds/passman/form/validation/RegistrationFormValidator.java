package com.github.adchilds.passman.form.validation;

import com.github.adchilds.passman.form.model.AbstractForm;
import com.github.adchilds.passman.form.model.RegistrationForm;
import com.github.adchilds.passman.form.validation.util.ValidationUtils;

/**
 *
 */
public class RegistrationFormValidator implements PassManValidator {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(AbstractForm form) {
        return (form instanceof RegistrationForm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(AbstractForm form) {
        RegistrationForm registrationForm = (RegistrationForm) form;

        if (ValidationUtils.isEmpty(registrationForm.getEmailAddress())) {
            return false;
        } else if (ValidationUtils.isEmpty(registrationForm.getSecretPhrase())) {
            return false;
        } else if (ValidationUtils.isEmpty(registrationForm.getPassword())) {
            return false;
        } else if (ValidationUtils.isEmpty(registrationForm.getPasswordConfirmation())) {
            return false;
        }

        if (!ValidationUtils.valuesMatch(registrationForm.getPassword(), registrationForm.getPasswordConfirmation())) {
            return false;
        }

        if (!ValidationUtils.isEmail(registrationForm.getEmailAddress())) {
            return false;
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String reason(AbstractForm form) {
        RegistrationForm registrationForm = (RegistrationForm) form;

        if (ValidationUtils.isEmpty(registrationForm.getEmailAddress())) {
            return "Email address is missing.";
        } else if (!ValidationUtils.isEmail(registrationForm.getEmailAddress())) {
            return "Invalid email address.";
        } else if (ValidationUtils.isEmpty(registrationForm.getPassword())) {
            return "Password is missing.";
        } else if (ValidationUtils.isEmpty(registrationForm.getPasswordConfirmation())) {
            return "Confirmation password is missing";
        } else if (ValidationUtils.isEmpty(registrationForm.getSecretPhrase())) {
            return "Secret phrase is missing.";
        }

        if (!ValidationUtils.valuesMatch(registrationForm.getPassword(), registrationForm.getPasswordConfirmation())) {
            return "Passwords do not match.";
        }

        return "";
    }

}