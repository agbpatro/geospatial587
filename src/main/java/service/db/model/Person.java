package service.db.model;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getId() {
    return id;
  }

  public void setId(String id) {
    this.id = Integer.parseInt(id);
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

}
