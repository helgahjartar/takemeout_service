CREATE TABLE event (
  id            int           not null auto_increment
, name          varchar(256)  not null
, description   text          not null
, userId        int           not null
, performerId   int               null
, locationId    int           not null
, time          datetime      not null
, eventTypeId   int           not null
, constraint pk_event_id primary key(id)
);

alter table event
  add constraint fk_event_userId foreign key(userId) references user(id)
, add constraint fk_event_performerId foreign key(performerId) references performer(id)
, add constraint fk_event_locationId foreign key(locationId) references location(id);
