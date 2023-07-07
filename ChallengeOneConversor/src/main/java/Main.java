import joptionpanes.MainPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

/**
 * Main class for the application's entry point.
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    /**
     * The main method that starts the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int selector = JOptionPane.showConfirmDialog(null, "Bienvenido, ¿deseas iniciar?");

        if (selector == 0) {
            logger.info("Application started successfully.");
            MainPane.mainPage();
        } else {
            logger.info("Application exited.");
            JOptionPane.showMessageDialog(null, "Hasta luego", "Elegiste no ingresar", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
