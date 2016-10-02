package service.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.db.impl.AdDaoImpl;
import service.db.model.Ad;

import static service.response.JsonResponse.JSONAd;

/**
 * Created by patro on 9/24/16.
 */

@RestController
@RequestMapping("/v1/ad")
public class AdController {



  final static Logger LOG = Logger.getLogger(AdController.class);

  @RequestMapping(value = "/buildAd",
      method = RequestMethod.POST,
      headers = {"Content-type=application/json"})
  @ResponseBody
  public String buildAd(@RequestBody Ad ad) {
    AdDaoImpl ob = new AdDaoImpl();
    Ad op = ob.insertAd(ad);
    LOG.info("Ad inserted");
    return JSONAd(op);
  }

}
