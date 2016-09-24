package service.db.model;

import java.io.Serializable;

/**
 * Created by patro on 9/24/16.
 */
//@Entity
public class Ad implements Serializable {


    //@Column(name = "id", nullable = false)
    int id;

    //@Column(name = "impressions", nullable = false)
    int impressions;


    //@Column(name = "boundaryId", nullable = true)
    int boundaryId;

    //@Column(name = "budget", nullable = true)
    float budget;

    //@Column(name = "amountLeft", nullable = true)
    float amountLeft;

    //@Column(name = "name", nullable = false)
    String name;

    //@Column(name = "country", nullable = false)
    String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImpressions() {
        return impressions;
    }

    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(float amountLeft) {
        this.amountLeft = amountLeft;
    }

    public int getBoundaryId() {
        return boundaryId;
    }

    public void setBoundaryId(int boundaryId) {
        this.boundaryId = boundaryId;
    }


}
