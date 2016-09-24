package service.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
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
        LOG.info("Boundary insertedd");
        return JSONBoundary(boundary);
    }
}
