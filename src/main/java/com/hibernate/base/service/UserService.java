package com.hibernate.base.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.hibernate.base.Entities.User;

public interface UserService {
  public ResponseEntity<User> createUser(
      String username, Integer age, String address, Integer zipCode);

  public List<User> getUsers();

  public void deleteUser(Integer id);
}
