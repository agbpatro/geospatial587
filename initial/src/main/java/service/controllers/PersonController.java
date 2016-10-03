package service.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import service.db.impl.PersonDaoImpl;
import service.db.model.Person;

import static service.response.JsonResponse.JSONPerson;

@RestController
@RequestMapping("/v1/person")
public class PersonController {


  final static Logger LOG = Logger.getLogger(PersonController.class);

  @RequestMapping(value = "/addperson",
      method = RequestMethod.POST,
      headers = {"Content-type=application/json"})
  @ResponseBody
  public String addPerson(@RequestBody Person person) {
    PersonDaoImpl ob = new PersonDaoImpl();
    Person op = ob.insertPerson(person);
    LOG.info("Person added");
    return JSONPerson(op);
  }


  @RequestMapping(value = "/getpersons",
      method = RequestMethod.GET)
  @ResponseBody
  public String getAllAds() {
    PersonDaoImpl ob = new PersonDaoImpl();
    List<Person> op = ob.getAllPersons();
    LOG.info("Persons fetched");
    return JSONPerson(op);
  }


}
