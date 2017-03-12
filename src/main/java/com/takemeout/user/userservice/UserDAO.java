package com.takemeout.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.List;
import java.io.File;

import org.hibernate.Query;
import org.hibernate.Session;

import com.takemeout.util.SessionUtil;
import com.takemeout.user.exceptions.UserNameConflictException;
import com.takemeout.user.entities.User;
import com.takemeout.user.service.IUserDAO;
import com.takemeout.user.requests.RegisterUserRequest;


public class UserDAO implements IUserDAO {

  public static IUserDAO getIUserDao() {
    return new UserDAO();
  }

  public User getUser(String userName) {
    Session session = SessionUtil.getSessionFactory().openSession();
    session.beginTransaction();

    User user = null;
    Query query = session.createQuery("from User u where userName = :userName");
    user = (User)query.uniqueResult();
    session.flush();
    session.getTransaction().commit();
    session.close();
    return user;
  }

  public List<User> getUsers() {
    Session session = SessionUtil.getSessionFactory().openSession();
    session.beginTransaction();

    List<User> users = null;
    Query query = session.createQuery("from User");
    users = query.list();
    session.flush();
    session.getTransaction().commit();
    session.close();
    return users;
  }

  public void saveUser(RegisterUserRequest user) throws UserNameConflictException {
    List<User> users = getUsers();
    int maxId = 0;
    for (User u : users) {
      maxId = Math.max(maxId, u.getId());
      if (u.getUserName().equals(user.getUserName())) throw new UserNameConflictException();
    }

    Session session = SessionUtil.getSessionFactory().openSession();
    session.beginTransaction();

    User newUser = new User(user.getUserName(), user.getPasswordHash(), user.getEmail());

    session.save(newUser);

    session.flush();
    session.getTransaction().commit();
    session.close();
  }
}
