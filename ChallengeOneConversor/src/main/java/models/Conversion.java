package models;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a unit conversion.
 */
@Data
@NoArgsConstructor
public class Conversion {

    /**
     * The current unit of the conversion.
     */
    private String currentUnit;

    /**
     * The target unit of the conversion.
     */
    private String targetUnit;

    /**
     * The initial value of the conversion.
     */
    private double initialValue;

    /**
     * The converted value after the conversion.
     */
    private String convertedValue;
}
