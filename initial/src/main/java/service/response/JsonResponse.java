package service.response;

import service.model.Person;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sridharyadav on 9/23/16.
 */
public class JsonResponse {


    final static Logger LOG = Logger.getLogger(JsonResponse.class);

    public static String jsonOutput(String ip) {
        JSONObject obj = new JSONObject();

        try {
            obj.put("Input", ip);
            return obj.toString();
        } catch (JSONException e) {
            LOG.error("Error building json string responses", e);
            return "";
        }

    }

    public static String standardResponse(String status, String message) {
        JSONObject obj = new JSONObject();

        try {
            obj.put("Status", status);
            obj.put("Message", message);
            return obj.toString();
        } catch (JSONException e) {
            LOG.error("Error building standard responses", e);
            return "";
        }
    }

    public static String JSONPerson(Person person) {
        JSONObject obj = new JSONObject();

        try {
            obj.put("name", person.getName());
            obj.put("age", person.getAge());
            obj.put("city", person.getCity());
            return obj.toString();

        } catch (JSONException e) {
            LOG.error("Error parsing person object", e);
            return "";
        }
    }
}
