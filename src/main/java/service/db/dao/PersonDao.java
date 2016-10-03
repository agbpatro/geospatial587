package service.db.dao;

import java.util.List;

import service.db.model.Person;

/**
 * Created by abhishek on 10/2/16.
 */
public interface PersonDao {

  public Person insertPerson(Person model);

  public Person getPersonById(Person model);

  public Person getPersonByName(Person model);

  public List<Person> getAllPersons();

}
