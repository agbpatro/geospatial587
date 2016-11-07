package service.db.dao;

import java.util.List;

import service.db.model.Ad;
import service.db.model.Location;

/**
 * Created by abhishek on 10/1/16.
 */
public interface AdDao {


  public Ad insertAd(Ad model);

  public Ad deleteAd(Ad model);

  public Ad clickAd(Ad model, String type);

  public Ad getAdById(Ad model);

  public Ad getAdByName(Ad model);

  public Ad getAdByLocation(Location model);


  public List<Ad> getAllAds();
}
