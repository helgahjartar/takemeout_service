package com.takemeout.user.entities;

import java.lang.IllegalArgumentException;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "User")
public class User {
  @Id @GeneratedValue
  @Column(name = "id", nullable = false)
  private int id;
  @Column(name = "userName", nullable = false)
  private String userName;
  @Column(name = "passwordHash", nullable = false)
  private String passwordHash;
  @Column(name = "email", nullable = false)
  private String email;

  public User(String userName, String passwordHash, String email) {
    this.userName = userName;
    this.passwordHash = passwordHash;
    this.email = email;
  }

  public User(){};

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getUserName() { return userName; }
  public void setUserName(String userName) { this.userName = userName; }

  public String getPasswordHash() { return passwordHash; }
  public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
}
