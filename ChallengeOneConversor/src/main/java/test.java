import api.ApiRequests;
import api.ApiUtils;
import util.JsonReader;
import util.StringUtils;

public class test {
    public static void main(String[] args) {
        String url = ApiRequests.getURL("USD", "EUR", 15);
        System.out.println(url);

        String[] values = JsonReader.getValue("currency");

        System.out.println(StringUtils.deleteAllExceptFirstThree(values[15]));

        System.out.println(ApiUtils.getConversionResultFromRequest("USD", "EUR", 15));
    }
}
