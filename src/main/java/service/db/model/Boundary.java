package service.db.model;

/**
 * Created by patro on 9/24/16.
 */
public class Boundary {

  int id;

  String name;

  int boundaryId;

  int adId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBoundaryId() {
    return boundaryId;
  }

  public void setBoundaryId(int boundaryId) {
    this.boundaryId = boundaryId;
  }

  public int getAdId() {
    return adId;
  }

  public void setAdId(int adId) {
    this.adId = adId;
  }
}
