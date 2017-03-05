# Script must be run from the same directory as it is in because it uses
# relative paths. If you wish to run the script from anywhere you must set
# the absolute paths of all the sql files that are called below.

-- Set up database, types, tables and views.
source ./CreateDbScript.sql;

-- Insert test data
source testData/InsertUsers.sql;
source testData/InsertPerformers.sql;
source testData/InsertLocations.sql;
source testData/InsertEvents.sql;
