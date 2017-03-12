create view EventDetailProjection
( id
, name
, descriptionEng
, descriptionIce
, time
-- joined columns
, typeDescriptionEng
, typeDescriptionIce
, locationName
, address
, access )

as select
  e.id
, e.name
, e.descriptionEng
, e.descriptionIce
, e.time

, t.descriptionEng
, t.descriptionIce
, l.name
, l.address
, l.access
from Event e

join TypeItem t on
  t.id = e.typeId

join Location l on
  l.id = e.locationId;
