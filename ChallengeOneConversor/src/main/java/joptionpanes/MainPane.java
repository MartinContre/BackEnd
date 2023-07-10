package joptionpanes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JOptionPane;


/**
 * Main class for the application's main page and entry point.
 */
public class MainPane {
    private static final Logger logger = LogManager.getLogger(MainPane.class);

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
                        logger.info("Started currency pane");
                        new CurrencyPane();
                        shouldContinue = false;
                    }
                    case "Temperatura" -> {
                        logger.info("Started temperature pane");
                        new TemperaturePane();
                        shouldContinue = false;
                    }
                    case "Longitud" -> {
                        logger.info("Started length pane");
                        new LengthPane();
                        shouldContinue = false;
                    }
                    default -> {
                    }
                }
            } while (shouldContinue);
        } catch (NullPointerException e) {
            logger.error(String.format("NullPointerException occurred. Error: %s", e));
            JOptionPane.showMessageDialog(null, "No se concluyó la conversión", "Hasta luego", JOptionPane.WARNING_MESSAGE);
        }
    }
}