package com.takemeout.user.projections;

public class UserProjection {
  private int id;
  private String userName;
  private String passwordHash;
  private String email;

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getUserName() { return userName; }
  public void setUserName(String userName) { this.userName = userName; }

  public String getPasswordHash() { return passwordHash; }
  public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
}
