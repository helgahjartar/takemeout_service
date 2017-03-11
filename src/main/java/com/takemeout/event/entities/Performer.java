package com.takemeout.event.entities;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import com.takemeout.user.entities.User;

@Entity
@Table(name = "Performer")
public class Performer {
  @Id @GeneratedValue
  @Column(name = "id", nullable = false)
  private int id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "descriptionEng", nullable = false)
  private String descriptionEng;
  @Column(name = "descriptionIce", nullable = false)
  private String descriptionIce;
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "userId")
  private User user;

  public Performer(String name, String descriptionEng, String descriptionIce, User user) {
    if (name == null || name.equals("")) throw new IllegalArgumentException("name can't be null or empty");
    if (descriptionEng == null || descriptionEng.equals("")) throw new IllegalArgumentException("English description can't be null or empty");
    if (descriptionIce == null || descriptionIce.equals("")) throw new IllegalArgumentException("Icelandic description can't be null or empty");
    if (user == null) throw new IllegalArgumentException("user can't be null");

    this.name = name;
    this.descriptionEng = descriptionEng;
    this.descriptionIce = descriptionIce;
    this.user = user;
  }
}
