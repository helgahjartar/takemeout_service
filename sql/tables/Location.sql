CREATE TABLE location (
  id            int           not null auto_increment
, name          varchar(256)  not null
, address       varchar(256)  not null
, accessTypeId  int           not null
, constraint pk_location_id primary key(id)
);
