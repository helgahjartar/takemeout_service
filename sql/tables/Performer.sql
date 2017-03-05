CREATE TABLE performer (
  id                int           not null auto_increment
, name              varchar(256)  not null
, description       text          not null
, performerTypeId   int           not null
, constraint pk_performer_id primary key(id)
);

alter table performer
  add constraint fk_performer_performerTypeId foreign key(performerTypeId) references type(id);
