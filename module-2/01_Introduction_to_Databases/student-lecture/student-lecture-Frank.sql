--------------------------------------------------------------------------------------------------------
-- Basic SELECT Lecture Code
--------------------------------------------------------------------------------------------------------
-- -- indicates a comment - anything following on the line is ignored
--
-- SQL SELECT statement - retrieve values form the database (Read)
--
-- A SELECT statement is often referred to as a query
--
-- Basic syntax: (the order in which these are specified is important) select is always first, it is what you want to see in the result
        -- need a select statement and a from statement. 
--
--      SELECT   - columns to include in the result (seperate mutiple column reqeusts with commas)
--      FROM     - table containing rows used in the query 
--      WHERE    - rows to include in the result
--      ORDER BY - sequence of rows in the result
--                 without an ORDER BY the sequence of the rows in the result is not predictable
--                 if the sequence of teh rows in teh result matter - code an ORDER BY
--   
-- WHERE predicates:
--
--        =  <>  !=  >  >=  <  <= 
--        IN(list-of-values)      -- alterative to a series of = OR
--        NOT IN(list-of-values)  -- alterative to a series of != AND
--        BETWEEN value AND value
--        IS NULL
--        IS NOT NULL
--        LIKE    (use wildcards: % means 0 to any number of any characters
--                                _ means exactly any one character
--        ILIKE   (case insensivtive LIKE - Postgres extension)
--
-- predicates may be combined using AND and OR
--
-- use parentheses to make your multi-predicate condition clear

-- The DISTINCT clause on a SELECT removes duplicate values from the result
-- based on the all columns that follow
--
-- The DISTINCT ON(columns/expression) clause on a SELECT removes duplicate values from the result
-- based on the all columns/expression inside the parentheses that follow (Postgres extension)
------------------------------------------------------------------------------------------------------

-- Selecting the names for all countries -- they want to SEE the names of the countries. Column name.
Select name  -- list the collumns you want to see in the result on the select. 
from country 
;  -- specify the table with the collumns you want. want the name from country collum. 


-- Selecting the name and population of all countries
Select name, population -- list collumn you want to see in result 
From country  -- specify the table with the collumbs
;

-- Selecting all columns from the city table
--Select population, name --the order of the collumns in the select will be in order of the collumbs in the result
--From country
--; 
*   -- this means ALL Collumns
from country
;
-- SELECT ... FROM ... WHERE  -- where means rows. where predicate is simmilar to java predicates (conditions)
-- = <> != > >= < <+ -not equal can be specified two ways: <> !=


-- Selecting the cities in Ohio
Select name, district  -- district is the name of the column in city table for what we call a state in usa
from city
where district = 'Ohio' -- put single quotes around strings. Case matters in this case
;


-- Selecting countries that gained independence in the year 1776
Select name 
from country
where indepyear = 1776 -- numberic values are not coded in signle quotes
;
-- Selecting countries not in Asia
Select name, continent 
from county
where continent <> 'Asia' -- <> means not equals. so does !=
;

-- Selecting countries that do not have an independence year

select name, indepyear 
from country 
where indepyear is null  --represents an unknown or missing value so equals and not eqals doesnt work. 
;

-- Selecting countries that do have an independence year
select name, indepyear 
from country
where indepyear is not null 
;

-- Selecting countries that have a population greater than 5 million
select name, population
from country
where population >= 500000
;


-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000
select name, district 
from  city 
where district = 'Ohio'
and population > 40000
;


-- Selecting country names on the continent North America or South America

select name, continent 
from country
where continent = 'North American' -- equals sign can also be IN. it can mean equals Ors. 
or continent = 'South America'
;      -- can also be where contient IN ('North America' , 'South America')
       -- can also write LIKE instead of IN with %America ..% means starts with.or contains Same goes with ends with at end of word.
    
-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
select name, population, lifeespectancy, population / surface area
from country 
;

select name, population as How_Many_People_Live_There
           , lifeexpectency as How_Long_They_Usually_Live
           , population / surface as pop_per_area
from county
; 


--Countries that gained indep in the 20th century. 
Select name, indepyear
from county
where indepyear >= 1900 
and indepyear is <=1999
; 
-- alternative way to do this
where indepyear is between 1900 and 1999 -- between predicate helps with range


