package com.takemeout.event.registration.requests;

public class CreatePerformerRequest {
  private String name;
  private String descriptionEng;
  private String descriptionIce;

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getDescriptionEng() { return descriptionEng; }
  public void setDescriptionEng(String descriptionEng) { this.descriptionEng = descriptionEng; }

  public String getDescriptionIce() { return descriptionIce; }
  public void setDescriptionIce(String descriptionIce) { this.descriptionIce = descriptionIce; }
}
