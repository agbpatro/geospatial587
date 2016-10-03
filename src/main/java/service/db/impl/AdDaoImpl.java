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

  public final static String IMPRESSION = "impression";
  public final static String CLICK = "click";
  final static Logger LOG = Logger.getLogger(AdDaoImpl.class);

  @Override
  public Ad insertAd(Ad model) {
    model.setAmountLeft(model.getBudget());
    Ad a = getAdByName(model);
    if (a != null) {
      return a;
    }
    String sql =
        "INSERT INTO AD (NAME, COUNTRY, CLICKCOUNT, BUDGET, AMOUNTLEFT, TYPE, URL) VALUES (?,?,?,?,?,?,?) Returning *";
    Connection conn = getConnection();

    try {
      //conn = dataSource.getConnection();
      //conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, model.getName());
      pstmt.setString(2, model.getCountry());
      pstmt.setInt(3, model.getClickCount());
      pstmt.setFloat(4, model.getBudget());
      pstmt.setFloat(5, model.getAmountLeft());
      pstmt.setString(6, model.getType());
      pstmt.setString(7, model.getUrl());
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
  public Ad clickAd(Ad model, String type) {
    String sql;
    if (type.equals(CLICK)) {
      sql =
          "UPDATE Ad SET clickCount = clickCount+1 , impressions = impressions+1 , amountLeft = amountLeft - 2 WHERE id = ? Returning *";
    } else {
      sql = "UPDATE Ad SET impressions = impressions+1 , amountLeft = amountLeft - 1 WHERE id = ? Returning *";
    }
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
