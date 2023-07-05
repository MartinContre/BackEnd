package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;

public abstract class ApiRequests {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6";
    private static final String API_KEY = "431d617fb2aa878aa87e2f28";
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

    public static String getURL(String current, String target, double amount) {
        return String.format("%s/%s/pair/%s/%s/%s", BASE_URL, API_KEY, current, target, amount);
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
