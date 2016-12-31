package com.github.adchilds.passman.form.validation;

import com.github.adchilds.passman.form.model.AbstractForm;

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

    /**
     *
     * @param form
     * @return
     */
    String reason(AbstractForm form);

}