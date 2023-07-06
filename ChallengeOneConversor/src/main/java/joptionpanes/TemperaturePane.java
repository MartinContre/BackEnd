package joptionpanes;

import conversor.Converter;
import models.Conversion;
import util.NumberUtils;


/**
 * Pane for temperature conversion.
 */
public class TemperaturePane extends BasePane {
    private static final String TEMPERATURE_KEY = "Temperature";

    /**
     * Creates a new instance of the TemperaturePane class.
     */
    public TemperaturePane() {
        super("Conversor de temperaturas", 400, TEMPERATURE_KEY);
    }

    /**
     * Performs the temperature conversion.
     *
     * @param conversion The conversion object containing the current unit, target unit, and initial value.
     * @return The formatted conversion result.
     */
    @Override
    protected String getConversion(Conversion conversion) {
        conversion.setConvertedValue(Converter.getConvertedTemperature(conversion));
        String initialValue = NumberUtils.numberFormat(conversion.getInitialValue());
        return String.format("%s %s es igual a %s %s", initialValue, conversion.getCurrentUnit(), conversion.getConvertedValue(), conversion.getTargetUnit());
    }
}
