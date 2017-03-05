# Script must be run from the same directory as it is in because it uses
# relative paths. If you wish to run the script from anywhere you must set
# the absolute paths of all the sql files that are called below.

drop database if exists takemeout_db;
create database takemeout_db;

use takemeout_db;

-- Create and insert types
source tables/BaseType.sql;
source tables/Type.sql;

source types/InsertEventTypes.sql;
source types/InsertPerformerTypes.sql;

-- Create tables
--source tables/User.sql;
source tables/Performer.sql;
source tables/Location.sql;
--source tables/Event.sql;

-- Create views
source views/TypeProjection.sql;
