package service.db.model;

import org.apache.log4j.Logger;
import org.postgresql.geometric.PGpolygon;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by patro on 9/24/16.
 */
//@Entity
public class Ad implements Serializable {


  final static Logger LOG = Logger.getLogger(Ad.class);

  int id;

  int imageId;

  int impressions;

  float budget;

  float amountLeft;

  String name;

  String country;

  int clickCount;

  int boundaryId;

  int personId;

  String url;

  String type;

  PGpolygon fence;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getImpressions() {
    return impressions;
  }

  public void setImpressions(int impressions) {
    this.impressions = impressions;
  }

  public float getBudget() {
    return budget;
  }

  public void setBudget(float budget) {
    this.budget = budget;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public float getAmountLeft() {
    return amountLeft;
  }

  public void setAmountLeft(float amountLeft) {
    this.amountLeft = amountLeft;
  }

  public int getClickCount() {
    return clickCount;
  }

  public void setClickCount(int clickCount) {
    this.clickCount = clickCount;
  }

  public int getImageId() {
    return imageId;
  }

  public void setImageId(int imageId) {
    this.imageId = imageId;
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public PGpolygon getFence() {
    return fence;
  }

  public void setFence(String fence) {
    try {
      this.fence = new PGpolygon(fence);
    } catch (SQLException e) {
      LOG.error("Error building polygon", e);
    }
  }


}
