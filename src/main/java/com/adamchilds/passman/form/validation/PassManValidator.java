package com.adamchilds.passman.form.validation;

import com.adamchilds.passman.form.model.AbstractForm;

/**
 *
 */
public interface PassManValidator {

    /**
     *
     * @param form
     * @return
     */
    boolean supports(AbstractForm form);

    /**
     *
     * @param form
     * @return
     */
    boolean isValid(AbstractForm form);

}