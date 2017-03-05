package com.takemeout.event.types;

import com.takemeout.common.TypeItem;

public class AccessType {
  public static final TypeItem ramp  = new TypeItem(10001, "Rampur");
  public static final TypeItem elevator  = new TypeItem(10002, "Lyfta");
  public static final TypeItem badAccess  = new TypeItem(10003, "Slæmt aðgengi");
  public static final TypeItem goodAccess = new TypeItem(10004, "Gott aðgengi");

  private AccessType() { }
}
