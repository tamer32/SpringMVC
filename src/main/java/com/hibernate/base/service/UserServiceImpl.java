package com.hibernate.base.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hibernate.base.DAO.GenericCrudDAO;
import com.hibernate.base.Entities.Address;
import com.hibernate.base.Entities.User;

@Service
public class UserServiceImpl implements UserService {
  @Autowired private GenericCrudDAO dao;

  public ResponseEntity<User> createUser(
      String username, Integer age, String address, Integer zipCode) {
    Address formAddress = new Address(address, zipCode);
    User user = new User(username, age, formAddress);
    dao.addUser(user);
    return ResponseEntity.ok(user);
  }

  public List<User> getUsers() {

    return dao.getUsers();
  }

  public void deleteUser(Integer id) {
    dao.deleteUser(id);
  }
}
