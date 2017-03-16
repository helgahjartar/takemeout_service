package com.takemeout.user.entities;

import java.lang.IllegalArgumentException;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
public class User {
  @Id @GeneratedValue
  @Column(nullable = false) private int id;
  @Column(nullable = false, unique = true) private String userName;
  @Column(nullable = false) private String passwordHash;
  @Column(nullable = false) private String email;

  private User() {}

  public User(String userName, String passwordHash, String email) {
    this.userName = userName;
    this.passwordHash = passwordHash;
    this.email = email;
  }

  public int getId() { return id; }
  public String getUserName() { return userName; }
  public String getPasswordHash() { return passwordHash; }
  public String getEmail() { return email; }
}
