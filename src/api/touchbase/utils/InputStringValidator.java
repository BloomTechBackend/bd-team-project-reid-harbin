package api.touchbase.utils;

import java.util.regex.Pattern;

public class InputStringValidator {
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern NUMBER_CHARACTER_PATTERN = Pattern.compile("[0-9]");
    private static final Pattern SPACE_CHARACTER_PATTERN = Pattern.compile("\\s");

    public static boolean isValidPassword(final String passwordToValidate) {

        if (passwordToValidate == null || passwordToValidate.isBlank()) {
            return false;
        }

        if (SPACE_CHARACTER_PATTERN.matcher(passwordToValidate).find()) {
            return false;
        }

        if (!LOWERCASE_PATTERN.matcher(passwordToValidate).find() &&
                !UPPERCASE_PATTERN.matcher(passwordToValidate).find() &&
                !NUMBER_CHARACTER_PATTERN.matcher(passwordToValidate).find()) {
            return false;
        }

        return true;
    }
}
