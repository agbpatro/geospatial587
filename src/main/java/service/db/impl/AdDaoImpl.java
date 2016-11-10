package service.db.impl;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import service.db.dao.AdDao;
import service.db.model.Ad;
import service.db.model.Location;

import static service.Application.getConnection;
import static service.db.model.Location.NN;
import static service.db.model.Location.RANDOM;
import static service.db.model.Location.SKYLINE;
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
    String
        sql =
        "INSERT INTO AD (NAME, COUNTRY, CLICKCOUNT, BUDGET, AMOUNTLEFT, TYPE, VIDEOURL, FENCE, CLICKURL, XATTRIBUTE) VALUES (?,?,?,?,?,?,?,?,?,area(path(?))) Returning *";
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
      pstmt.setString(7, model.getVideourl());
      pstmt.setObject(8, model.getFence());
      pstmt.setObject(9, model.getClickurl());
      pstmt.setObject(10, model.getFence());
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
          LOG.error("Error closing connection", e);
        }
      }
    }
    return null;

  }


  @Override
  public Ad deleteAd(Ad model) {
    String
        sql = "Delete from AD where id = ?  Returning *";
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
      LOG.error("Error deleting ad", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          LOG.error("Error closing connection", e);
        }
      }
    }
    return model;

  }


  @Override
  public Ad clickAd(Ad model, String type) {
    String sql;
    if (type.equals(CLICK)) {
      sql =
          "UPDATE Ad SET clickCount = clickCount+1 , amountLeft = amountLeft - 2 WHERE id = ? Returning *";
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
          LOG.error("Error closing connection", e);
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
          LOG.error("Error closing connection", e);
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
          LOG.error("Error closing connection", e);
        }
      }
    }
    return null;
  }


  private Ad getRandomAd(List<Ad> adList) {
    Random rn = new Random();
    return adList.get(rn.nextInt(adList.size()));
  }

  private Ad skylinePick(List<Ad> adList, Ad randomAd) {
    Iterator<Ad> adIterator = adList.iterator();
    List<Ad> dominantAdList = new ArrayList<>();
    Ad dominantAd = randomAd;
    while (adIterator.hasNext()) {
      boolean dominant = true;
      Ad candidate = adIterator.next();
      float candidateY = 1.0f / (candidate.getAmountLeft() + 1.0f);
      for (Ad elt : adList) {
        if (candidate.getId() != elt.getId()) {
          float eltY = 1.0f / (elt.getAmountLeft() + 1.0f);
          boolean condY = candidateY >= eltY;
          boolean condX = candidate.getxAttribute() >= elt.getxAttribute();
          boolean totalCondition = (candidateY == eltY) && (candidate.getxAttribute() == elt.getxAttribute());
          if (!totalCondition) {
            if (condY && condX) {
              //if (!((candidateY >= eltY) && (candidate.getxAttribute() >= elt.getxAttribute()))) {
              dominant = false;
              break;
            }
          }
        }
      }
      if (dominant) {
        dominantAdList.add(candidate);
      }
    }
    if (dominantAdList.size() > 0) {
      LOG.info("Size of dominated ads : " + String.valueOf(dominantAdList.size()));
      dominantAd = getRandomAd(dominantAdList);
    }
    return dominantAd;
  }

  @Override
  public Ad getAdByLocation(Location model) {
    String sql = "select * from AD where fence @> ? and amountLeft > 0";
    Connection conn = getConnection();
    List<Ad> adList = new ArrayList<>();
    Ad selectedAd = null;
    if (model.getType().equals(NN)) {
      selectedAd = nearestNeighbor(model);
    } else {
      try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setObject(1, model.getLocation());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          adList.add(getAd(rs));
        }
        if (adList.size() > 0) {
          // Random rn = new Random();
          // Ad selectedAd = adList.get(rn.nextInt(adList.size()));
          Ad randomAd = getRandomAd(adList);
          if (model.getType().equals(RANDOM)) {
            selectedAd = randomAd;
          } else if (model.getType().equals(SKYLINE)) {
            selectedAd = skylinePick(adList, randomAd);
          }
        }
      } catch (SQLException e) {
        LOG.error("Error getting ad by name", e);
      } finally {
        if (conn == null) {
          try {
            conn.close();
          } catch (SQLException e) {
            LOG.error("Error closing connection", e);
          }
        }
      }
      if (selectedAd == null) {
        selectedAd = nearestNeighbor(model);
      }
    }
    return clickAd(selectedAd, IMPRESSION);

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
          LOG.error("Error closing connection", e);
        }
      }
    }
    return adList;
  }


  private Ad nearestNeighbor(Location model) {
    String
        sql =
        "select ? <-> @@ fence as dist , * from ad where amountleft > 0 order by dist asc , amountleft desc limit 1";
    Connection conn = getConnection();
    Ad nearestAd = new Ad();

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setObject(1, model.getLocation());
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        nearestAd = getAd(rs);
      }
    } catch (SQLException e) {
      LOG.error("Error getting ad by name", e);
    } finally {
      if (conn == null) {
        try {
          conn.close();
        } catch (SQLException e) {
          LOG.error("Error closing connection", e);
        }
      }
    }
    return nearestAd;
  }

}
