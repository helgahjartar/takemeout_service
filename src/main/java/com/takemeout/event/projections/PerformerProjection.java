package com.takemeout.event.projections;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class PerformerProjection {
  @Id @GeneratedValue
  @Column(nullable = false) private int id;
  @Column(nullable = false) private String name;
  @Column(nullable = false) private String descriptionEng;
  @Column(nullable = false) private String descriptionIce;

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getDescriptionEng() { return descriptionEng; }
  public void setDescriptionEng(String descriptionEng) { this.descriptionEng = descriptionEng; }

  public String getDescriptionIce() { return descriptionIce; }
  public void setDescriptionIce(String descriptionIce) { this.descriptionIce = descriptionIce; }
}
