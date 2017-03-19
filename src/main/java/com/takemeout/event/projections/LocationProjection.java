package com.takemeout.event.projections;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class LocationProjection {
  @Id @GeneratedValue
  @Column(nullable = false) private int id;
  @Column(nullable = false) private String name;
  @Column(nullable = false) private String address;
  @Column(nullable = false) private String access;

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getAddress() { return address; }
  public void setAddress(String address) { this.address = address; }

  public String getAccess() {return access; }
  public void setAccess(String access) { this.access = access; }
}
