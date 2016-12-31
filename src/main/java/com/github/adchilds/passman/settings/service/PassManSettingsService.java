package com.github.adchilds.passman.settings.service;

import com.github.adchilds.passman.settings.model.PassManSettings;

/**
 *
 */
public interface PassManSettingsService {

    /**
     *
     * @return
     */
    PassManSettings createDefault();

    /**
     *
     * @return
     */
    PassManSettings getCurrentSettings();

    /**
     *
     * @param settings
     */
    void updateSettings(PassManSettings settings);

    /**
     *
     * @param settings
     * @return
     */
    String toJSON(PassManSettings settings);

    /**
     *
     * @param json
     * @return
     */
    PassManSettings fromJSON(String json);

    /**
     *
     * @param json
     * @return
     */
    String encryptJSON(String json);

    /**
     *
     * @param json
     * @return
     */
    String decryptJSON(String json);

}