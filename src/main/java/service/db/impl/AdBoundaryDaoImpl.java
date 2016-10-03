package service.db.impl;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.db.dao.AdBoundaryDao;
import service.db.model.Ad;
import service.db.model.AdBoundary;
import service.db.model.Boundary;

import static service.Application.getConnection;
import static service.response.ResultWrapper.getAdBoundary;

/**
 * Created by abhishek on 10/2/16.
 */
public class AdBoundaryDaoImpl implements AdBoundaryDao {

  final static Logger LOG = Logger.getLogger(AdBoundaryDao.class);


  @Override
  public AdBoundary linkAdBoundary(Ad source, Boundary dest) {

    AdBoundary ab = getAdBoundaryMap(source, dest);
    if (ab != null) {
      return ab;
    }
    String sql =
        "INSERT INTO ADBOUNDARY (adId,boundaryId) VALUES (?,?) Returning *";
    Connection conn = getConnection();

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, source.getId());
      pstmt.setInt(2, dest.getId());
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getAdBoundary(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error inserting ad-boundary", e);
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
  public AdBoundary updateAdBoundary(Ad source, Boundary dest) {
    String sql =
        "UPDATE ADBOUNDARY set boundaryId = ?  where adId = ? Returning *";
    Connection conn = getConnection();

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, dest.getId());
      pstmt.setInt(2, source.getId());
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getAdBoundary(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error updating ad-boundary", e);
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
  public AdBoundary deleteAdBoundary(Ad source, Boundary dest) {
    String sql =
        "Delete from ADBOUNDARY where adId = ?  and boundaryId = ? Returning *";
    Connection conn = getConnection();

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, source.getId());
      pstmt.setInt(2, dest.getId());
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getAdBoundary(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error deleting ad-boundary", e);
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
  public AdBoundary getAdBoundaryMap(Ad source, Boundary dest) {
    String sql =
        "SELECT * from ADBOUNDARY where boundaryId = ? and adId = ?";
    Connection conn = getConnection();

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, dest.getId());
      pstmt.setInt(2, source.getId());
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getAdBoundary(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error fetching ad-boundary mapping", e);
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
}
