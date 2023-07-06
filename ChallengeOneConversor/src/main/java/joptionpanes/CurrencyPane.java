package joptionpanes;

import api.ApiUtils;
import models.Conversion;
import util.NumberUtils;
import util.StringUtils;

/**
 * Pane for currency conversion.
 */
public class CurrencyPane extends BasePane {
    private static final String CURRENCY_KEY = "Currency";

    /**
     * Creates a new instance of the CurrencyPane class.
     */
    public CurrencyPane() {
        super("Conversor de Divisas", 600, CURRENCY_KEY);
    }

    /**
     * Performs the currency conversion.
     *
     * @param conversion The conversion object containing the current unit, target unit, and initial value.
     * @return The formatted conversion result.
     */
    @Override
    protected String getConversion(Conversion conversion) {
        conversion.setCurrentUnit(StringUtils.deleteAllExceptFirstThree(conversion.getCurrentUnit()));
        conversion.setTargetUnit(StringUtils.deleteAllExceptFirstThree(conversion.getTargetUnit()));
        conversion.setConvertedValue(ApiUtils.getConversionResultFromRequest(conversion));
        String initialValue = NumberUtils.numberFormat(conversion.getInitialValue());
        return String.format("%s %s es igual a %s %s", initialValue, conversion.getCurrentUnit(), conversion.getConvertedValue(), conversion.getTargetUnit());
    }
}
