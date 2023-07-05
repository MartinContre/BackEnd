package joptionpanes;

import api.ApiUtils;
import util.JsonReader;
import util.StringUtils;

import javax.swing.*;
import java.util.Objects;

public class CurrencyPane extends BasePane {

    public CurrencyPane() {
        super("Conversor de Divisas", 600);
        String[] currencies = JsonReader.getValue("currency");
        currentCurrencyComboBox.setModel(new DefaultComboBoxModel<>(currencies));
        targetCurrencyComboBox.setModel(new DefaultComboBoxModel<>(currencies));

    }

    @Override
    protected void convert() {
        String currentValue = valueTextField.getText();
        String currentCurrency = (String) currentCurrencyComboBox.getSelectedItem();
        String targetCurrency = (String) targetCurrencyComboBox.getSelectedItem();

        if (!currentValue.isEmpty() && !Objects.requireNonNull(currentCurrency).isEmpty() && !Objects.requireNonNull(targetCurrency).isEmpty()) {
            currentCurrency = StringUtils.deleteAllExceptFirstThree(currentCurrency);
            targetCurrency = StringUtils.deleteAllExceptFirstThree(targetCurrency);
            JOptionPane.showMessageDialog(null, ApiUtils.getConversionResultFromRequest(currentCurrency, targetCurrency, Double.parseDouble(currentValue)));
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingresa un valor a convertir.");
        }
    }

}
