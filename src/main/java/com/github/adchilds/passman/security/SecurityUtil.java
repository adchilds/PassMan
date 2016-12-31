package com.github.adchilds.passman.security;

import com.github.adchilds.passman.util.PassManConstants;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class SecurityUtil {

    private static Random random = new SecureRandom();
    private static Key aesKey = new SecretKeySpec(PassManConstants.PASSMAN_SALT.getBytes(), "AES");

    /**
     *
     * @param value
     * @return
     * @throws Exception
     */
    public static String encrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(value.getBytes());

        return DatatypeConverter.printHexBinary(encrypted);
    }

    /**
     *
     * @param value
     * @return
     * @throws Exception
     */
    public static String decrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");

        byte[] nonHexValue = DatatypeConverter.parseHexBinary(value);

        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] decryptedBytes = cipher.doFinal(nonHexValue);
        return new String(decryptedBytes);
    }

    /**
     *
     * @return
     */
    public static String generateRandomSalt() {
        byte[] salt = new byte[16];

        random.nextBytes(salt);

        return Base64.getEncoder().encodeToString(salt);
    }

}