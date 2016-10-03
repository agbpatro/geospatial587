package service.response;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import service.db.model.Ad;
import service.db.model.AdBoundary;
import service.db.model.Boundary;
import service.db.model.Person;
import service.db.model.PersonAd;

/**
 * Created by sridharyadav on 9/23/16.
 */
public class JsonResponse {


  public final static String IMAGE = "image";
  public final static String VIDEO = "video";

  final static Logger LOG = Logger.getLogger(JsonResponse.class);

  public static String jsonOutput(String ip) {
    JSONObject obj = new JSONObject();

    try {
      obj.put("Input", ip);
      return obj.toString();
    } catch (JSONException e) {
      LOG.error("Error building json string responses", e);
      return "";
    }

  }

  public static String standardResponse(String status, String message) {
    JSONObject obj = new JSONObject();

    try {
      obj.put("Status", status);
      obj.put("Message", message);
      return obj.toString();
    } catch (JSONException e) {
      LOG.error("Error building standard responses", e);
      return "";
    }
  }

  public static String JSONPerson(Person person) {
    ArrayList<Person> temp = new ArrayList<>();
    temp.add(person);
    return JSONPerson(temp);
  }


  public static String JSONAd(Ad ad) {
    ArrayList<Ad> temp = new ArrayList<>();
    temp.add(ad);
    return JSONAd(temp);
  }

  public static String JSONAd(List<Ad> ads) {
    JSONArray responseArray = new JSONArray();
    try {
      for (Ad ad : ads) {
        if (ad != null) {
          JSONObject obj = new JSONObject();
          obj.put("id", ad.getId());
          obj.put("type", ad.getType());
          obj.put("url", ad.getUrl());
          obj.put("boundaryId", ad.getBoundaryId());
          obj.put("personId", ad.getPersonId());
          obj.put("imageId", ad.getImageId());
          obj.put("name", ad.getName());
          obj.put("budget", ad.getBudget());
          obj.put("country", ad.getCountry());
          obj.put("impressions", ad.getImpressions());
          obj.put("amountLeft", ad.getAmountLeft());
          obj.put("clickCount", ad.getClickCount());
          if (ad.getImpressions() != 0) {
            obj.put("ctr", (ad.getClickCount() * 100.0) / (1.0 * ad.getImpressions()));
          } else {
            obj.put("ctr", 0);
          }
          responseArray.put(obj);
        }
      }
      return responseArray.toString();
    } catch (JSONException e) {
      LOG.error("Error parsing ad object", e);
      return "";
    }

  }


  public static String JSONPerson(List<Person> persons) {
    JSONArray responseArray = new JSONArray();
    try {
      for (Person person : persons) {
        if (person != null) {
          JSONObject obj = new JSONObject();
          obj.put("id", person.getId());
          obj.put("name", person.getName());
          obj.put("age", person.getAge());
          obj.put("city", person.getCity());
          responseArray.put(obj);
        }
      }
      return responseArray.toString();
    } catch (JSONException e) {
      LOG.error("Error parsing person object", e);
      return "";
    }

  }


  public static String JSONBoundary(Boundary boundary) {
    JSONObject obj = new JSONObject();
    try {
      obj.put("id", boundary.getId());
      obj.put("adId", boundary.getAdId());
      return obj.toString();
    } catch (JSONException e) {
      LOG.error("Error parsing boundary object", e);
      return "";
    }
  }


  public static String JSONPersonAd(PersonAd personAd) {
    JSONObject obj = new JSONObject();

    try {
      obj.put("id", personAd.getId());
      obj.put("personId", personAd.getPersonId());
      obj.put("adId", personAd.getAdId());
      return obj.toString();

    } catch (JSONException e) {
      LOG.error("Error parsing person ad mapping object", e);
      return "";
    }
  }


  public static String JSONAdBoundary(AdBoundary adBoundary) {
    JSONObject obj = new JSONObject();

    try {
      obj.put("id", adBoundary.getId());
      obj.put("boundaryId", adBoundary.getBoundaryId());
      obj.put("adId", adBoundary.getAdId());
      return obj.toString();

    } catch (JSONException e) {
      LOG.error("Error parsing ad boundary mapping object", e);
      return "";
    }
  }
}
