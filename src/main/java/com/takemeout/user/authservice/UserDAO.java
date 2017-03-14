package com.takemeout.user.authservice;

import org.springframework.stereotype.Component;
import com.takemeout.user.authservice.requests.*;
import com.takemeout.user.entities.User;
import com.takemeout.common.BaseDAO;
import java.util.List;

@Component(value = "UserDAO")
public class UserDAO extends BaseDAO implements IUserDAO {

  public User getUser(String userName) {
    return executeR(session -> {
      return session.createQuery("from User u where userName = :userName", User.class).uniqueResult();
    });
  }

  public void saveUser(RegisterUserRequest user) {
    execute(session -> {
      User newUser = new User(user.getUserName(), user.getPasswordHash(), user.getEmail());
      session.save(newUser);
    });
  }
}
