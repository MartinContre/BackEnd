package joptionpanes;

import javax.swing.*;
import java.awt.*;

public abstract class BasePane extends JFrame {
    protected JButton closeButton;
    protected JButton backButton;
    protected JTextField valueTextField;
    protected JComboBox<String> currentCurrencyComboBox;
    protected JComboBox<String> targetCurrencyComboBox;
    protected JButton convertButton;
    protected JButton clearButton;

    public BasePane(String title, int width) {
        createComponents();
        addComponents();
        setupListeners();

        setTitle(title);
        setSize(width, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    protected void createComponents() {
        closeButton = new JButton("Close");
        backButton = new JButton("Back");
        valueTextField = new JTextField(10);
        currentCurrencyComboBox = new JComboBox<>();
        targetCurrencyComboBox = new JComboBox<>();
        convertButton = new JButton("Convert");
        clearButton = new JButton("Clear");
    }

    protected void addComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("Value:"), gbc);
        gbc.gridy++;
        add(new JLabel("Current Currency:"), gbc);
        gbc.gridy++;
        add(new JLabel("Target Currency:"), gbc);

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

    protected abstract void convert();

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
}
