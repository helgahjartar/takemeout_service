package com.takemeout.event.types.genres;

import com.takemeout.common.TypeItem;
import java.util.List;
import java.util.ArrayList;

public class MusicGenres {
  public static final TypeItem classical = new TypeItem(20001, "Klassík");
  public static final TypeItem jazz = new TypeItem(20002, "Jazz");
  public static final TypeItem funk = new TypeItem(20003, "Funk");
  public static final TypeItem soul = new TypeItem(20004, "Soul");
  public static final TypeItem dj  = new TypeItem(20005, "Dj");
  public static final TypeItem rap = new TypeItem(20006, "Rapp");
  public static final TypeItem hiphop  = new TypeItem(20007, "Hip Hop");
  public static final TypeItem pop = new TypeItem(20002, "Pop");
  public static final TypeItem electro  = new TypeItem(20002, "Electro");
  public static final TypeItem rock  = new TypeItem(20002, "Rokk");
  public static final TypeItem metal  = new TypeItem(20002, "Metal");
  public static final TypeItem alternative  = new TypeItem(20002, "Alternative");

  private static final List<TypeItem> genres = new ArrayList<TypeItem>();

  private MusicGenres() {
    genres.add(classical);
    genres.add(jazz);
    genres.add(funk);
    genres.add(soul);
    genres.add(dj);
    genres.add(rap);
    genres.add(hiphop);
    genres.add(pop);
    genres.add(electro);
    genres.add(rock);
    genres.add(metal);
    genres.add(alternative);
  }

  public static List<TypeItem> getGenres() {
    List<TypeItem> ret = new ArrayList<TypeItem>();
    for(TypeItem genre : genres) {
      ret.add(new TypeItem(genre.typeId, genre.description));
    }
    return ret;
  }
}
