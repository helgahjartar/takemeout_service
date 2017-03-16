package com.takemeout.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.jsonwebtoken.JwtException;
import com.takemeout.user.exceptions.AuthenticationFailedException;

@ControllerAdvice
public class ExceptionHandlerAdvice{

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<?> defaultHandleException(Exception e) {
    System.out.println(e);
    e.printStackTrace();
    return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("Couldn't complete the requests because of the following error\n"
                    +e.getMessage());
  }

  @ExceptionHandler(value = JwtException.class)
  public ResponseEntity<?> handleJwtException(JwtException e) {
    System.out.println(e);
    e.printStackTrace();
    return ResponseEntity
              .status(HttpStatus.UNAUTHORIZED)
              .body("Access token is invalid\n"+e.getMessage());
  }

  @ExceptionHandler(value = AuthenticationFailedException.class)
  public ResponseEntity<?> handleJwtException(AuthenticationFailedException e) {
    System.out.println(e);
    e.printStackTrace();
    return ResponseEntity
              .status(HttpStatus.UNAUTHORIZED)
              .body(e.getMessage());
  }
}
