package util;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for managing JSON data files and their associated JsonReader instances.
 */
public class JsonReaderUtils {
    private static final String CONVERSION_DATA_FILE_NAME = "src/Main/resources/converters.json";
    private static final String CONFIG_DATA_FILE_NAME = "src/Main/resources/config.json";

    private static final Map<String, JsonReader> dataFiles = new HashMap<>();

    static {
        dataFiles.put(CONVERSION_DATA_FILE_NAME, new JsonReader(CONVERSION_DATA_FILE_NAME));
        dataFiles.put(CONFIG_DATA_FILE_NAME, new JsonReader(CONFIG_DATA_FILE_NAME));
    }

    /**
     * Retrieves the JsonReader instance for the configuration data file.
     *
     * @return The JsonReader instance for the configuration data file.
     */
    public static JsonReader getConfigDataFile() {
        return dataFiles.get(CONFIG_DATA_FILE_NAME);
    }

    /**
     * Retrieves the JsonReader instance for the conversion data file.
     *
     * @return The JsonReader instance for the conversion data file.
     */
    public static JsonReader getConversionDataFile() {
        return dataFiles.get(CONVERSION_DATA_FILE_NAME);
    }
}
