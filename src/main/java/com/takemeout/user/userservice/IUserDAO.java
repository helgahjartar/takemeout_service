package com.takemeout.user.service;

import com.takemeout.user.requests.RegisterUserRequest;
import com.takemeout.user.entities.User;
import com.takemeout.user.exceptions.UserNameConflictException;

import java.util.List;


public interface IUserDAO {
  User getUser(String userName);
  List<User> getUsers();
  void saveUser(RegisterUserRequest user) throws UserNameConflictException;
}
