--------------------------------------------------------------------------------------------------------
-- Ordering, Grouping Basic Functions Lecture Code
--------------------------------------------------------------------------------------------------------
--
-- ORDER BY -  Sequence of Rows in Result
--
--    ORDER BY          -- Ascending Sequence (low-high)
--    ORDER BY ASC      -- Ascending Sequence (low-high)
--    ORDER BY DESC     -- Descending Sequence (high-low)

-- Show Populations of all countries in acscending order
-- There is no guarantee of the order of the rows in a result without an Order By 
-- in standard SQL the order by is always last. Except when 


Select name, population
   from country   -- without an order by, the rows and the result are in whatever order the database manager gives.
 order by population -- if order is important code an order by. 
 ;                    -- you can also write asc after population in the order by if you want. desc is required thought if needed    

-- Show Populations of all countries in descending order
Select name, population
  from country
 order by population desc
 ;

-- Show  the n ames of countries and continents in ascending order
Select names, continent 
    from country 
order by name, continent desc, name   -- to order by multiple columns, code column names seperated by , in the sequence you want 
; 
Select name, continent 
    from country
 order by continent desc, name desc
 ;

--------------------------------------------------------------------------------------------------------
-- Limiting the number of rows in the result
--
-- LIMIT n   - Limit the number of rows in the result - always goes at thE end of the SELECT
-- limit is postgreSQL extension to standard SQL (ANSI - american national standard Institute. ISO - international standards Org.
-- other  data base managers limit rows, but call it something othr than LIMIT
-- and have you code it somewhere else in the Select
-- Order By is always last unless there is a limit?
--
-- Show the name and average life expectancy of the countries with the 10 highest life expectancies.
Select name, lifeexpectancy 
from country
where lifeexpectancy is not null
order by lifeexpectancy desc  -- want to see highest lifeexpentancies first. highest to lowest. 
limit 10  -- only return the first 10 rows in result. 
;        -- need to code not nulls. put not null in the Where. 

--------------------------------------------------------------------------------------------------------
-- Concatenating string/ values values 
--
-- the concat operator (||) may be used to concatenate character (string) values in a result
--
--
-- Show the name & state in the format: "city-name, state"
-- of all cities in California, Oregon, or Washington.
-- sorted by state then city
Select name, || ',' || district -- concatenate a ',' between the values 
from city
where district = 'California'   --limit rows
     or district = 'Oregon'     -- the entire predicate must be coded when using OR/AND (column relational value)
     or district = 'Washington'
-- OR YOUR CAN DO THIS>  where district In('California', 'Oregon', 'Washington')




--------------------------------------------------------------------------------------------------------
-- Aggregate functions - produce one row in result for each group specified
 -- rather than one row in the result for each row that matches the where clause. 
--
-- The group used by the aggregate functions is determined by the GROUP BY clause
-- if no GROUP BY clause is specified, the group is the set of rows in the result
--
--     AVG(column-expression)   - arithmentic average for group of non-NULL values in expression 
--     SUM(column-expression)   - arithmentic sum for group of a non-NULL values in expression 
--     MIN(column-expression)   - lowest value for group of non-NULL values in expression 
--     MAX(column-expression)   - highest value for group of non-NULL values in expression 
--     COUNT(*)                 - number of rows in the group
--     COUNT(column-expression) - number of rows for the group of non-NULL values in expression 
--
--
-- AVG(), SUM() may only bes used with numeric data types
-- MIN(), MAX() may be used with numeric, character, date, time datatypes
--
-- COUNT() is applied to rows (not columns)
--
--
-- Show average life expectancy in the world
Select avg(lifeexpectancy)  -- we get one row with average across all countries
from country 
;
-- now try each continent 
Select avg(lifeexpectancy) as Avg_Life_Expectancy -- made our own AS, will use this next week.
from country
group by continent -- specifiy the groups we want for the aggregate function
                   -- when Group By the only columns allowed on the Slect are aggregate functions and colums listed in group by. 
;
-- Show the total population in Ohio
Select sum(population) as Total_People_in_Ohio -- collum description
from city 
where district = 'Ohio'
;

-- Show the surface area of the smallest country in the world
Select name, surfacearea
from country 
order by surfacearea
limit 1 
;   --could also have done> Select min(surfacearea) from country;
    -- could add in group by name at bottom and select name, min(surfacearea) order by min(surfacearea) limit 1;



-- Show The 10 largest countries (by surface area) in the world
Select name, surfacearea
limit 10; 



-- Show the number of countries who declared independence in 1991 -- number of = count. It returns # of rows
Select count(*) as Number_Countries_Indepyear_1991
from country 
where indepyear = 1991
;
-- we want to see the country names. We cant add a group By because each country only has one Ind year.


--------------------------------------------------------------------------------------------------------
-- GROUP BY  - Specify the group to which the aggregate functions apply
--
--      GROUP BY column-expression
--
-- When using a GROUP BY the SELECT is limited ot aggreggate functions or columns in the GROUP BY
--
--

-- Show the number of countries where each language is spoken, order show them from most countries to least
-- when you see number of you know its a Count(*)
-- when you see each whatever - group by whatver 
Select count(*) 
from countrylanguage 
group by language 
order by 2 desc-- or order by Count(*) desc

-- Show the average life expectancy of each continent ordered from highest to lowest
Select continent, avg(lifeexpectancy)
from country 
where  lifeexpectancy is not null -- if you dont want antartica 
group by continent 
order by 2 desc  -- colum 2 order by descending order
;


-- Exclude Antarctica from consideration for average life expectancy



-- What is the sum of the population of cities in each state in the USA ordered by state name
Select district, sum(population) as population
from city 
where countrycode = 'USA'
group by district -- each means group by
order by district
;


-- What is the average population of cities in each state in the USA ordered by state name
Select district, avg(population) as avg_population
from city 
where countrycode = 'USA'
group by district -- each means group by
order by district
;

--------------------------------------------------------------------------------------------------------
-- SUBQUERIES - Using the result from one query (inner query) in another query (outer query)
--
-- Frequently used in a WHERE clause with an IN predicate:
--
--       WHERE column-name IN (SELECT column-name FROM some-table WHERE some-predicate)
--
-- Any WHERE predicate may be used to connect the subquery in a WHERE clause, but you must
-- be sure a single value is returned from the subquery. 
--
-- Subqueries may also be used in a SELECT as a column-specification or a FROM as a table
-- (These are advanced concepts we will discuss later, if there is time)
--
-- Show the cities under the same given government leader


-- Show countries with the same independece year


-- Show the cities cities whose country has not yet declared independence yet


--------------------------------------------------------------------------------------------------------
--
-- Additional samples
--
-- You may alias column and table names to provide more descriptive names
--
SELECT name AS CityName 
  FROM city AS cities

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
SELECT name
     , population 
  FROM city 
 WHERE countryCode='USA' 
 ORDER BY name ASC, population DESC
;
-- Limiting results allows rows to be returned in 'limited' clusters where LIMIT says how many, 
-- and an optional OFFSET specifies number of rows to skip
SELECT name
     , population 
  FROM city 
  LIMIT 10 OFFSET 10
;