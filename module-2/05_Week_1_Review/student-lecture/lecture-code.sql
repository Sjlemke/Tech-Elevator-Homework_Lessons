---------------------------------------------------------------------------------------------------------------------------------------
-- Referential Integrity - Enforcement of the Parent-Dependent relatiohnship
--                         ie. Ensure that every foreign key value has a matching primary key
--
-- Constraints are rules regarding the data that must be complied with when INSERTing and UPDATing:
--
--  NOT NULL - Column must have a value
--
--  UNIQUE   - Column value must be unique with the table 
--
--  PRIMARY KEY - Column is part of the unique identifier for a row in the table
--                UNIQUE and NOT NULL are implied
--
--  FOREIGN KEY - Column is part of a foreign key for the table.  
--                Value must have a matching value in the primary key of the parent table
--                Establishes the parent-dependent relationship
--
--  CHECK  -  Specifies acceptable values for a column - any simple WHERE predicate is allowed
--
--  DEFAULT - Specify a default value for column if no value is supplied on INSER
---------------------------------------------------------------------------------------------------------------------------------------
-- Unit Of Work (UOW) - A recoverable sequence of operations within an application process
--                      all steps to have a completed piece of work have been completed
-- 
-- BEGIN TRANSACTION - Mark the start of a unit of work
-- 
-- COMMIT - End a unit of work and save changes - automatically done if no errors
-- 
-- ROLLBACK - End a unit of work and undo changes - automatically done if errors
---------------------------------------------------------------------------------------------------------------------------------------
--  INSERT - add a row to a table
--
--  Format 1: INSERT INTO table-name 
--            (column-list)           -- must contain all non-null columns
--            VALUES(value-list)      -- order of values must match order of columns specified
--
--
--  Format 2: INSERT INTO table-name 
--            VALUES(value-list)      -- order of values must match order of columns as defined in the table
--
--
--  Format 3: INSERT INTO table-name 
--            (SELECT statement)      -- order of columns in the SELECT must match the order of columns as defined in the table
--                                    -- () are optional
--                                            
---------------------------------------------------------------------------------------------------------------------------------------
--  UPDATE - change data in a table
--
--  UPDATE table-name
--  SET column = new-value
--  WHERE condition            -- scope of update - if omitted, all rows are updated                                         
---------------------------------------------------------------------------------------------------------------------------------------
--  DELETE - Remove rows from a table
--
--  DELETE FROM table-name
--  WHERE condition            -- scope of delete - if omitted, all rows are deleted                                        
---------------------------------------------------------------------------------------------------------------------------------------
-- INSERT

-- 1. Add Klingon as a spoken language in the USA


Begin transaction;  -- start a unit of work - in case something goes wrong, we undo/rollback and start over

-- The safest (fewer opportunty for errors) format, is to include the column-list in the INSERT

insert into countrylanguage                     -- add a row to the country language table
(countrycode, language, isofficial, percentage) -- list of columns we are providing values for - all non-null columns  
values('USA', 'Klingon', true, 16)              -- values for the columns in the order of list above
;

--insert into countrylanguage                     -- add a row to the country language table
--(isofficial, countrycode, percentage, language) -- list of columns we are providing values for - all non-null columns  
--values(true, 'USA', 16, 'Klingon')               -- values for the columns in the order of list above--
--;

--insert into countrylanguage             -- add a row to the country language table
--values('USA', 'Klingon', true, 16)      -- values for the columns in the order of definition for the table
;
-- optionally - we do a select to make sure insert worked
-- since we are doing  a tollback we cannot look at the table after we run to see if the insert work
select * from countrylanguage where countrycode = 'USA';

Rollback;  -- undo any changes in this unit of work until we are sure they were done correctly

-- 2. Add Klingon as a spoken language in Great Britain

begin transaction;
insert into countrylanguage                     -- add a row to the country language table
(countrycode, language, isofficial, percentage) -- list of columns we are providing values for - all non-null columns  
values('GBR', 'Klingon', true, 36)              -- values for the columns in the order of list above
;
select * from countrylanguage where language = 'Klingon';

rollback;

-- UPDATE

-- 1. Update the capital of the USA to Houston
begin transaction;

update country
   set capital = (select id from city where name = 'Houston')  -- look up the id for Houston in the city table abd use to set capital
 where code = 'USA'   -- limit the update to just rows with the countrycode USA
;

select * from country where code = 'USA'
;

rollback;

-- 2. Update the capital of the USA to Washington DC and the head of state
begin transaction;

update country
   set capital = (Select id from city where name = 'Washington'),   -- code a comma when there is another column to update
       headofstate = 'Luke'                                         -- just code column-name = new-vale -- do not repeat SET
  where code = 'USA'
;
select * from country where capital =  (Select id from city where name = 'Washington')
;
rollback;

-- DELETE

-- 1. Delete English as a spoken language in the USA
begin transaction;
delete from countrylanguage
 where countrycode = (select code from country where name = 'United States')
   and language = 'English'
;
select * from countrylanguage where countrycode = (select code from country where name = 'United States');

rollback;

-- 2. Delete all occurrences of the Klingon language 
begin transaction; 
delete from countrylanguage where language = 'Klingon';
rollback;

-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.
begin transaction; 
insert into countrylanguage        -- add a row to the country language table
(countrycode, language, isofficial, percentage) -- list of coullumns we are providing values for - all non null
values(???, 'Elvish', ???, ??)      --values for the columns in the order 
 select * from countrylanguage where language = 'Elvish'
 ;

rollback;

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
       -- countrylanguage is a dependent of country table
       --(its a foreign key must match a primary key value that already exists in the country table)
       -- countrycode value in countrlanguage must match an existing code value in country
       --when we try to insert a language for country code that is not in the country table 
        -- we get a foreign key violation error. 
  --this insert will fail bc zzz is not an existing primary key value in country table
                     -- besure any value you specify as a foregin key valye has a match in parent
                      -- either look at the data in the parent table or insert paretn rows before dependent rows
 Begin transaction; 
  insert into countrylanguage
  values('ZZZ', 'English', false, 10)   -- values for the columns in the order of list above
  ;
  select * from countrylanguage where language = 'English';
  rollback; 

-- 3. Try deleting the country USA. What happens?
begin transaction; 
delete from country where code = 'USA';
rollback;
--country table has two dependents, countrylanguage and city
--when deleting a row from a parent table, it may be restricted so that the row may only be deleted if it has no dependent rows.
--in other words, no foreighn key matches to it.  
-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
  --this fails because a unique violation 
begin transaction; 
insert into countrylanguage  --add a row to the country language table
(countrycode, language, isofficial, percentage)  --list of all collumns we are providing values for - all non null collumns
values('USA', 'English', false, 90)
;
rollback; 
-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'

  -- this update will fail due to outer space not being an allowable continent value 
  --theres a check constraint on continent that limits the values
begin transaction; 
update country
    set continent = 'Outer Space'
    where code = 'USA' 
    ;
rollback; 
  --constraints are stored in database tables - postgres tables 
  
-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS
--must delete all depend rows before parent if delete of parent rows is restricted by referencial integrity.

-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

-- 2. Try updating all of the cities to be in the USA and roll it back
