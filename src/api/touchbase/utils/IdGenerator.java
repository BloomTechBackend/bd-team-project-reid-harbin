package api.touchbase.utils;

import java.util.Random;
import java.util.UUID;

public class IdGenerator {
    private static final Random random = new Random();
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
