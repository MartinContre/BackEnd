package conversor;

import models.Conversion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.NumberUtils;

import javax.swing.*;

/**
 * Class that provides methods for converting temperatures and lengths.
 */
public class Converter {
    private static final Logger logger = LogManager.getLogger(Converter.class);
    private static final String ERROR_MSG_TEMP =  "Unidad de temperatura objetivo no válida: %s";
    private static final String ERROR_MSG_LENGTH = "Unidad de longitud objetivo no valida; %s";

    /**
     * Converts a temperature from a current unit to a target unit.
     *
     * @param conversion The temperature conversion containing the source unit, target unit, and initial value.
     * @return The converted value in string format.
     * @throws IllegalArgumentException If the base temperature unit is invalid.
     */
    public static String getConvertedTemperature(Conversion conversion) {
        double convertedNumber;
        switch (conversion.getCurrentUnit()) {
            case "Celsius" -> convertedNumber = convertCelsius(conversion.getInitialValue(), conversion.getTargetUnit());
            case "Fahrenheit" -> convertedNumber = convertFahrenheit(conversion.getInitialValue(), conversion.getTargetUnit());
            case "Kelvin" -> convertedNumber = convertKelvin(conversion.getInitialValue(), conversion.getTargetUnit());
            case "Rankine" -> convertedNumber = convertRankine(conversion.getInitialValue(), conversion.getTargetUnit());
            default -> {
                logger.error("Unidad de temperatura base no válida: " + conversion.getCurrentUnit());
                throw new IllegalArgumentException("Unidad de temperatura base no valida " + conversion.getCurrentUnit());
            }
        }
        return NumberUtils.numberFormat(convertedNumber);
    }

    /**
     * Converts a length from a current unit to a target unit.
     *
     * @param conversion The length conversion containing the source unit, target unit, and initial value.
     * @return The converted value in string format.
     * @throws IllegalArgumentException If the base length unit is invalid.
     */
    public static String getConvertedLength(Conversion conversion) {
        double convertedValue = 0.0;
        switch (conversion.getCurrentUnit()) {
            case "km" -> convertedValue = convertKm(conversion.getInitialValue(), conversion.getTargetUnit());
            case "m" -> convertedValue = convertM(conversion.getInitialValue(), conversion.getTargetUnit());
            case "mi" -> convertedValue = convertMi(conversion.getInitialValue(), conversion.getTargetUnit());
            case "ft" -> convertedValue = convertFt(conversion.getInitialValue(), conversion.getTargetUnit());
            case "in" -> convertedValue = convertIn(conversion.getInitialValue(), conversion.getTargetUnit());
            default -> {
                logger.error("Unidad de longitud base no válida: " + conversion.getCurrentUnit());
                JOptionPane.showMessageDialog(null, "Selecciona una opcion valida");
            }
        }
        return NumberUtils.numberFormat(convertedValue);
    }

