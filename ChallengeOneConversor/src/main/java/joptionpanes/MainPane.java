package joptionpanes;

import javax.swing.*;

public class MainPane {
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
                    case "Divisas":
                        CurrencyPane currencyPane = new CurrencyPane();
                        shouldContinue = false;
                        break;
                    case "Temperatura":
                        TemperaturePane temperaturePane = new TemperaturePane();
                        shouldContinue = false;
                        break;
                    case "Longitud":
                        LengthPane lengthPane = new LengthPane();
                        shouldContinue = false;
                        break;
                    default:
                        break;
                }
            } while (shouldContinue);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No se concluyó la conversión", "Hasta luego", JOptionPane.WARNING_MESSAGE);
        }
    }
}