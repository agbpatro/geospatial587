package service.db.dao;

import java.util.List;

import service.db.model.Ad;
import service.db.model.AdBoundary;
import service.db.model.Boundary;

/**
 * Created by abhishek on 10/2/16.
 */
public interface AdBoundaryDao {

  public AdBoundary linkAdBoundary(Ad source, Boundary dest);

  public AdBoundary updateAdBoundary(Ad source, Boundary dest);

  public AdBoundary deleteAdBoundary(Ad source, Boundary dest);


}
