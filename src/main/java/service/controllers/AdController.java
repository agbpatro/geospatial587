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
import service.db.model.Person;

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
    ob2.linkAdPerson(op1, op2);
    LOG.info("Ad Linked with person");
    op2.setId(op1.getPersonId());
    return JSONAd(op1);
  }


  @RequestMapping(value = "/getads",
      method = RequestMethod.GET)
  @ResponseBody
  public String getAllAds() {
    AdDaoImpl ob = new AdDaoImpl();
    List<Ad> op = ob.getAllAds();
    LOG.info("all ads fetched");
    return JSONAd(op);
  }


  @RequestMapping(value = "/clickad",
      method = RequestMethod.POST)
  @ResponseBody
  public String clickAd(@RequestBody Ad ad) {
    AdDaoImpl ob = new AdDaoImpl();
    Ad op = ob.clickAd(ad);
    LOG.info("Ad updated click count");
    return JSONAd(op);
  }

}
