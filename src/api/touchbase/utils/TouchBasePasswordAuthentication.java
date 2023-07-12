package api.touchbase.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.Random;


public class TouchBasePasswordAuthentication {
    private static Argon2 argon2 = Argon2Factory.create();
    private static final String PEPPER = "b4x7ihb8p";
    private static String SALT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int SALT_LENGTH = 18;

    public static String getRandomSalt() {
        String salt = "";
        for (int i = 0; i < SALT_LENGTH; i++) {
            salt = salt.concat(Character.toString(SALT_CHARS.charAt(randomRangedIntValue(0, 34))));
        }
        return salt;
    }

    public static String hashPassword(String password) {
        String seasonedPassword = password.concat(PEPPER);

        String hashedPassword = argon2.hash(10, 65536, 1, seasonedPassword.toCharArray());

        argon2.wipeArray(seasonedPassword.toCharArray());
        return hashedPassword;
    }

    public static boolean isMatchingPassword(String storedSalt, String providedPassword, String storedPassword) {
        String seasonedProvidedPassword = storedSalt.concat(providedPassword.concat(PEPPER));

        boolean isMatchingPassword = argon2.verify(storedPassword, seasonedProvidedPassword.toCharArray());

        argon2.wipeArray(seasonedProvidedPassword.toCharArray());
        argon2.wipeArray(storedPassword.toCharArray());

        return isMatchingPassword;

    }

    private static int randomRangedIntValue(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}




