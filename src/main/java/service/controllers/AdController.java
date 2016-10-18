package service.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import service.db.impl.AdDaoImpl;
import service.db.impl.PersonAdDaoImpl;
import service.db.model.Ad;
import service.db.model.Location;
import service.db.model.Person;
import service.db.model.PersonAd;

import static service.db.impl.AdDaoImpl.CLICK;
import static service.db.impl.AdDaoImpl.IMPRESSION;
import static service.response.JsonResponse.JSONAd;

/**
 * Created by patro on 9/24/16.
 */

@RestController
@RequestMapping("/v1/ad")
public class AdController {


  final static Logger LOG = Logger.getLogger(AdController.class);

  @RequestMapping(value = "/buildad",
      method = RequestMethod.POST)
  @ResponseBody
  public String buildAd(@RequestBody Ad ad) {
    AdDaoImpl ob1 = new AdDaoImpl();
    PersonAdDaoImpl ob2 = new PersonAdDaoImpl();
    Ad op1 = ob1.insertAd(ad);
    LOG.info("Ad inserted");
    Person op2 = new Person();
    op2.setId(ad.getPersonId());
    PersonAd op3 = ob2.linkAdPerson(op1, op2);
    LOG.info("Ad Linked with person");
    op1.setPersonId(op3.getPersonId());
    String result = JSONAd(op1);
    LOG.info(result);
    return result;
  }


  @RequestMapping(value = "/getads",
      method = RequestMethod.GET)
  @ResponseBody
  public String getAllAds() {
    AdDaoImpl ob = new AdDaoImpl();
    List<Ad> op = ob.getAllAds();
    LOG.info("all ads fetched");
    String result = JSONAd(op);
    LOG.info(result);
    return result;
  }


  @RequestMapping(value = "/clickad",
      method = RequestMethod.POST)
  @ResponseBody
  public String clickAd(@RequestBody Ad ad) {
    AdDaoImpl ob = new AdDaoImpl();
    Ad op = ob.clickAd(ad, CLICK);
    LOG.info("Ad updated click count");
    String result = JSONAd(op);
    LOG.info(result);
    return result;
  }


  @RequestMapping(value = "/impressionad",
      method = RequestMethod.POST)
  @ResponseBody
  public String impressionAd(@RequestBody Ad ad) {
    AdDaoImpl ob = new AdDaoImpl();
    Ad op = ob.clickAd(ad, IMPRESSION);
    LOG.info("Ad updated impression count");
    String result = JSONAd(op);
    LOG.info(result);
    return result;
  }


  @RequestMapping(value = "/getad",
      method = RequestMethod.POST)
  @ResponseBody
  public String getAd(@RequestBody Location location) {
    AdDaoImpl ob = new AdDaoImpl();
    Ad op1 = ob.getAdByLocation(location);
    LOG.info("Ad fetched by location");
    String result = JSONAd(op1);
    LOG.info(result);
    return result;
  }


}
