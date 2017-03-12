package com.takemeout.user.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.takemeout.user.requests.LoginRequest;
import com.takemeout.user.requests.RegisterUserRequest;
import com.takemeout.user.service.UserDAO;
import com.takemeout.user.entities.User;
import com.takemeout.user.exceptions.UserNameConflictException;
import com.takemeout.jwt.JwtUtil;

@RestController
public class AuthenticationController {

  IUserDAO userHandler = null;

  public AuthenticationController () {
    userHandler = UserDAO.getIUserDao();
  }


  @CrossOrigin
  @RequestMapping(value = "user/login", method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"})
  public String login(@RequestBody LoginRequest req, HttpServletResponse res) {
      try {
        User user = userHandler.getUser(req.getUserName());
        if (user == null || !user.getPasswordHash().equals(req.getPasswordHash())) {
          res.setStatus(res.SC_UNAUTHORIZED, "Username and password combination does not exist");
          return null;
        }
        return JwtUtil.generateToken(user);
      } catch(Exception e) {
        res.setStatus(res.SC_INTERNAL_SERVER_ERROR , "The request could not be completed be");
        return null;
      }
  }

  @CrossOrigin
  @RequestMapping(value = "user/register", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerUser(@RequestBody RegisterUserRequest user, HttpServletResponse res) {
    try {
      userHandler.saveUser(user);
    } catch(UserNameConflictException e) {
      res.setStatus(res.SC_INTERNAL_SERVER_ERROR , e.getMessage());
    } catch(Exception e) {
      res.setStatus(res.SC_INTERNAL_SERVER_ERROR , "The request could not be completed");
    }
  }
}
