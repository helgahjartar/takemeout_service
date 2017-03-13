package com.takemeout.user.authservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.List;
import java.io.File;
import org.hibernate.query.Query;
import org.hibernate.Session;
import com.takemeout.util.SessionUtil;
import com.takemeout.user.exceptions.UserNameConflictException;
import org.springframework.stereotype.Component;
import com.takemeout.user.authservice.requests.*;
import com.takemeout.user.entities.User;

@Component(value = "UserDAO")
public class UserDAO implements IUserDAO {

  public User getUser(String userName) {
    Session session = SessionUtil.getSessionFactory().openSession();
    session.beginTransaction();

    User user = null;
    Query<User> query = session.createQuery("from User u where userName = :userName", User.class);
    user = query.uniqueResult();
    session.flush();
    session.getTransaction().commit();
    session.close();
    return user;
  }

  @SuppressWarnings("unchecked")
  public List<User> getUsers() {
    Session session = SessionUtil.getSessionFactory().openSession();
    session.beginTransaction();

    List<User> users = null;
    Query<User> query = session.createQuery("from User", User.class);
    users = query.list();
    session.flush();
    session.getTransaction().commit();
    session.close();
    return users;
  }

  public void saveUser(RegisterUserRequest user) throws Exception {
    Session session = SessionUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      User newUser = new User(user.getUserName(), user.getPasswordHash(), user.getEmail());
      session.save(newUser);
      session.getTransaction().commit();
    } catch(Exception e) {
      session.getTransaction().rollback();
      throw e;
    } finally {
      session.close();
    }
  }
}
