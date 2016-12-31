package com.github.adchilds.passman.io;

import com.github.adchilds.passman.settings.model.PassManSettings;
import com.github.adchilds.passman.settings.service.PassManSettingsService;
import com.github.adchilds.passman.settings.service.PassManSettingsServiceImpl;
import com.github.adchilds.passman.util.PassManConstants;
import com.github.adchilds.passman.util.PassManUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 */
public class PassManIO {

    private static PassManSettingsService settingsService = new PassManSettingsServiceImpl();

    /**
     *
     * @return
     */
    public static boolean doesSettingsFileExist() {
        if (PassManUtil.isMac() || PassManUtil.isUnix()) {
            return new File(PassManConstants.DEFAULT_FILE_LOCATION_UNIX + PassManConstants.SETTINGS_FILE_NAME).exists();
        } else if (PassManUtil.isWindows()) {
            return new File(PassManConstants.DEFAULT_FILE_LOCATION_WIN + PassManConstants.SETTINGS_FILE_NAME).exists();
        } else if (PassManUtil.isSolaris()) {
            return false;
        } else {
            System.out.println("Unsupported Operating System, could not detect if settings file exists.");

            return false;
        }
    }

    /**
     *
     */
    public static void createSettingsFile() {
        File directory = null;
        File file = null;

        if (PassManUtil.isMac() || PassManUtil.isUnix()) {
            directory = new File(PassManConstants.DEFAULT_FILE_LOCATION_UNIX);
            file = new File(PassManConstants.DEFAULT_FILE_LOCATION_UNIX + PassManConstants.SETTINGS_FILE_NAME);
        } else if (PassManUtil.isWindows()) {
            directory = new File(PassManConstants.DEFAULT_FILE_LOCATION_WIN);
            file = new File(PassManConstants.DEFAULT_FILE_LOCATION_WIN + PassManConstants.SETTINGS_FILE_NAME);
        } else if (PassManUtil.isSolaris()) {

        } else {
            // TODO: Log an error
            return;
        }

        try {
            // Make any directories needed
            directory.mkdirs();

            // Create the file (settings.passman
            file.createNewFile();
        } catch (Exception e) {
            // TODO: Log an error
        }

        // Populate the file with default settings
        PassManSettings settings = settingsService.createDefault();
        String settingsAsJson = settingsService.toJSON(settings);
        String encryptedSettings = settingsService.encryptJSON(settingsAsJson);

        writeStringToFile(file, encryptedSettings);
    }

    /**
     *
     * @param file
     * @param value
     */
    public static void writeStringToFile(File file, String value) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file.getAbsolutePath());

            System.out.println("Writing to file: " + file.getAbsolutePath());
            writer.print(value);
        } catch (FileNotFoundException e) {
            // TODO: Log an error
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }

    /**
     *
     * @param file
     * @return
     */
    public static String readFileToString(File file) {
        return "";
    }

    /**
     *
     * @return
     */
    public static long determineNextUserId() {
        return 0L;
    }

}