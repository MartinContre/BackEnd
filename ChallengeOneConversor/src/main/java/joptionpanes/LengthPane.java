package joptionpanes;

import util.JsonReader;

import javax.swing.*;

public class LengthPane extends BasePane{
    public LengthPane() {
        super("Conversor de longitud", 400);
        String[] lengths = JsonReader.getValue("length");
        currentCurrencyComboBox.setModel(new DefaultComboBoxModel<>(lengths));
        targetCurrencyComboBox.setModel(new DefaultComboBoxModel<>(lengths));
    }

    @Override
    protected void convert() {
        String currentValue = valueTextField.getText();

    }
}
