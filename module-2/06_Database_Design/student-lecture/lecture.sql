---------------------------------------------------------------------------------------------------------------
--
-- DROP - remove a table and all it's data from the database
--
-- Consider referential constraints - cannot drop a parent if it has dependents
--
--      DROP TABLE table-name             - Will fail if table does not exist or if it has dependents
--
--      DROP TABLE IF EXISTS table-name   - Will run whether table exists or not; will fail if table has dependents
--
--      DROP TABLE IF EXISTS table-name  CASCADE   - Will run whether table exists or not and whether has dependents or not
--
--
--  CREATE - define a table to the database manager
--
--       CREATE TABLE table-name
--       (column-name     datßa-type    NOT NULL,
--        column-name     data-type,
--        column-name     data-type    DEFAULT   default-value,
--        column-name     data-type    UNIQUE,
--        CONSTRAINT constraint-name PRIMARY KEY (column(s)-in-table),
--        CONSTRAINT constraint-name FOREIGN KEY(for-key-column(s)) REFERENCES parent-table(pri-key-column(s)),
--        CONSTRAINT consraint-name  CHECK (where-predicate)
--       )
--
--       Note: CONTRAINT is part of the set of column definitions (i.e. inside the parens for column specification)
--
-- 
-- ALTER - changing the definition of a table
--
-- Commonly used to add/remove constraints on tables or change existing table attributes
--
--
-- Add a FOREIGN KEY - Establish Parent/Dependant relationship
--
-- FOREIGN KEY must have the same-number, same-order, compatible-data-type as entire PRIMARY KEY of parent
--             and must have a matching value in the PRIMARY KEY in the parent table
--
-- When adding FOREIGN KEY after data has been loaded into table, all FOREIGN KEY values must have a match in parent
--
--      ALTER TABLE dependent-table-name ADD FOREIGN KEY(for-key-column(s)) REFERENCES parent-table(pri-key-column(s)) 
--
-- Remove a constraint from a table
--
--      ALTER TABLE table-name DROP CONSTRAINT constraint_name
--
--
-- Add a column to an existing table
--
-- Cannot add a NOT NULL column to a table with existing data
--
--      ALTER TABLE table-name ADD COLUMN new_column_name data_type constraint
--
--
-- Rename an existing column in a table
--
--      ALTER TABLE table-name RENAME column-name TO new-column-name;
--
--
-- Rename a table
--
--      ALTER TABLE table-name RENAME TO new-table-name  - Will fail if table does not exist
--
--      ALTER TABLE IF EXISTS table-name RENAME TO new-table-name  - Successful if table exists or not
drop table if exsits artist;
drop table if exists paintings;
drop table if exists customer;
drop table if exists purchase;
---------------------------------------------------------------------------------------------------------------
--creating a table - artist table 
create table artist
(
artist_id serial Not Null
,artist_name character(50) Not Null 
            --constraint name    type      columns
,constraint pk_artist_artist_id Primary key(artist_id)
)
;

-- paintings table 
create table paintings
(
painting_id  serial 
,artist_id    integer not null --int is used bc artist_id in artist is a serial value
,painting_title character varying(100)
,constraint pk_paintings_paintings_id primary key(painting_id)
,constraint fk_artist_artist_id foreign key(artist_id) references artist(artist_id)
)
;

create table customer
(
customer_id serial 
,customername character varying(40)
,customeraddress character varying(100)
,customercity character varying(25)
,customerstate character(2)
,customeraddress character varying(10)
,customerphone character varying(12) 
,constraint customer_constraint primary key (customer_id)
)
;

create table purchase
(
purchaseod serial 
,customer integer not null
,paintingid integer not null
,purchasedate date not null 
,purchaseprice numeric(12,2)  --max value is 10 digits with no decimal places(1000000000)
constraint pk_purchase_purchaseid primary key(purchaseid)
)
;