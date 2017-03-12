package com.takemeout.common;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
public class TypeItem {
  @Id @GeneratedValue
  @Column(nullable = false) public final int id;
  @Column(nullable = false) public final String name;
  @Column(nullable = false) public final String descriptionEng;
  @Column(nullable = false) public final String descriptionIce;

  public TypeItem(int id, String name, String descriptionEng, String descriptionIce) {
    this.id = id;
    this.name = name;
    this.descriptionEng = descriptionEng;
    this.descriptionIce = descriptionIce;
  }
}
