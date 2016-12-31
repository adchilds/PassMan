package com.github.adchilds.passman.settings.service;

import com.github.adchilds.passman.security.SecurityUtil;
import com.github.adchilds.passman.settings.model.PassManSettings;
import com.github.adchilds.passman.user.model.PassManUser;
import com.github.adchilds.passman.util.PassManConstants;
import com.github.adchilds.passman.util.PassManUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * {@inheritDoc}
 */
public class PassManSettingsServiceImpl implements PassManSettingsService {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     *
     * @return
     */
    @Override
    public PassManSettings createDefault() {
        PassManSettings settings = new PassManSettings();

        settings.setUsers(new PassManUser[0]);
        settings.setRandomSalt(SecurityUtil.generateRandomSalt());
        settings.setProgramFirstOpenDate(new Date());

        return settings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PassManSettings getCurrentSettings() {
        File file = null;
        if (PassManUtil.isMac() || PassManUtil.isUnix()) {
            file = new File(PassManConstants.DEFAULT_FILE_LOCATION_UNIX + PassManConstants.SETTINGS_FILE_NAME);
        } else if (PassManUtil.isWindows()) {
            file = new File(PassManConstants.DEFAULT_FILE_LOCATION_WIN + PassManConstants.SETTINGS_FILE_NAME);
        } else if (PassManUtil.isSolaris()) {

        } else {
            // TODO: Log an error
            return createDefault();
        }

        if (file == null) {
            return createDefault();
        }

        return fromEncryptedFile(file);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateSettings(PassManSettings settings) {
        // Clear the old file
        File file = null;
        if (PassManUtil.isMac() || PassManUtil.isUnix()) {
            file = new File(PassManConstants.DEFAULT_FILE_LOCATION_UNIX + PassManConstants.SETTINGS_FILE_NAME);
        } else if (PassManUtil.isWindows()) {
            file = new File(PassManConstants.DEFAULT_FILE_LOCATION_WIN + PassManConstants.SETTINGS_FILE_NAME);
        } else if (PassManUtil.isSolaris()) {

        } else {
            // TODO: Log an error
        }

        if (file == null) {
            // TODO: Log an error
            return;
        }

        // Write the new file
        String settingsAsJson = toJSON(settings);
        String encryptedSettings = encryptJSON(settingsAsJson);

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(file, false));

            System.out.println("Writing to file: " + file.getAbsolutePath());
            writer.print(encryptedSettings);
        } catch (Exception e) {
            // TODO: Log an error
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toJSON(PassManSettings settings) {
        return gson.toJson(settings);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PassManSettings fromJSON(String json) {
        return gson.fromJson(json, PassManSettings.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String encryptJSON(String json) {
        try {
            return SecurityUtil.encrypt(json);
        } catch (Exception e) {
            // TODO: Log an error
        }

        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String decryptJSON(String json) {
        try {
            return SecurityUtil.decrypt(json);
        } catch (Exception e) {
            // TODO: Log an error
        }

        return "";
    }

    /**
     *
     * @param file
     */
    private PassManSettings fromEncryptedFile(File file) {
        Path filePath = Paths.get(file.getAbsolutePath());

        byte[] fileBytes = null;
        try {
            fileBytes = Files.readAllBytes(filePath);
        } catch (Exception e) {
            // TODO: Log an error
        }

        if (fileBytes == null) {
            return createDefault();
        }

        String encryptedContents = new String(fileBytes);
        String decryptedContents = decryptJSON(encryptedContents);

        return fromJSON(decryptedContents);
    }

}