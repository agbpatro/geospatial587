package service.db.dao;

import service.db.model.Ad;
import service.db.model.Person;
import service.db.model.PersonAd;

/**
 * Created by abhishek on 10/2/16.
 */
public interface PersonAdDao {

  public PersonAd linkAdPerson(Ad source, Person dest);

  public PersonAd updateAdPerson(Ad source, Person dest);

  public PersonAd deleteAdPerson(Ad source, Person dest);

  public PersonAd getPersonAdMap(Ad source, Person dest);


}
