package service.db.model;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Created by sridharyadav on 9/23/16.
 */
public class Person {
    private int id;
    private String name;
    private int age;
    private String city;
    // getters & setters ...


    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

}
