package service.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import service.db.impl.PersonDaoImpl;
import service.db.model.Ad;
import service.db.model.Person;

import java.util.List;

import static service.response.JsonResponse.JSONAd;
import static service.response.JsonResponse.JSONPerson;

@RestController
@RequestMapping("/v1/person")
public class PersonController {


  final static Logger LOG = Logger.getLogger(PersonController.class);

  @RequestMapping(value = "/addperson",
      method = RequestMethod.POST)
  @ResponseBody
  public String addPerson(@RequestBody Person person) {
    PersonDaoImpl ob = new PersonDaoImpl();
    Person op = ob.insertPerson(person);
    LOG.info("Person added");
    String result = JSONPerson(op);
    LOG.info(result);
    return result;
  }


  @RequestMapping(value = "/getpersons",
      method = RequestMethod.GET)
  @ResponseBody
  public String getAllAds() {
    PersonDaoImpl ob = new PersonDaoImpl();
    List<Person> op = ob.getAllPersons();
    LOG.info("Persons fetched");
    String result = JSONPerson(op);
    LOG.info(result);
    return result;
  }

  @RequestMapping(value = "/getpersonads",
          method = RequestMethod.GET)
  @ResponseBody
  public String  getAllpersonAds(@RequestParam(value="name", required=false, defaultValue="Abhishek Patro") String name) {
    PersonDaoImpl ob = new PersonDaoImpl();
    List<Ad> op = ob.getAllPersonAds(name);
    LOG.info("Person Ads fetched");
    return JSONAd(op);
  }
}
