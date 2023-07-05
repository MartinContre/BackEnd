package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import util.JsonUtils;

public class ApiUtils extends ApiRequests {
    public static Double getConversionResultFromRequest(String current, String target, double amount) {
        String endPoint = String.format("%s/%s/%s", current, target, amount);
        HttpResponse<JsonNode> response = get(endPoint);
        return JsonUtils.getConversionValue(response.getBody());
    }
}
