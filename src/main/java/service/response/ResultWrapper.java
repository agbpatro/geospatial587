package service.response;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

import service.db.model.Ad;
import service.db.model.AdBoundary;
import service.db.model.Boundary;
import service.db.model.Person;
import service.db.model.PersonAd;

/**
 * Created by abhishek on 10/2/16.
 */
public class ResultWrapper {

  final static Logger LOG = Logger.getLogger(ResultWrapper.class);

  public static Ad getAd(ResultSet rs) throws SQLException {
    Ad ad = new Ad();
    ad.setId(rs.getInt("id"));
    ad.setName(rs.getString("name"));
    ad.setImageId(rs.getInt("imageId"));
    ad.setClickCount(rs.getInt("clickCount"));
    ad.setImpressions(rs.getInt("impressions"));
    ad.setBudget(rs.getFloat("budget"));
    ad.setCountry(rs.getString("country"));
    return ad;
  }

  public static Person getPerson(ResultSet rs) throws SQLException {
    Person person = new Person();
    person.setId(rs.getInt("id"));
    person.setName(rs.getString("name"));
    person.setAge(rs.getInt("age"));
    person.setCity(rs.getString("city"));
    return person;
  }


  public static Boundary getBoundary(ResultSet rs) throws SQLException {
    Boundary boundary = new Boundary();
    boundary.setId(rs.getInt("id"));
    return boundary;
  }

  public static AdBoundary getAdBoundary(ResultSet rs) throws SQLException {
    AdBoundary adBoundary = new AdBoundary();
    adBoundary.setId(rs.getInt("id"));
    return adBoundary;
  }

  public static PersonAd getPersonAd(ResultSet rs) throws SQLException {
    PersonAd personAd = new PersonAd();
    personAd.setId(rs.getInt("id"));
    personAd.setAdId(rs.getInt("adId"));
    personAd.setPersonId(rs.getInt("personId"));
    return personAd;
  }

}
