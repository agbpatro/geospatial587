package service.db.dao;

import service.db.model.Ad;
import service.db.model.Person;

import java.util.List;

/**
 * Created by abhishek on 10/2/16.
 */
public interface PersonDao {

  public Person insertPerson(Person model);

  public Person getPersonById(Person model);

  public Person getPersonByName(Person model);

  public List<Person> getAllPersons();

  public List<Ad> getAllPersonAds(String name);

}
