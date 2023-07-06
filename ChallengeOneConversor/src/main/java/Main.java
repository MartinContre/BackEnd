import joptionpanes.MainPane;

import javax.swing.*;

/**
 * Main class for the application's entry point.
 */
public class Main {

    /**
     * The main method that starts the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int selector = JOptionPane.showConfirmDialog(null, "Bienvenido, ¿deseas iniciar?");

        if (selector == 0) {
            MainPane.mainPage();
        } else {
            JOptionPane.showMessageDialog(null, "Hasta luego", "Elegiste no ingresar", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
