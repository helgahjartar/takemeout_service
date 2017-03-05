insert into basetype
  (id, name, package)
values
  (1002000, "PerformerType", "takemeout.event.types");

insert into type
  (id, baseTypeId, name, descriptionEng, descriptionIsl)
values
  (1002001, 1002000, "musician", "Musician", "Tónlistarmaður")
, (1002002, 1002000, "band", "Band", "Hljómsveit")
, (1002003, 1002000, "comedian", "Comedian", "Uppistandari")
, (1002004, 1002000, "visualArtist", "Visual Artist", "Myndlistarmaður")
, (1002005, 1002000, "dancer", "Dancer", "Dansari")
, (1002006, 1002000, "actor", "Actor", "Leikari");
