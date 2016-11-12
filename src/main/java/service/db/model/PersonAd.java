package service.db.model;

/**
 * Created by patro on 9/24/16.
 */
public class PersonAd {

  int id;
  int personId;
  int adId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setId(String id) {
    this.id = Integer.parseInt(id);
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public void setPersonId(String personId) {
    this.personId = Integer.parseInt(personId);
  }

  public int getAdId() {
    return adId;
  }

  public void setAdId(int adId) {
    this.adId = adId;
  }

  public void setAdId(String adId) {
    this.adId = Integer.parseInt(adId);
  }


}
