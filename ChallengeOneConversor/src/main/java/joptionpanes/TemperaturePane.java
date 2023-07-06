package joptionpanes;

import conversor.Converter;
import util.NumberUtils;

public class TemperaturePane extends BasePane {
    private static final String TEMPERATURE_KEY = "Temperature";

    public TemperaturePane() {
        super("Conversor de temperaturas", 400, TEMPERATURE_KEY);
    }

    @Override
    protected String getConvert(double value, String currentMeasure, String targetMeasure) {
        String convertedValue = Converter.getConvertedTemperature(value, currentMeasure, targetMeasure);
        String initialValue = NumberUtils.numberFormat(value);
        return String.format("%s %s es igual a %s %s", initialValue, currentMeasure, convertedValue, targetMeasure);
    }
}
