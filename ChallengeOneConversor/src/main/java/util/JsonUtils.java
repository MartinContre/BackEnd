package util;

import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtils {

    public static Double getConversionValue(JsonNode body) {
        JSONArray array = body.getArray();
        if (array != null && array.length() > 0) {
            JSONObject obj = array.getJSONObject(0);
            return obj.getDouble("conversion_result");
        }

        JSONObject obj = body.getObject();
        return obj.getDouble("conversion_result");
    }
}
