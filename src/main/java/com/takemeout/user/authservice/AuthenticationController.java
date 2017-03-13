package com.takemeout.user.authservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.takemeout.user.authservice.requests.*;
import com.takemeout.user.entities.User;
import com.takemeout.user.exceptions.UserNameConflictException;
import com.takemeout.jwt.JwtUtil;

@RestController
public class AuthenticationController {

  private IUserDAO userHandler;
  private JwtUtil jwtHandler;

  @Autowired
  public AuthenticationController (@Qualifier("UserDAO") IUserDAO userDao,
                                   @Qualifier("JwtUtil") JwtUtil jwtUtil) {
    userHandler = userDao;
    jwtHandler = jwtUtil;
  }

  @CrossOrigin
  @RequestMapping(value = "user/login", method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"})
  public String login(@RequestBody LoginRequest req, HttpServletResponse res) {
      try {
        User user = userHandler.getUser(req.getUserName());
        if (user == null || !user.getPasswordHash().equals(req.getPasswordHash())) {
          res.setStatus(HttpServletResponse.SC_UNAUTHORIZED, "Username and password combination does not exist");
          return null;
        }
        return jwtHandler.generateToken(user);
      } catch(Exception e) {
        res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR , "The request could not be completed be");
        return null;
      }
  }

  @CrossOrigin
  @RequestMapping(value = "user/register", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerUser(@RequestBody RegisterUserRequest user, HttpServletResponse res) {
    try {
      userHandler.saveUser(user);
    } catch(UserNameConflictException e) {
      res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR , e.getMessage());
    } catch(Exception e) {
      res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR , "The request could not be completed");
    }
  }
}
