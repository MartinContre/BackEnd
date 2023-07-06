package conversor;

import util.NumberUtils;

import javax.swing.*;

public class Converter {
    private static final String ERROR_MSG_TEMP =  "Unidad de temperatura objetivo no válida: %s";
    private static final String ERROR_MSG_LENGTH = "Unidad de longitud objetivo no valida; %s";
    public static String getConvertedTemperature(double value, String currentUnit, String targetUnit) {
        double convertedNumber;
        switch (currentUnit) {
            case "Celsius" -> convertedNumber = convertCelsius(value, targetUnit);
            case "Fahrenheit" -> convertedNumber = convertFahrenheit(value, targetUnit);
            case "Kelvin" -> convertedNumber = convertKelvin(value, targetUnit);
            case "Rankine" -> convertedNumber = convertRankine(value, targetUnit);
            default -> throw new IllegalArgumentException("Unidad de temperatura base no valida " + currentUnit);
        }
        return NumberUtils.numberFormat(convertedNumber);
    }

    public static String getConvertedLength(double value, String currentUnit, String targetUnit) {
        double convertedValue = 0.0;
        switch (currentUnit) {
            case "km" -> convertedValue = convertKm(value, targetUnit);
            case "m" -> convertedValue = convertM(value, targetUnit);
            case "mi" -> convertedValue = convertMi(value, targetUnit);
            case "ft" -> convertedValue = convertFt(value, targetUnit);
            case "in" -> convertedValue = convertIn(value, targetUnit);
            default -> JOptionPane.showMessageDialog(null, "Selecciona una opcion valida");
        }
        return NumberUtils.numberFormat(convertedValue);
    }

    private static double convertCelsius(double value, String targetUnit) {
        return switch (targetUnit) {
            case "Fahrenheit" -> (value * 9 / 5) + 32;
            case "Kelvin" -> value + 273.15;
            case "Rankine" -> (value + 273.15) * 9 / 5;
            default -> throw new IllegalArgumentException(String.format(ERROR_MSG_TEMP, targetUnit));
        };
    }

    private static double convertFahrenheit(double value, String targetUnit) {
        return switch (targetUnit) {
            case "Celsius" -> (value - 32) * 5 / 9;
            case "Kelvin" -> (value + 459.67) * 5 / 9;
            case "Rankine" -> value + 459.67;
            default -> throw new IllegalArgumentException(String.format(ERROR_MSG_TEMP, targetUnit));
        };
    }

    private static double convertKelvin(double value, String targetUnit) {
        return switch (targetUnit) {
            case "Celsius" -> value - 273.15;
            case "Fahrenheit" -> (value * 9 / 5) - 459.67;
            case "Rankine" -> value * 9 / 5;
            default -> throw new IllegalArgumentException(String.format(ERROR_MSG_TEMP, targetUnit));
        };
    }

    private static double convertRankine(double value, String targetUnit) {
        return switch (targetUnit) {
            case "Celsius" -> (value - 491.67) * 5 / 9;
            case "Fahrenheit" -> value - 459.67;
            case "Kelvin" -> value * 5 / 9;
            default -> throw new IllegalArgumentException(String.format(ERROR_MSG_TEMP, targetUnit));
        };
    }

    private static double convertKm(double value, String targetUnit) {
        return switch (targetUnit) {
            case "m" -> value * 1000.0;
            case "mi" -> value * 0.621371;
            case "ft" -> value * 3280.84;
            case "in" -> value * 39370.1;
            default -> throw new IllegalArgumentException(String.format(ERROR_MSG_LENGTH, targetUnit));
        };
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
        return switch (targetUnit) {
            case "km" -> value * 1.60934;
            case "m" -> value * 1609.34;
            case "ft" -> value * 5280.0;
            case "in" -> value * 63360.0;
            default -> throw new IllegalArgumentException(String.format(ERROR_MSG_LENGTH, targetUnit));
        };
    }

    private static double convertFt(double value, String targetUnit) {
        return switch (targetUnit) {
            case "km" -> value * 0.0003048;
            case "m" -> value * 0.3048;
            case "mi" -> value * 0.000189394;
            case "in" -> value * 12.0;
            default -> throw new IllegalArgumentException(String.format(ERROR_MSG_LENGTH, targetUnit));
        };
    }

    private static double convertIn(double value, String targetUnit) {
        return switch (targetUnit) {
            case "km" -> value * 0.0000254;
            case "m" -> value * 0.0254;
            case "mi" -> value * 0.0000157828;
            case "ft" -> value * 0.0833333;
            default -> throw new IllegalArgumentException(String.format(ERROR_MSG_LENGTH, targetUnit));
        };
    }
}
