package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.JsonReader;
import util.JsonReaderUtils;

/**
 * Abstract class that provides methods for making API requests.
 */
public abstract class ApiRequests {
    private static final Logger logger = LogManager.getLogger(ApiRequests.class);
    private static final JsonReader jsonReader = JsonReaderUtils.getConfigDataFile();
    private static final String BASE_URL = jsonReader.getValue("URL");
    private static final String API_KEY = jsonReader.getValue("API_KEY");

    /**
     * Sends a GET request to the specified API endpoint.
     *
     * @param endPoint The API endpoint to send the request to.
     * @return The HTTP response containing the JSON response body.
     * @throws RuntimeException If an error occurs during the HTTP request.
     * @throws IllegalArgumentException If the HTTP response status is not within the successful range.
     */
    protected static HttpResponse<JsonNode> get(String endPoint) {
        String url = String.format("%s/%s/pair/%s", BASE_URL, API_KEY, endPoint);
        HttpResponse<JsonNode> response;
        try {
            response = Unirest.get(url).asJson();
        } catch (UnirestException e) {
            logger.error(String.format("Error al realizar la solicitud GET a la URL: %s", url));
            throw new RuntimeException(e.getMessage());
        }

        return checkStatus(response);
    }

    private static HttpResponse<JsonNode> checkStatus(HttpResponse<JsonNode> response) {
        int statusCode = response.getStatus();
        if (statusCode >= HttpStatus.SC_OK && statusCode < HttpStatus.SC_MULTIPLE_CHOICES) {
            return response;
        }
        else {
            logger.error(String.format("La respuesta HTTP contiene un estado no válido: %s", response.getBody().toString()));
            throw new IllegalArgumentException(response.getBody().toString());
        }
    }
}
