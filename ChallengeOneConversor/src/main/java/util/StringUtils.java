package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for manipulating strings.
 */
public class StringUtils {
    private static final Logger logger = LogManager.getLogger(StringUtils.class);

    /**
     * Deletes all characters from the input string except the first three characters.
     *
     * @param str The input string.
     * @return The modified string containing only the first three characters.
     */
    public static String deleteAllExceptFirstThree(String str) {
        if (str.length() <= 3) {
            logger.warn("String length is less than or equal to 3. No characters were deleted.");
            return str;
        }
        String modifiedString = str.substring(0, 3);
        logger.info("Modified string: " + modifiedString);
        return modifiedString;    }
}
