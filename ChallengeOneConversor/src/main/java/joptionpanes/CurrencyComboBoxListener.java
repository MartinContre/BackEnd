package joptionpanes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener implementation for currency combo boxes.
 * It ensures that the selected value in one combo box is not the same as the selected value in another combo box.
 */
public class CurrencyComboBoxListener implements ActionListener {
    private final Logger logger = LogManager.getLogger(CurrencyComboBoxListener.class);
    private final JComboBox<String> currentCurrencyComboBox;
    private final JComboBox<String> otherComboBox;

    /**
     * Creates a new instance of the CurrencyComboBoxListener class.
     *
     * @param currentCurrencyComboBox The combo box representing the current currency.
     * @param otherComboBox The other combo box to compare against.
     */
    public CurrencyComboBoxListener(JComboBox<String> currentCurrencyComboBox, JComboBox<String> otherComboBox) {
        this.currentCurrencyComboBox = currentCurrencyComboBox;
        this.otherComboBox = otherComboBox;
    }

    /**
     * Called when an action occurs in the combo box.
     * It ensures that the selected value in one combo box is not the same as the selected value in another combo box.
     *
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedCurrency = (String) otherComboBox.getSelectedItem();
        String selectedValue = (String) currentCurrencyComboBox.getSelectedItem();
        if (selectedCurrency != null && selectedCurrency.equals(selectedValue)) {
            otherComboBox.setSelectedIndex(-1);
            logger.info("Selected currency cleared in the other combo box.");
        }
    }
}
