package com.takemeout.user.authservice;

import com.takemeout.user.authservice.requests.*;
import com.takemeout.user.entities.User;
import java.util.List;

public interface IUserDAO {
  User getUser(String userName);
  void saveUser(RegisterUserRequest user);
}
