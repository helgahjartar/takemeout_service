package com.takemeout.event.entities;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.lang.IllegalArgumentException;
import java.sql.Date;
import java.util.List;

import com.takemeout.user.entities.User;
import com.takemeout.common.TypeItem;

@Entity
@Table(name = "Event")
public class Event {
  @Id @GeneratedValue
  @Column(name = "id", nullable = false)
  private int id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "descriptionEng", nullable = false)
  private String descriptionEng;
  @Column(name = "descriptionIce", nullable = false)
  private String descriptionIce;
  @Column(name = "time", nullable = false)
  private Date time;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "userId")
  private User user;
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "typeId")
  private TypeItem type;
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "locationId")
  private Location location;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable( name = "EventPerformerLink"
            , joinColumns = { @JoinColumn(name = "eventId") }
            , inverseJoinColumns = { @JoinColumn(name = "performerId") })
  private List<Performer> performers;

  // todo: Refactor, stop using time and clock and find proper class to store time
  // todo: Stop using strings everywhere and define classes to wrap info

  public Event( String name, String descriptionEng, String descriptionIce, Date time
              , User user, TypeItem type, Location location, List<Performer> performers) {

    if (name == null || name.equals("")) throw new IllegalArgumentException("name can't be null or empty");
    if (descriptionEng == null || descriptionEng.equals("")) throw new IllegalArgumentException("English description can't be null or empty");
    if (descriptionIce == null || descriptionIce.equals("")) throw new IllegalArgumentException("Icelandic description can't be null or empty");
    if (time == null) throw new IllegalArgumentException("time can't be null");

    if (user == null) throw new IllegalArgumentException("user can't be null");
    if (type == null) throw new IllegalArgumentException("type can't be null");
    if (location == null) throw new IllegalArgumentException("location can't be null");
    if (performers == null || performers.isEmpty()) throw new IllegalArgumentException("performers can't be null or empty");

    this.name = name;
    this.descriptionEng = descriptionEng;
    this.descriptionIce = descriptionIce;
    this.time = time;

    this.user = user;
    this.type = type;
    this.location = location;
    this.performers = performers;
  }

  public int getId() { return id; }
  public String getName() { return name; }
  public String getDescriptionEng() { return descriptionEng; }
  public String getDescriptionIce() { return descriptionIce; }
  public Date getTime() { return time; }

  public User getUser() { return user; }
  public TypeItem getType() { return type; }
  public Location getLocation() { return location; }
  public List<Performer> getPerformers() { return performers; }
}
