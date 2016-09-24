package hello;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/postSupplier", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public String redire(@RequestBody JSONObject obj) {
        System.out.println(obj.toString());
        return "success1";
    }

    @RequestMapping("/hello")
    public String index1() {
        return "Patro";
    }

    @RequestMapping(value = "/addPerson",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public String addPerson(@RequestBody Person person) {
        return person.getCity();
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
