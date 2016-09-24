package controllers;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import static response.JsonResponse.jsonOutput;

/**
 * Created by patro on 9/23/16.
 */

@RestController
@RequestMapping("/v1/dummy")
public class DummyController {
    final static Logger LOG = Logger.getLogger(DummyController.class);

    @RequestMapping("/")
    public String index() {
        LOG.info("simple / call");
        return jsonOutput("Greetings from Spring Boot!");
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{ip}")
    public String getCall(@PathVariable String ip) {

        LOG.info("get call with : " + ip);
        return jsonOutput(ip+ip);
    }

    @RequestMapping(value = "/postSupplier", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public String redire(@RequestBody JSONObject obj) {
        System.out.println(obj.toString());
        return jsonOutput("success1");
    }

    @RequestMapping("/hello")
    public String index1() {
        return "Patro";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/post/{id}")
    public String postCall(@PathVariable String id, @RequestBody String contact) {

        JSONObject json = new JSONObject(contact);

        try {
            LOG.info("post call");
            return id + json.getString("id");
        } catch (JSONException e) {
            LOG.error("Error parsing json", e);
            return id;
        }
    }
}
