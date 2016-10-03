package service.db.impl;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.db.dao.BoundaryDao;
import service.db.model.Boundary;

import static service.Application.getConnection;
import static service.response.ResultWrapper.getBoundary;

/**
 * Created by abhishek on 10/2/16.
 */
public class BoundaryDaoImpl implements BoundaryDao {

  final static Logger LOG = Logger.getLogger(BoundaryDaoImpl.class);


  @Override
  public Boundary insertBoundary(Boundary model) {
    String sql =
        "INSERT INTO BOUNDARY (NAME) VALUES (?) Returning *";
    Connection conn = getConnection();

    try {
      //conn = dataSource.getConnection();
      //conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, model.getName());
      //int count = pstmt.executeUpdate();
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getBoundary(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error inserting boundary", e);
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
  public Boundary getBoundaryById(Boundary model) {
    String sql = "Select * from Boundary where id = ? limit 1";
    Connection conn = getConnection();

    try {
      //conn = dataSource.getConnection();
      //conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, model.getId());
      //int count = pstmt.executeUpdate();
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        getBoundary(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error getting all boundaries", e);
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
  public List<Boundary> getAllBoundaries() {
    String sql = "Select * from Boundary";
    Connection conn = getConnection();
    List<Boundary> boundaryList = new ArrayList<>();

    try {
      //conn = dataSource.getConnection();
      //conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      //int count = pstmt.executeUpdate();
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        boundaryList.add(getBoundary(rs));
      }
    } catch (SQLException e) {
      LOG.error("Error getting all boundaries", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return boundaryList;
  }
}
