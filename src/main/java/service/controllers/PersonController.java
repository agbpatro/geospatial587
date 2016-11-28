package service.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import service.db.impl.PersonDaoImpl;
import service.db.model.Ad;
import service.db.model.Person;

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
    String ip = JSONPerson(person);
    LOG.info("Requested to add person");
    LOG.info(ip);
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
  public String getAllPersons() {
    PersonDaoImpl ob = new PersonDaoImpl();
    List<Person> op = ob.getAllPersons();
    LOG.info("Persons fetched");
    String result = JSONPerson(op);
    LOG.info(result);
    return result;
  }


  @RequestMapping(value = "/getperson",
      method = RequestMethod.POST)
  @ResponseBody
  public String getPerson(@RequestBody Person person) {
    String ip = JSONPerson(person);
    LOG.info("Requested to get person");
    LOG.info(ip);
    PersonDaoImpl ob = new PersonDaoImpl();
    Person op;
    if (person.getName() != null) {
      op = ob.getPersonByName(person);
    } else {
      op = ob.getPersonById(person);
    }
    LOG.info("Person fetched");
    String result = JSONPerson(op);
    LOG.info(result);
    return result;
  }

  @RequestMapping(value = "/getpersonads",
      method = RequestMethod.POST)
  @ResponseBody
  public String getAllpersonAds(@RequestBody Person person) {
    String ip = JSONPerson(person);
    LOG.info("Requested to get person ads");
    LOG.info(ip);
    PersonDaoImpl ob = new PersonDaoImpl();
    List<Ad> op = ob.getAllPersonAds(person);
    LOG.info("Person Ads fetched");
    String result = JSONAd(op);
    LOG.info(result);
    return result;
  }
}
