package joptionpanes;

import util.JsonReader;
import util.JsonReaderUtils;

import javax.swing.*;
import java.awt.*;

public abstract class BasePane extends JFrame {
    private static final JsonReader jsonReader = JsonReaderUtils.getConversionDataFile();
    protected JButton closeButton;
    protected JButton backButton;
    protected JTextField valueTextField;
    protected JComboBox<String> currentCurrencyComboBox;
    protected JComboBox<String> targetCurrencyComboBox;
    protected JButton convertButton;
    protected JButton clearButton;

    public BasePane(String title, int width, String key) {
        createComponents();
        addComponents();
        setupListeners();

        setTitle(title);
        setSize(width, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);

        setRandomComboBoxValue(key);

        currentCurrencyComboBox.addActionListener(new CurrencyComboBoxListener(currentCurrencyComboBox, targetCurrencyComboBox));
        targetCurrencyComboBox.addActionListener(new CurrencyComboBoxListener(targetCurrencyComboBox, currentCurrencyComboBox));
    }

    protected void createComponents() {
        closeButton = new JButton("Cerrar");
        backButton = new JButton("Atras");
        valueTextField = new JTextField(10);
        currentCurrencyComboBox = new JComboBox<>();
        targetCurrencyComboBox = new JComboBox<>();
        convertButton = new JButton("convertir");
        clearButton = new JButton("Limpiar");
    }

    protected void addComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("Valor:"), gbc);
        gbc.gridy++;
        add(new JLabel("Unidad Inicial:"), gbc);
        gbc.gridy++;
        add(new JLabel("Unidad Final:"), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        add(valueTextField, gbc);
        gbc.gridy++;
        add(currentCurrencyComboBox, gbc);
        gbc.gridy++;
        add(targetCurrencyComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(convertButton, gbc);
        gbc.gridx++;
        add(clearButton, gbc);
        gbc.gridx++;
        add(closeButton, gbc);
        gbc.gridx++;
        add(backButton, gbc);
    }

    protected void setupListeners() {
        convertButton.addActionListener(e -> convert());

        clearButton.addActionListener(e -> clearFields());

        closeButton.addActionListener(e -> exitApplication());

        backButton.addActionListener(e -> showMainPane());
    }

    protected void convert() {
        String currentValue = valueTextField.getText();
        String currentMeasure = (String) currentCurrencyComboBox.getSelectedItem();
        String targetMeasure = (String) targetCurrencyComboBox.getSelectedItem();

        if (!currentValue.isEmpty() && currentMeasure != null && targetMeasure != null) {
            try {
                double value = Double.parseDouble(currentValue);
                String resultMessage = getConvert(value, currentMeasure, targetMeasure);
                JOptionPane.showMessageDialog(null, resultMessage);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico válido.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Seleccione otra opción de longitud objetivo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un valor a convertir.");
        }
    }
    protected abstract String getConvert(double value, String currentMeasure, String  targetMeasure);

    protected void clearFields() {
        valueTextField.setText("");
    }

    protected void showMainPane() {
        dispose();
        MainPane.mainPage();
    }

    protected void exitApplication() {
        System.exit(0);
    }

    protected static String[] getUnitValues(String key) {
        return jsonReader.getValues(key);
    }

    protected void setRandomComboBoxValue(String key) {
        String[] values = getUnitValues(key);
        currentCurrencyComboBox.setModel(new DefaultComboBoxModel<>(values));
        targetCurrencyComboBox.setModel(new DefaultComboBoxModel<>(values));

        String selectedValue = (String) currentCurrencyComboBox.getSelectedItem();

        if (selectedValue == null) {
            int randomIndex = (int) (Math.random() * values.length);
            String randomValue = values[randomIndex];
            currentCurrencyComboBox.setSelectedItem(randomValue);
        } else {
            int selectedIndex = currentCurrencyComboBox.getSelectedIndex();
            int randomIndex;
            do {
                randomIndex = (int) (Math.random() * values.length);
            } while (randomIndex == selectedIndex);

            targetCurrencyComboBox.setSelectedIndex(randomIndex);
        }
    }
}
