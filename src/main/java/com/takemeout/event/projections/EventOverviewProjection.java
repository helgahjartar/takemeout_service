package com.takemeout.event.projections;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.Immutable;
import java.sql.Date;

@Entity
@Immutable
public class EventOverviewProjection {
  @Id @GeneratedValue
	@Column(nullable = false) private int id;
  @Column(nullable = false) private String name;
  @Column(nullable = false) private Date time;
  @Column(nullable = false) private int typeId;
  @Column(nullable = false) private String typeDescriptionEng;
  @Column(nullable = false) private String typeDescriptionIce;
  @Column(nullable = false) private String locationName;
  @Column(nullable = false) private String address;
  @Column(nullable = false) private String access;

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public Date getTime() { return time; }
  public void setTime(Date time) { this.time = time; }

  public int getTypeId() { return typeId; }
  public void setTypeId(int typeId) { this.typeId = typeId; }

  public String getTypeDescriptionEng() { return typeDescriptionEng; }
  public void setTypeDescriptionEng(String typeDescriptionEng) { this.typeDescriptionEng = typeDescriptionEng; }

  public String getTypeDescriptionIce() { return typeDescriptionIce; }
  public void setTypeDescriptionIce(String typeDescriptionIce) { this.typeDescriptionIce = typeDescriptionIce; }

  public String getLocationName() { return locationName; }
  public void setLocationName(String locationName) { this.locationName = locationName; }

  public String getAddress() { return address; }
  public void setAddress(String address) { this.address = address; }

  public String getAccess() {return access; }
  public void setAccess(String access) { this.access = access; }
}
