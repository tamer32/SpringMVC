package com.hibernate.base.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Address {

  @Id
  @Column(name = "address_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer addressID;

  @Column private String address;

  @Column private Integer zipCode;

  public Address() {
    super();
  }

  public Address(String address, Integer zipCode) {
    this.address = address;
    this.zipCode = zipCode;
  }

  public Integer getAddressID() {
    return addressID;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getZipCode() {
    return zipCode;
  }

  public void setZipCode(Integer zipCode) {
    this.zipCode = zipCode;
  }
}
