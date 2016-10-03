package service.db.impl;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.db.dao.AdDao;
import service.db.model.Ad;

import static service.Application.getConnection;
import static service.response.ResultWrapper.getAd;

/**
 * Created by abhishek on 10/2/16.
 */
public class AdDaoImpl implements AdDao {

  final static Logger LOG = Logger.getLogger(AdDaoImpl.class);

  @Override
  public Ad insertAd(Ad model) {
    Ad a = getAdByName(model);
    if (a != null) {
      return a;
    }
    String sql =
        "INSERT INTO AD (NAME, COUNTRY, CLICKCOUNT, IMPRESSIONS) VALUES (?,?,?,?) Returning *";
    Connection conn = getConnection();

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
        return getAd(rs);
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
    return null;

  }


  @Override
  public Ad clickAd(Ad model) {
    String sql =
        "UPDATE Ad SET clickCount = clickCount+1 WHERE id = ? Returning *";
    Connection conn = getConnection();

    try {
      //conn = dataSource.getConnection();
      //conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, model.getId());
      //int count = pstmt.executeUpdate();
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getAd(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error updating click count of ad", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return null;

  }

  @Override
  public Ad getAdById(Ad model) {
    String sql = "Select * from AD where id = ? limit 1";
    Connection conn = getConnection();

    try {
      //conn = dataSource.getConnection();
      //conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, model.getId());
      //int count = pstmt.executeUpdate();
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getAd(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error getting ad by id", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  @Override
  public Ad getAdByName(Ad model) {
    String sql = "Select * from AD where name = ? limit 1";
    Connection conn = getConnection();

    try {
      //conn = dataSource.getConnection();
      //conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, model.getName());
      //int count = pstmt.executeUpdate();
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getAd(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error getting ad by name", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  @Override
  public List<Ad> getAllAds() {
    String sql = "Select * from AD";
    Connection conn = getConnection();
    List<Ad> adList = new ArrayList<>();

    try {
      //conn = dataSource.getConnection();
      //conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      //int count = pstmt.executeUpdate();
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        adList.add(getAd(rs));
      }
    } catch (SQLException e) {
      LOG.error("Error getting all ads", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return adList;
  }

}
