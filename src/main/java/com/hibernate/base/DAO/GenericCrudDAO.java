package com.hibernate.base.DAO;

import java.util.List;
import com.hibernate.base.Entities.User;

public interface GenericCrudDAO {
  public void addUser(User user);

  public User getUser();

  public List<User> getUsers();

  public void updateUser();

  public void deleteUser(Integer id);
}
