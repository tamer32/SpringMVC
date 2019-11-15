package com.hibernate.base.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserRole {
  @Column(name = "role_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer roleID;

  @Column private String roleName;

  //  @OneToMany(
  //      mappedBy = "role",
  //      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
  // CascadeType.REFRESH})
  //  private List<User> users;

  public UserRole(String roleName) {
    this.roleName = roleName;
  }

  public Integer getRoleID() {
    return roleID;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
}
