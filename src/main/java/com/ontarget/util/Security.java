package com.ontarget.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by IntelliJ IDEA.
 * User: sumit
 * Date: 4/25/13
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Security {

    private final static SecureRandom sr = new SecureRandom();
    private static MessageDigest pdigest;

    static {
        try {
            pdigest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            pdigest = null;
        }
    }

    public static String encodePassword(String password, String salt) {
        try {
            BigInteger val = new BigInteger(salt);
            return getDigest((MessageDigest) pdigest.clone(), password, val.toByteArray()).toString();
        } catch (CloneNotSupportedException e) {
        }

        return password;
    }

    public static BigInteger getDigest(MessageDigest digest, String password, byte[] salt) {
        byte[] output = digest.digest(password.getBytes());
        digest.update(salt); // how is salt generated
        digest.update(output);
        return new BigInteger(1, digest.digest());
    }

    public static String generateSecureSalt() {
        byte[] salt = new byte[128];
        return getSecureRandom(salt);
    }

    public static String generateRandomValue(final int len) {
        byte[] salt = new byte[len];
        return getSecureRandom(salt);
    }

    private static String getSecureRandom(byte[] salt) {
        synchronized (sr) {
            sr.nextBytes(salt);
        }
        return new BigInteger(salt).abs().toString();
    }

}
