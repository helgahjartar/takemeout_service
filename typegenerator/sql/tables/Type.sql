CREATE TABLE type (
  id              int           not null
, baseTypeId      int           not null
, name            varchar(256)  not null
, descriptionEng text          not null
, descriptionIsl text          not null
, constraint pk_type_id primary key(id)
);

alter table type
  add constraint fk_type_basetypeId foreign key(baseTypeId) references basetype(id);
