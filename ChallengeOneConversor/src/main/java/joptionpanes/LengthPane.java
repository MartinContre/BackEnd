package joptionpanes;

import conversor.Converter;
import util.NumberUtils;

public class LengthPane extends BasePane {
    private static final String LENGTH_KEY = "Length";

    public LengthPane() {
        super("Conversor de longitud", 400, LENGTH_KEY);
    }

    @Override
    protected String getConvert(double value, String currentMeasure, String targetMeasure) {
        String convertedValue = Converter.getConvertedLength(value, currentMeasure, targetMeasure);
        String initialValue = NumberUtils.numberFormat(value);
        return String.format("%s %s es igual a %s %s", initialValue, currentMeasure, convertedValue, targetMeasure);
    }
}
