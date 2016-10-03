package service.db.dao;

import java.util.List;

import service.db.model.Ad;
import service.db.model.Boundary;

/**
 * Created by abhishek on 10/2/16.
 */
public interface BoundaryDao {

  public Boundary insertBoundary(Boundary model);


  public Boundary getBoundaryById(Boundary model);


  public List<Boundary> getAllBoundaries();

}
