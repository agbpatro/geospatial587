package service;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class Application {

  final static Logger LOG = Logger.getLogger(Application.class);
  final static private String username = "spatialdb";
  final static private String password = "spatialad";
  final static private String
      connection =
      "jdbc:postgresql://geospatialdb.cqeod3cq54hm.us-west-2.rds.amazonaws.com:5432/geospatialdb?user=spatialdb&password=spatialad";
  public static Connection conn;
  //"jdbc:postgresql://shudhgvf:NPXQ1d2eVU32ouq7SfyGwcu9-C5m0Iug@elmer.db.elephantsql.com:5432/shudhgvf";

 /*
  final static private String username = "spatialdb";
  final static private String password = "spatialad";
  final static private String
      connection =
      "geospatialdb.cqeod3cq54hm.us-west-2.rds.amazonaws.com:5432";
       */

  public static Connection getConnection() {
    if (conn == null) {
      try {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(connection, username, password);
      } catch (Exception e) {
        LOG.error("error connecting to db", e);
      }
      return null;
    } else {
      return conn;
    }
  }

  public static void main(String[] args) {
    conn = getConnection();
    if (conn != null) {
      ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
    LOG.debug("Let's inspect the beans provided by Spring Boot:");
    LOG.info("Application online");
        /*
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            LOG.debug(beanName);
        }
        */
  }

}
