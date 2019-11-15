package com.hibernate.base.DAO;

import java.util.List;
import javax.persistence.Query;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hibernate.base.Entities.User;

@Transactional
@Repository
public class DAOImpl implements GenericCrudDAO {
  @Autowired private SessionFactory sessionFactory;

  @Before(value = "")
  public void init() {}

  public void addUser(User user) {
    // Session session = this.session.getCurrentSession();
    Session session = sessionFactory.getCurrentSession();
    session.persist(user);
  }

  public void deleteUser(Integer id) {
    Session session = sessionFactory.getCurrentSession();
    Query deleteUser = session.createQuery("delete from users where user_id =" + id);
  }

  public User getUser() {

    return null;
  }

  @SuppressWarnings("unchecked")
  public List<User> getUsers() {
    Session session = sessionFactory.getCurrentSession();
    Query getAllUsers = session.createQuery("from User");
    return getAllUsers.getResultList();
  }

  public void updateUser() {
    // TODO Auto-generated method stub

  }
}
