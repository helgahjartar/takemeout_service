insert into basetype
  (id, name, package)
values
  (1001000, "EventType", "takemeout.event.types");

insert into type
  (id, baseTypeId, name, descriptionEng, descriptionIsl)
values
  (1001001, 1001000, "music", "Music", "Tónlist")
, (1001002, 1001000, "standUp", "Stand Up", "Uppistand")
, (1001003, 1001000, "visualArt", "Visual Art", "Myndlist")
, (1001004, 1001000, "dance", "Dance", "Dans")
, (1001005, 1001000, "theatre", "Theatre", "Leiklist");
