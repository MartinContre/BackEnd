package joptionpanes;

import models.Conversion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.JsonReader;
import util.JsonReaderUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;


/**
 * Abstract base class for creating custom panes with common components and functionality.
 */
public abstract class BasePane extends JFrame {
    /**
     * The logger for logging events and messages related to the BasePane class.
     */
    protected static final Logger logger = LogManager.getLogger(BasePane.class);
    private static final JsonReader jsonReader = JsonReaderUtils.getConversionDataFile();
    /**
     * The close button for the currency converter window.
     */
    protected JButton closeButton;
    /**
     * The back button for navigating to the previous screen.
     */
    protected JButton backButton;
    /**
     * The convert button for initiating the currency conversion process.
     */
    protected JButton convertButton;
    /**
     * The clear button for resetting the input fields.
     */
    protected JButton clearButton;
    /**
     * The combo box for selecting the current currency.
     */
    protected JComboBox<String> currentCurrencyComboBox;
    /**
     * The combo box for selecting the target currency.
     */
    protected JComboBox<String> targetCurrencyComboBox;
    /**
     * The text field for entering the value to be converted in the currency converter.
     */
    protected JTextField valueTextField;

    /**
     * Creates a new instance of the BasePane class.
     *
     * @param title The title of the pane.
     * @param width The width of the pane.
     * @param key The key for retrieving unit values from the JSON reader.
     */
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

    /**
     * Creates the components required for the currency converter window.
     */
    protected void createComponents() {
        closeButton = new JButton("Cerrar");
        backButton = new JButton("Atras");
        valueTextField = new JTextField(10);
        currentCurrencyComboBox = new JComboBox<>();
        targetCurrencyComboBox = new JComboBox<>();
        convertButton = new JButton("Convertir");
        clearButton = new JButton("Limpiar");
    }

    /**
     * Adds the components to the currency converter window.
     */
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

    /**
     * Sets up the listeners for the currency converter buttons.
     */
    protected void setupListeners() {
        convertButton.addActionListener(e -> convert());

        clearButton.addActionListener(e -> clearFields());

        closeButton.addActionListener(e -> exitApplication());

        backButton.addActionListener(e -> showMainPane());
    }

    /**
     * Initiates the conversion process.
     */
    protected void convert() {
        Conversion conversion = new Conversion();
        conversion.setInitialValue(Double.parseDouble(valueTextField.getText()));
        conversion.setCurrentUnit((String) Objects.requireNonNull(currentCurrencyComboBox.getSelectedItem()));
        conversion.setTargetUnit((String) Objects.requireNonNull(targetCurrencyComboBox.getSelectedItem()));

        if (conversion.getInitialValue() != 0) {
            try {
                String resultMessage = getConversion(conversion);
                JOptionPane.showMessageDialog(null, resultMessage);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico válido.");
                logger.error(String.format("Invalid numeric value entered: %s", conversion.getInitialValue()));
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Seleccione otra opción de conversion objetivo");
                logger.error(String.format("Invalid target unit selected: %s", conversion.getTargetUnit()));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un valor a convertir.");
            logger.error("Conversion input values are missing.");
        }
    }

    /**
     * Retrieves the conversion result for the given Conversion object.
     *
     * @param conversion The Conversion object representing the conversion details.
     * @return The conversion result as a string.
     */
    protected abstract String getConversion(Conversion conversion);

    /**
     * Clears the input fields.
     */
    protected void clearFields() {
        logger.info("Clearing fields");
        valueTextField.setText("");
    }

    /**
     * Returns to the main page.
     */
    protected void showMainPane() {
        logger.info("Returning to the main page.");
        dispose();
        MainPane.mainPage();
    }

    /**
     * Exits the application.
     */
    protected void exitApplication() {
        logger.info("Exiting the application.");
        System.exit(0);
    }

    /**
     * Retrieves the unit values associated with the given key.
     *
     * @param key The key used to retrieve the unit values.
     * @return An array of unit values.
     */
    protected static String[] getUnitValues(String key) {
        String[] values = jsonReader.getValues(key);
        if (values.length == 0) {
            logger.error("No unit values found for key: {}", key);
        }
        return values;
    }


    /**
     * Sets a random value for the combo boxes associated with the given key.
     *
     * @param key The key used to retrieve the unit values.
     */
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
        logger.info(String.format("Randomly selected unit values for key: %s", key));

    }
}
