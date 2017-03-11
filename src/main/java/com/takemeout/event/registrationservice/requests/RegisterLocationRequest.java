package com.takemeout.event.registrationservice.requests;

public class RegisterLocationRequest {
  private String name;
  private String address;
  private String access;

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getAddress() { return address; }
  public void setAddress(String address) { this.address = address; }

  public String getAccess() { return access; }
  public void setAccess(String access) { this.access = access; }
}
