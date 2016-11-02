package service.db.impl;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.db.dao.PersonAdDao;
import service.db.model.Ad;
import service.db.model.Person;
import service.db.model.PersonAd;

import static service.Application.getConnection;
import static service.response.ResultWrapper.getPersonAd;

/**
 * Created by abhishek on 10/2/16.
 */
public class PersonAdDaoImpl implements PersonAdDao {


  final static Logger LOG = Logger.getLogger(PersonAdDaoImpl.class);

  @Override
  public PersonAd linkAdPerson(Ad source, Person dest) {
    PersonAd pa = getPersonAdMap(source, dest);
    if (pa != null && pa.getAdId() == source.getId() && pa.getPersonId() == dest.getId() ) {
      return pa;
    }
    String sql =
        "INSERT INTO PERSONAD (adId,personId) VALUES (?,?) Returning *";
    Connection conn = getConnection();

    try {
      //conn = dataSource.getConnection();
      //conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, source.getId());
      pstmt.setInt(2, dest.getId());
      //int count = pstmt.executeUpdate();
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getPersonAd(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error inserting person-ad", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          LOG.error("Error closing connection", e);
        }
      }
    }
    return null;

  }

  @Override
  public PersonAd updateAdPerson(Ad source, Person dest) {
    String sql =
        "UPDATE PERSONAD set adId = ?  where personId = ? Returning *";
    Connection conn = getConnection();

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, source.getId());
      pstmt.setInt(2, dest.getId());
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getPersonAd(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error updating person-ad", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          LOG.error("Error closing connection", e);
        }
      }
    }
    return null;

  }

  @Override
  public PersonAd deleteAdPerson(Ad source, Person dest) {
    String sql =
        "Delete from PERSONAD where adId = ?  and personId = ? Returning *";
    Connection conn = getConnection();

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, source.getId());
      pstmt.setInt(2, dest.getId());
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getPersonAd(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error deleting person-ad", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          LOG.error("Error closing connection", e);
        }
      }
    }
    return null;

  }

  @Override
  public PersonAd getPersonAdMap(Ad source, Person dest) {
    String sql =
        "Select * from PERSONAD where adId = ? and personId = ? limit 1";
    Connection conn = getConnection();

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, source.getId());
      pstmt.setInt(2, dest.getId());
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return getPersonAd(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error fetching person-ad mapping", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          LOG.error("Error closing connection", e);
        }
      }
    }
    return null;

  }
}
