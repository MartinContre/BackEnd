package util;

import java.text.DecimalFormat;

/**
 * Utility class for formatting numbers.
 */
public class NumberUtils {

    /**
     * Formats a number using a specific pattern.
     *
     * @param val The number to format.
     * @return The formatted number as a string.
     */
    public static String numberFormat(double val) {
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        decimalFormat.setGroupingUsed(false);

        String formattedNumber = decimalFormat.format(val);

        if (formattedNumber.endsWith("0.0")) {
            formattedNumber = formattedNumber.substring(0, formattedNumber.length() - 2);
        }

        return formattedNumber;
    }
}
