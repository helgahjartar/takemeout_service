package com.takemeout.event.entities;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import com.takemeout.user.entities.User;

@Entity
public class Location {
  @Id @GeneratedValue
  @Column(nullable = false) private int id;
  @Column(nullable = false) private String name;
  @Column(nullable = false) private String address;
  @Column(nullable = false) private String access;
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "userId")
  private User user;

  public Location(String name, String address, String access, User user) {
    if (name == null || name.equals("")) throw new IllegalArgumentException("name can't be null or empty");
    if (address == null || address.equals("")) throw new IllegalArgumentException("address can't be null or empty");
    if (access == null || access.equals("")) throw new IllegalArgumentException("access can't be null or empty");
    if (user == null) throw new IllegalArgumentException("user can't be null");

    this.name = name;
    this.address = address;
    this.access = access;
    this.user = user;
  }

  public int getId() { return id; }
  public String getName() { return name; }
  public String getAddress() { return address; }
  public String getAccess() {return access; }
  public User getUser() { return user; }
}
