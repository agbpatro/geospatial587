package service.db.impl;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.Application;
import service.db.dao.AdDao;
import service.db.model.Ad;

/**
 * Created by abhishek on 10/2/16.
 */
public class AdDaoImpl implements AdDao {

  final static Logger LOG = Logger.getLogger(AdDaoImpl.class);

  @Override
  public Ad insertAd(Ad model) {
    String sql =
        "INSERT INTO AD (NAME, COUNTRY, CLICKCOUNT, IMPRESSIONS) VALUES (?,?,?,?) Returning *";
    boolean success = false;
    Connection conn = Application.conn;
    Ad ad = new Ad();

    try {
      //conn = dataSource.getConnection();
      //conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, model.getName());
      pstmt.setString(2, model.getCountry());
      pstmt.setInt(3, model.getClickCount());
      pstmt.setInt(4, model.getImpressions());
      //int count = pstmt.executeUpdate();
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        ad.setId(rs.getInt("id"));
        ad.setName(rs.getString("name"));
        ad.setImageId(rs.getInt("imageId"));
        ad.setBoundaryId(rs.getInt("boundaryId"));
        ad.setClickCount(rs.getInt("clickCount"));
        ad.setImpressions(rs.getInt("impressions"));
        ad.setBudget(rs.getFloat("budget"));
        ad.setCountry(rs.getString("country"));
        success = true;
        return ad;
      }
    } catch (SQLException e) {
      LOG.error("Error inserting ad", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return ad;

  }

}
