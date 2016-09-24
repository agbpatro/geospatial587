package hello;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1")
public class HelloController {
    final static Logger LOG = Logger.getLogger(HelloController.class);

    @RequestMapping("/")
    public String index() {
        LOG.info("simple / call");
        return "Greetings from Spring Boot!";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{ip}")
    public String getCall(@PathVariable String ip) {

        LOG.info("get call with : " + ip);
        return ip;
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
