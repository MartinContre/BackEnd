package util;

import java.text.DecimalFormat;

public class NumberUtils {

    public static String numberFormat(double val) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(false);

        String formattedNumber = decimalFormat.format(val);

        if (formattedNumber.endsWith("0.0")) {
            formattedNumber = formattedNumber.substring(0, formattedNumber.length() - 2);
        }

        return formattedNumber;
    }
}
