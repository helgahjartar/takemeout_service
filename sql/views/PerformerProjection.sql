create view PerformerProjection
( id
, name
, descriptionEng
, descriptionIce )

as select
  p.id
, p.name
, p.descriptionEng
, p.descriptionIce
from Performer p;
