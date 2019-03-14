package services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class CryptoService {

    public static String generateDigest(String salt, String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");

        String plaintext = password + salt;
        byte[] plaintextBytes = plaintext.getBytes(StandardCharsets.UTF_8);

        return Base64.getEncoder().encodeToString(digest.digest(plaintextBytes));
    }


    public static String generateSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

        byte[] saltBytes = new byte[20];
        sr.nextBytes(saltBytes);

        return Base64.getEncoder().encodeToString(saltBytes);
    }


    public static boolean isExpectedPass(String salt, String password, String hashedPassword) throws NoSuchAlgorithmException {
        return generateDigest(salt, password).equals(hashedPassword);
    }

}
