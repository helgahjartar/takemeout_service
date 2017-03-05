create view TypeProjection
( id
, name
, descriptionEng
, descriptionIsl
-- Columns from BaseType
, baseTypeId
, baseTypeName
, package )

as select
  t.id
, t.name
, t.descriptionEng
, t.descriptionIsl

, bt.id
, bt.name
, bt.package
from type t

join basetype bt on
  t.baseTypeId = bt.id;
