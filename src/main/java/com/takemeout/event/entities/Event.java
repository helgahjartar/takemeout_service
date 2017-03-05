package com.takemeout.event.entities;

import java.lang.IllegalArgumentException;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "EVENT")
public class Event {
  @Id @GeneratedValue
  @Column(name = "id", nullable = false)
  private int id;
  @Column(name = "userId", nullable = false)
  private int userId;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "time", nullable = false)
  private String time;
  @Column(name = "clock", nullable = false)
  private String clock;
  @Column(name = "type", nullable = false)
  private String type;
  @Column(name = "description", nullable = false)
  private String description;
  @Column(name = "access", nullable = false)
  private String access;
  @Column(name = "location", nullable = false)
  private String location;

  // todo: Refactor, stop using time and clock and find proper class to store time
  // todo: Stop using strings everywhere and define classes to wrap info

  public Event(int userId, String name, String time, String clock, String type, String description, String access, String location) {
    if (userId <= 0) throw new IllegalArgumentException("userId must be higher than 0");
    if (name == null || name.equals("")) throw new IllegalArgumentException("name can't be null or empty");
    if (time == null || time.equals("")) throw new IllegalArgumentException("time can't be null or empty");
    if (clock == null || clock.equals("")) throw new IllegalArgumentException("clock can't be null or empty");
    if (type == null || type.equals("")) throw new IllegalArgumentException("type can't be null or empty");
    if (description == null || description.equals("")) throw new IllegalArgumentException("description can't be null or empty");
    if (access == null || access.equals("")) throw new IllegalArgumentException("access can't be null or empty");
    if (location == null || location.equals("")) throw new IllegalArgumentException("location can't be null or empty");

    this.userId = userId;
    this.name = name;
    this.time = time;
    this.clock = clock;
    this.type = type;
    this.description = description;
    this.access = access;
    this.location = location;
  }

  public int getId() { return id; }
  public int getUserId() { return userId; }
  public String getName() { return name; }
  public String getTime() { return time; }
  public String getClock() { return clock; }
  public String getType() { return type; }
  public String getDescription() { return description; }
  public String getAccess() { return access; }
  public String getLocation() { return location; }
}