    private static double convertCelsius(double value, String targetUnit) {
        double convertedValue;
        switch (targetUnit) {
            case "Fahrenheit" -> convertedValue = (value * 9 / 5) + 32;
            case "Kelvin" -> convertedValue = value + 273.15;
            case "Rankine" -> convertedValue = (value + 273.15) * 9 / 5;
            default -> {
                String errorMessage = String.format(ERROR_MSG_TEMP, targetUnit);
                logger.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
        }
        logger.info(String.format("Temperature conversion: %s Celsius to %s = %s", value, targetUnit, convertedValue));
        return convertedValue;
    }

    private static double convertFahrenheit(double value, String targetUnit) {
        double convertedValue;
        switch (targetUnit) {
            case "Celsius" -> convertedValue = (value - 32) * 5 / 9;
            case "Kelvin" -> convertedValue = (value + 459.67) * 5 / 9;
            case "Rankine" -> convertedValue = value + 459.67;
            default -> {
                String errorMessage = String.format(ERROR_MSG_TEMP, targetUnit);
                logger.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
        }
        logger.info(String.format("Temperature conversion: %s Fahrenheit to %s = %s", value, targetUnit, convertedValue));
        return convertedValue;
    }

    private static double convertKelvin(double value, String targetUnit) {
        double convertedValue;
        switch (targetUnit) {
            case "Celsius" -> convertedValue = value - 273.15;
            case "Fahrenheit" -> convertedValue = (value * 9 / 5) - 459.67;
            case "Rankine" -> convertedValue = value * 9 / 5;
            default -> {
                String errorMessage = String.format(ERROR_MSG_TEMP, targetUnit);
                logger.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
        }
        logger.info(String.format("Temperature conversion: %s Kelvin to %s = %s", value, targetUnit, convertedValue));
        return convertedValue;
    }

    private static double convertRankine(double value, String targetUnit) {
        double convertedValue;
        switch (targetUnit) {
            case "Celsius" -> convertedValue = (value - 491.67) * 5 / 9;
            case "Fahrenheit" -> convertedValue = value - 459.67;
            case "Kelvin" -> convertedValue = value * 5 / 9;
            default -> {
                String errorMessage = String.format(ERROR_MSG_TEMP, targetUnit);
                logger.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
        }
        logger.info(String.format("Temperature conversion: %s Rankine to %s = %s", value, targetUnit, convertedValue));
        return convertedValue;
    }

    private static double convertKm(double value, String targetUnit) {
        double convertedValue;
        switch (targetUnit) {
            case "m" -> convertedValue = value * 1000.0;
            case "mi" -> convertedValue = value * 0.621371;
            case "ft" -> convertedValue = value * 3280.84;
            case "in" -> convertedValue = value * 39370.1;
            default -> {
                String errorMessage = String.format(ERROR_MSG_LENGTH, targetUnit);
                logger.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
        }
        logger.info(String.format("Length conversion: %s km to %s = %s", value, targetUnit, convertedValue));
        return convertedValue;
    }

    private static double convertM(double value, String targetUnit) {
        return switch (targetUnit) {
            case "km" -> value / 1000.0;
            case "mi" -> value * 0.000621371;
            case "ft" -> value * 3.28084;
            case "in" -> value * 39.3701;
            default -> throw new IllegalArgumentException(String.format(ERROR_MSG_LENGTH, targetUnit));
        };
    }

    private static double convertMi(double value, String targetUnit) {
        double convertedValue;
        switch (targetUnit) {
            case "km" -> convertedValue = value / 1000.0;
            case "mi" -> convertedValue = value * 0.000621371;
            case "ft" -> convertedValue = value * 3.28084;
            case "in" -> convertedValue = value * 39.3701;
            default -> {
                String errorMessage = String.format(ERROR_MSG_LENGTH, targetUnit);
                logger.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
        }
        logger.info(String.format("Length conversion: %s m to %s = %s", value, targetUnit, convertedValue));
        return convertedValue;
    }

    private static double convertFt(double value, String targetUnit) {
        double convertedValue;
        switch (targetUnit) {
            case "km" -> convertedValue = value * 1.60934;
            case "m" -> convertedValue = value * 1609.34;
            case "ft" -> convertedValue = value * 5280.0;
            case "in" -> convertedValue = value * 63360.0;
            default -> {
                String errorMessage = String.format(ERROR_MSG_LENGTH, targetUnit);
                logger.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
        }
        logger.info(String.format("Length conversion: %s mi to %s = %s", value, targetUnit, convertedValue));
        return convertedValue;
    }

    private static double convertIn(double value, String targetUnit) {
        double convertedValue;
        switch (targetUnit) {
            case "km" -> convertedValue = value * 0.0000254;
            case "m" -> convertedValue = value * 0.0254;
            case "mi" -> convertedValue = value * 0.0000157828;
            case "ft" -> convertedValue = value * 0.0833333;
            default -> {
                String errorMessage = String.format(ERROR_MSG_LENGTH, targetUnit);
                logger.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
        }
        logger.info(String.format("Length conversion: %s in to %s = %s", value, targetUnit, convertedValue));
        return convertedValue;
    }
}
