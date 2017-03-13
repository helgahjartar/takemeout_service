package com.takemeout.user.authservice;

import com.takemeout.user.authservice.requests.*;
import com.takemeout.user.entities.User;
import com.takemeout.user.exceptions.UserNameConflictException;
import java.util.List;

public interface IUserDAO {
  User getUser(String userName);
  List<User> getUsers();
  void saveUser(RegisterUserRequest user) throws Exception;
}
