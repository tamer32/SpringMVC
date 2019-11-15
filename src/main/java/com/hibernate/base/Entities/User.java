package com.hibernate.base.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class User {
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Integer id;

  @Column private String username;

  @Column private Integer age;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id")
  private Address address;

  //  @ManyToOne(
  //      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
  // CascadeType.REFRESH})
  //  @JoinColumn(name = "role_id")
  //  private UserRole role;

  public User() {}

  public User(String username, Integer age, Address address) {

    this.username = username;
    this.age = age;
    this.address = address;
    // this.role = role;
  }

  public Integer getId() {
    return id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "User [id="
        + id
        + ", username="
        + username
        + ", age="
        + age
        + ", address="
        + address
        + "]";
  }
}
