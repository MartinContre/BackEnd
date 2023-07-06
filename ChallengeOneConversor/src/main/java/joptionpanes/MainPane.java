package joptionpanes;

import javax.swing.*;


/**
 * Main class for the application's main page and entry point.
 */
public class MainPane {
    /**
     * Displays the main page and allows the user to select a conversion type.
     */
    public static void mainPage() {
        try {
            boolean shouldContinue = true;

            do {
                String[] converters = {"Divisas", "Temperatura", "Longitud"};
                String converter = (String) JOptionPane.showInputDialog(
                        null, "Seleccione una opción", "Conversor", JOptionPane.QUESTION_MESSAGE, null,
                        converters, converters[0]
                );

                switch (converter) {
                    case "Divisas" -> {
                        new  CurrencyPane();
                        shouldContinue = false;
                    }
                    case "Temperatura" -> {
                        new TemperaturePane();
                        shouldContinue = false;
                    }
                    case "Longitud" -> {
                        new LengthPane();
                        shouldContinue = false;
                    }
                    default -> {
                    }
                }
            } while (shouldContinue);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No se concluyó la conversión", "Hasta luego", JOptionPane.WARNING_MESSAGE);
        }
    }
}