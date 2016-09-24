package service.controllers;

import service.model.Person;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import static service.response.JsonResponse.JSONPerson;

@RestController
@RequestMapping("/v1/person")
public class PersonController {


    final static Logger LOG = Logger.getLogger(PersonController.class);

    @RequestMapping(value = "/addPerson",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public String addPerson(@RequestBody Person person) {
        LOG.info("Person added");
        return JSONPerson(person);
    }


}
