package service.db.model;

import org.apache.log4j.Logger;
import org.postgresql.geometric.PGpoint;
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

  int personId;

  String videourl;

  String type;

  PGpolygon fence;

  String clickurl;

  float xAttribute;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setId(String id) {
    this.id = Integer.parseInt(id);
  }

  public int getImpressions() {
    return impressions;
  }

  public void setImpressions(int impressions) {
    this.impressions = impressions;
  }

  public void setImpressions(String impressions) {
    this.impressions = Integer.parseInt(impressions);
  }

  public float getBudget() {
    return budget;
  }

  public void setBudget(float budget) {
    this.budget = budget;
  }

  public void setBudget(String budget) {
    this.budget = Float.parseFloat(budget);
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

  public void setAmountLeft(String amountLeft) {
    this.amountLeft = Float.parseFloat(amountLeft);
  }

  public void setAmountLeft(float amountLeft) {
    this.amountLeft = amountLeft;
  }

  public int getClickCount() {
    return clickCount;
  }

  public void setClickCount(String clickCount) {
    this.clickCount = Integer.parseInt(clickCount);
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

  public void setImageId(String imageId) {
    this.imageId = Integer.parseInt(imageId);
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

  public String getVideourl() {
    return videourl;
  }

  public void setVideourl(String videourl) {
    this.videourl = videourl;
  }

  public String getType() {
    if (type == null) {
      return "None";
    }
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
      if (fence != null && fence.length() > 0) {
        fence = fence.replaceAll(" ", "");
        this.fence = new PGpolygon(fence);
      } else {
        this.fence = new PGpolygon();
      }
    } catch (SQLException e) {
      LOG.error("Error building polygon", e);
    }
  }

  public String getClickurl() {
    return clickurl;
  }

  public void setClickurl(String clickurl) {
    this.clickurl = clickurl;
  }

  public float getxAttribute() {
    return xAttribute;
  }

  public void setxAttribute(float xAttribute) {
    this.xAttribute = xAttribute;
  }

  public void setxAttribute(String xAttribute) {
    this.xAttribute = Float.parseFloat(xAttribute);
  }

  public PGpoint getCentroid() {

    PGpoint p = new PGpoint(0, 0);
    if (fence != null) {
      try {
        String ip = fence.toString();
        int len = fence.points.length - 1;
        if (len <= 0) {
          len = 1;
        }
        ip = ip.substring(2, ip.length() - 2);
        String[] inputs = ip.split("\\),\\(");
        double x = 0.0, y = 0.0;
        for (int i = 1; i <= len; i++) {
          String[] temp = inputs[i].split(",");
          x += Double.parseDouble(temp[0]);
          y += Double.parseDouble(temp[1]);
        }
        x /= len;
        y /= len;
        p = new PGpoint(x, y);


      } catch (Exception e) {
        LOG.error("Error getting centroid");
      }
    }
    return p;

  }

}
