package util;

import com.mashape.unirest.http.JsonNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Utility class for parsing JSON responses and extracting conversion values.
 */
public class JsonUtils {
    private static final Logger logger = LogManager.getLogger(JsonUtils.class);

    /**
     * Retrieves the conversion value from a JSON response.
     *
     * @param body The JSON response body.
     * @return The conversion value as a Double.
     */
    public static Double getConversionValue(JsonNode body) {

        if (body != null) {
            JSONArray jsonArray = body.getArray();
            if (jsonArray != null && jsonArray.length() > 0) {
                return jsonArray.getJSONObject(0).getDouble("conversion_result");
            } else {
                JSONObject jsonObject = body.getObject();
                if (jsonObject != null) {
                    return jsonObject.getDouble("conversion_result");
                }
            }
        }
        logger.error("Invalid JSON response body or missing conversion_result field");
        return null;
    }
}
