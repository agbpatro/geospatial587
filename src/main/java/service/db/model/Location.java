package service.db.model;

import org.apache.log4j.Logger;
import org.postgresql.geometric.PGpoint;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by abhishek on 10/3/16.
 */
public class Location implements Serializable {


  final static Logger LOG = Logger.getLogger(Location.class);
  PGpoint location;

  public PGpoint getLocation() {
    return location;
  }

  public void setLocation(String location) {
    try {
      this.location = new PGpoint(location);
    } catch (SQLException e) {
      LOG.error("Error building location", e);
    }
  }
}
