package service.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
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
        LOG.info("Ad inserted");
        return JSONAd(ad);
    }

}
