package joptionpanes;

import api.ApiUtils;
import util.NumberUtils;

public class CurrencyPane extends BasePane {

    private static final String CURRENCY_KEY = "Currency";

    public CurrencyPane() {
        super("Conversor de Divisas", 600, CURRENCY_KEY);
    }

    @Override
    protected String getConvert(double value, String currentMeasure, String targetMeasure) {
        double convertedAmount = ApiUtils.getConversionResultFromRequest(currentMeasure, targetMeasure, value);
        String initialValue = NumberUtils.numberFormat(value);
        return String.format("%s %s es igual a %s %s", initialValue, currentMeasure, convertedAmount, targetMeasure);
    }
}
