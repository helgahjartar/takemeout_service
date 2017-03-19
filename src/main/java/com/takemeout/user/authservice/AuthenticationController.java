package com.takemeout.user.authservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import com.takemeout.user.exceptions.AuthenticationFailedException;
import com.takemeout.user.entities.User;
import com.takemeout.user.authservice.requests.*;
import com.takemeout.jwt.JwtUtil;
import java.util.List;

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
  @RequestMapping(value = "user/auth/login", method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"})
  public String login(@RequestBody LoginRequest req) throws AuthenticationFailedException {
    System.out.println("\nusername: "+req.getUserName()+"\npasswordhash: "+req.getPasswordHash()+"\n");
    User user = userHandler.getUser(req.getUserName());
    System.out.println("Actual username: "+user.getUserName()+"\nActual passwordhash: "+user.getPasswordHash()+"\n");
    if (user == null || !user.getPasswordHash().equals(req.getPasswordHash()))
      throw new AuthenticationFailedException();
    return jwtHandler.generateToken(user);
  }

  @CrossOrigin
  @RequestMapping(value = "user/auth/register", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerUser(@RequestBody RegisterUserRequest user) {
    userHandler.saveUser(user);
  }
}
