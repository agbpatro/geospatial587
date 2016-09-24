package service.db.model;

/**
 * Created by patro on 9/24/16.
 */
public class AdBoundary {
    int id;
    int adId;
    int boundaryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public int getBoundaryId() {
        return boundaryId;
    }

    public void setBoundaryId(int boundaryId) {
        this.boundaryId = boundaryId;
    }


}
