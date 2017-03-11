package com.takemeout.common;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "TypeItem")
public class TypeItem {
  @Id @GeneratedValue
  @Column(name = "id", nullable = false)
  public final int id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "descriptionEng", nullable = false)
  private String descriptionEng;
  @Column(name = "descriptionIce", nullable = false)
  private String descriptionIce;

  public TypeItem(int id, String name, String descriptionEng, String descriptionIce) {
    this.id = id;
    this.name = name;
    this.descriptionEng = descriptionEng;
    this.descriptionIce = descriptionIce;
  }
}
