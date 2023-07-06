package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import models.Conversion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.JsonUtils;
import util.NumberUtils;

/**
 * Utility class for making API requests and retrieving conversion results.
 */
public class ApiUtils extends ApiRequests {
    private static final Logger logger = LogManager.getLogger(ApiUtils.class);

    /**
     * Retrieves the conversion result from an API request.
     *
     * @param conversion The conversion object containing the current unit, target unit, and initial value.
     * @return The formatted conversion result.
     */
    public static String getConversionResultFromRequest(Conversion conversion) {
        String endPoint = String.format("%s/%s/%s", conversion.getCurrentUnit(), conversion.getTargetUnit(), conversion.getInitialValue());
        HttpResponse<JsonNode> response = get(endPoint);
        try {
            return NumberUtils.numberFormat(JsonUtils.getConversionValue(response.getBody()));
        } catch (Exception e) {
            logger.error("Error al obtener el resultado de la conversión de la API", e);
            throw e;
        }    }
}
