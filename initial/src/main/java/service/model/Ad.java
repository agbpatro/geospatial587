package service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.norberg.automatter.AutoMatter;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by patro on 9/24/16.
 */
@Entity
public class Ad implements Serializable {


    int id;
    int impressions;

    int boundaryId;
    float budget, amountLeft;
    String name, country;

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
