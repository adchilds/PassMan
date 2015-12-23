package com.adamchilds.passman.form.validation;

import com.adamchilds.passman.form.model.AbstractForm;
import com.adamchilds.passman.form.model.RegistrationForm;
import com.adamchilds.passman.form.validation.util.ValidationUtils;

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

        return true;
    }

}