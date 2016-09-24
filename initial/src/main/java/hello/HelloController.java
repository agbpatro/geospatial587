package hello;

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

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{ip}")
    public String getCall(@PathVariable String ip) {
        return ip;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/post/{id}")
    public String postCall(@PathVariable String id, @RequestBody String contact) {

        JSONObject json = new JSONObject(contact);

        try {
            return id + json.getString(id);
        } catch (JSONException e) {
            return id;
        }
    }


}
