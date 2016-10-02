package service.db.impl;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import service.db.dao.AdDao;
import service.db.model.Ad;

/**
 * Created by abhishek on 10/2/16.
 */
public class AdDaoImpl implements AdDao {

  final static Logger LOG = Logger.getLogger(AdDaoImpl.class);
  final static private String database = "POSTGRESQL";
  final static private String username = "shudhgvf";
  final static private String password = "NPXQ1d2eVU32ouq7SfyGwcu9-C5m0Iug";
  final static private String
      connection =
      "postgres://shudhgvf:NPXQ1d2eVU32ouq7SfyGwcu9-C5m0Iug@elmer.db.elephantsql.com:5432/shudhgvf";


  private DataSource dataSource;

  public Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.postgresql.Driver");
    return DriverManager.getConnection(connection, username, password);

  }

  @Override
  public boolean insertAd(Ad model) {
    String sql =
        "INSERT INTO USERS (NAME, COUNTRY, CLICKCOUNT, IMPRESSIONS) VALUES (?,?,?,?)";
    boolean success = false;
    Connection conn = null;

    try {
      //conn = dataSource.getConnection();
      conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, model.getName());
      pstmt.setString(2, model.getCountry());
      pstmt.setInt(3, model.getClickCount());
      pstmt.setInt(4, model.getImpressions());
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        success = true;
      }
    } catch (SQLException e) {
      LOG.error("Error inserting ad", e);
    } catch (ClassNotFoundException e) {
      LOG.error("Error finding sql driver", e);
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return success;

  }

}
