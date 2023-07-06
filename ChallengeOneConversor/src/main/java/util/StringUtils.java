package util;

/**
 * Utility class for manipulating strings.
 */
public class StringUtils {

    /**
     * Deletes all characters from the input string except the first three characters.
     *
     * @param sr The input string.
     * @return The modified string containing only the first three characters.
     */
    public static String deleteAllExceptFirstThree(String sr) {
        return sr.substring(0,3);
    }
}
