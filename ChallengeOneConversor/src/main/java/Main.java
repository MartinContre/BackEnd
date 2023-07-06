import joptionpanes.MainPane;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        int selector = JOptionPane.showConfirmDialog(null, "Bienvenido, ¿deseas iniciar?");

        if (selector == 0) {
            MainPane.mainPage();
        } else {
            JOptionPane.showMessageDialog(null, "Hasta luego", "Elegiste no ingresar", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
