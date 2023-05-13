package api.touchbase.utils;

import java.util.Random;

public class IdGenerator {
    private static final Random random = new Random();
    public static String generateId() {
        String id = "";

        for (int i = 0; i < 8; i++) {
            int lowerCaseOrUpperCaseOrNumber = randomInt(0, 2);
            int character = 97;

            if (lowerCaseOrUpperCaseOrNumber == 0) {
                character = randomInt(65, 90);
            }
            if (lowerCaseOrUpperCaseOrNumber == 1) {
                character = randomInt(97, 122);
            }
            if (lowerCaseOrUpperCaseOrNumber == 2) {
                character = randomInt(48, 57);
            }

            id = id.concat(Character.toString((char) character));
        }

        return id;
    }

    private static int randomInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
