--
-- Show any actors we have in the actor table who are not in any films
-- in the film table (ie. no entry in the film_actor table)

--
-- 1. Add some test data to the actor table we know are do not
--    have matches in the film table;

Begin transaction;
insert into actor (first_name, last_name) values('Anne', 'Joel');
insert into actor (first_name, last_name) values('Daniel', 'Louis');
insert into actor (first_name, last_name) values('Brianna', 'Hema');
insert into actor (first_name, last_name) values('Aidan', 'Patrick');
insert into actor (first_name, last_name) values('David', 'Connor');
insert into actor (first_name, last_name) values('Sam', 'Michael');
insert into actor (first_name, last_name) values('Luke', 'Sammi');
insert into actor (first_name, last_name) values('Jeff', 'Eric');
insert into actor (first_name, last_name) values('D. Avery', 'Danny');
insert into actor (first_name, last_name) values('Jason', 'Frank');

--
--  2a. Problem solved with sub-query
--

select actor_id, count(*)
from actor
where actor_id not in (Select actor_id from film_actor) 
group by actor_id
;

--
-- Problem solved with left-join actor table to file_actor table
--

select a.actor_id, a.first_name, a.last_name
from actor a
left join
film_actor fa
on a.actor_id = fa.actor_id
where fa.actor_id is null
;
--
-- 3. Reset table to original state before test data inserted
--
rollback;