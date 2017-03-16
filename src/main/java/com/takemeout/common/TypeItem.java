package com.takemeout.common;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
public class TypeItem {
  @Id @GeneratedValue
  @Column(nullable = false) private int id;
  @Column(nullable = false) private String name;
  @Column(nullable = false) private String descriptionEng;
  @Column(nullable = false) private String descriptionIce;

  private TypeItem() {}

  public TypeItem(int id, String name, String descriptionEng, String descriptionIce) {
    this.id = id;
    this.name = name;
    this.descriptionEng = descriptionEng;
    this.descriptionIce = descriptionIce;
  }

  public int getId() { return id; }
  public String getName() { return name; }
  public String getDescriptionEng() { return descriptionEng; }
  public String getDescriptionIce() { return descriptionIce; }
}
