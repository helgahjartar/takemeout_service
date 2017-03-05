CREATE TABLE user (
  id             int           not null auto_increment
, userName       varchar(256)  not null
, passwordHash   varchar(256)  not null
, email          varchar(256)  not null
, constraint pk_user_id primary key(id)
);

alter table user
  add constraint uk_user_userName unique key(userName)
, add constraint uk_user_email unique key(email);
