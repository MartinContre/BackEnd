package joptionpanes;

import util.JsonReader;

import javax.swing.*;

public class TemperaturePane extends BasePane {

    public TemperaturePane() {
        super("Conversor de temperaturas", 400);
        String[] temperature = JsonReader.getValue("temperature");
        currentCurrencyComboBox.setModel(new DefaultComboBoxModel<>(temperature));
        targetCurrencyComboBox.setModel(new DefaultComboBoxModel<>(temperature));
    }

    @Override
    protected void convert() {
        String currentValue = valueTextField.getText();
        String currentTemperature = (String) currentCurrencyComboBox.getSelectedItem();
        String targetTemperature = (String) targetCurrencyComboBox.getSelectedItem();

        if (!currentValue.isEmpty() && !currentTemperature.isEmpty() && !targetTemperature.isEmpty()) {
            try {
                double value = Double.parseDouble(currentValue);

                double convertedValue = convertTemperature(value, currentTemperature, targetTemperature);

                String resultMessage = value + " º" + currentTemperature + " es igual a " + convertedValue + " º" + targetTemperature;
                JOptionPane.showMessageDialog(null, resultMessage);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico válido.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Unidad de temperatura no válida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un valor a convertir.");
        }
    }

    private static double convertTemperature(double value, String currentUnit, String targetUnit) {
        double convertedValue = switch (currentUnit) {
            case "Celsius" -> switch (targetUnit) {
                case "Fahrenheit" -> (value * 9 / 5) + 32;
                case "Kelvin" -> value + 273.15;
                case "Rankine" -> (value + 273.15) * 9 / 5;
                default -> throw new IllegalArgumentException("Unidad de temperatura objetivo no valida " + targetUnit);
            };
            case "Fahrenheit" -> switch (targetUnit) {
                case "Celsius" -> (value - 32) * 5 / 9;
                case "Kelvin" -> (value + 459.67) * 5 / 9;
                case "Rankine" -> value + 459.67;
                default -> throw new IllegalArgumentException("Unidad de temperatura objetivo no valida " + targetUnit);
            };
            case "Kelvin" -> switch (targetUnit) {
                case "Celsius" -> value - 273.15;
                case "Fahrenheit" -> (value * 9 / 5) - 459.67;
                case "Rankine" -> value * 9 / 5;
                default -> throw new IllegalArgumentException("Unidad de temperatura objetivo no valida " + targetUnit);
            };
            case "Rankine" -> switch (targetUnit) {
                case "Celsius" -> (value - 491.67) * 5 / 9;
                case "Fahrenheit" -> value - 459.67;
                case "Kelvin" -> value * 5 / 9;
                default -> throw new IllegalArgumentException("Unidad de temperatura objetivo no valida " + targetUnit);
            };
            default -> throw new IllegalArgumentException("Unidad de temperatura base no valida " + currentUnit);
        };
        return convertedValue;
    }
}
