package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;
import util.JsonReader;
import util.JsonReaderUtils;

public abstract class ApiRequests {
    static JsonReader jsonReader = JsonReaderUtils.getConfigDataFile();
    private static final String BASE_URL = jsonReader.getValue("URL");
    private static final String API_KEY = jsonReader.getValue("API_KEY");
    protected static HttpResponse<JsonNode> get(String endPoint) {
        String url = String.format("%s/%s/pair/%s", BASE_URL, API_KEY, endPoint);
        HttpResponse<JsonNode> response;
        try {
            response = Unirest.get(url).asJson();
        } catch (UnirestException e) {
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
            throw new IllegalArgumentException(response.getBody().toString());
        }
    }
}
