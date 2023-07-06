package joptionpanes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyComboBoxListener implements ActionListener {
    private final JComboBox<String> currentCurrencyComboBox;
    private final JComboBox<String> otherComboBox;

    public CurrencyComboBoxListener(JComboBox<String> currentCurrencyComboBox, JComboBox<String> otherComboBox) {
        this.currentCurrencyComboBox = currentCurrencyComboBox;
        this.otherComboBox = otherComboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedCurrency = (String) otherComboBox.getSelectedItem();
        String selectedValue = (String) currentCurrencyComboBox.getSelectedItem();
        if (selectedCurrency != null && selectedCurrency.equals(selectedValue)) {
            otherComboBox.setSelectedIndex(-1);
        }
    }
}
