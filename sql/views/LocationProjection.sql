create view LocationProjection
( id
, name
, address
, access )

as select
  l.id
, l.name
, l.address
, l.access
from Location l;
