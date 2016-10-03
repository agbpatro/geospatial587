package service.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.db.impl.AdBoundaryDaoImpl;
import service.db.impl.BoundaryDaoImpl;
import service.db.model.Ad;
import service.db.model.Boundary;

import static service.response.JsonResponse.JSONBoundary;

/**
 * Created by patro on 9/24/16.
 */

@RestController
@RequestMapping("/v1/boundary")
public class BoundaryController {

  final static Logger LOG = Logger.getLogger(BoundaryController.class);

  @RequestMapping(value = "/new",
      method = RequestMethod.POST,
      headers = {"Content-type=application/json"})
  @ResponseBody
  public String buildBoundary(@RequestBody Boundary boundary) {
    BoundaryDaoImpl ob = new BoundaryDaoImpl();
    AdBoundaryDaoImpl ob1 = new AdBoundaryDaoImpl();
    Boundary op1 = ob.insertBoundary(boundary);
    LOG.info("Boundary inserted");
    Ad op2 = new Ad();
    op2.setId(boundary.getAdId());
    ob1.linkAdBoundary(op2, op1);
    LOG.info("Boundary Linked");
    return JSONBoundary(boundary);
  }
}
