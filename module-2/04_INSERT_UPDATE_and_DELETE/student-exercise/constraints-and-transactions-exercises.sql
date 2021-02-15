-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

Begin transaction;
-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

insert into actor
(first_name, last_name)
values('Hampton', 'Avenue'),('Lisa', 'Byway')
;
select * from actor where last_name in ('Avenue', 'Byway')
;
   
 Select * from actor where actor_id > 200
 ;
 
 
-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.

-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
    -- english is 1 
insert into film
(title, description, release_year, language_id, length)
values('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198)
;
select * from film where title = 'Euclidean PI'
;

   

 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

insert into film_actor(actor_id, film_id)
values ((select actor_id from actor where first_name = 'Hampton' and last_name = 'Avenue'), (select film_id from film where title = 'Euclidean PI'))
;
insert into film_actor(actor_id, film_id)
values ((select actor_id from actor where first_name = 'Lisa' and last_name = 'Byway'), (select film_id from film where title = 'Euclidean PI'))
;
select * from film_actor
;

-- 4. Add Mathmagical to the category table.
insert into category
(name)
values('Mathmagical')
;
select * from category
;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
insert into film_category(film_id, category_id)
values ((select film_id from film where title = 'Euclidean PI'), (select category_id from category where name = 'Mathmagical'))
;
insert into film_category(film_id, category_id)
values ((select film_id from film where title = 'EGG IGBY'), (select category_id from category where name = 'Mathmagical'))
;
insert into film_category(film_id, category_id)
values ((select film_id from film where title = 'KARATE MOON'), (select category_id from category where name = 'Mathmagical'))
;
insert into film_category(film_id, category_id)
values ((select film_id from film where title = 'RANDOM GO'), (select category_id from category where name = 'Mathmagical'))
;
insert into film_category(film_id, category_id)
values ((select film_id from film where title = 'YOUNG LANGUAGE'), (select category_id from category where name = 'Mathmagical'))
;
select * from film join film_category on film_category.film_id = film.film_id join category on category.category_id = film_category.category_id where category.name = 'Mathmagical'
;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

update film set rating = 'G'
where film_id in (select film_id from film_category where category_id = (select category_id from category where name = 'Mathmagical'))
;
select * from film join film_category on film_category.film_id = film.film_id join category on category.category_id = film_category.category_id where category.name = 'Mathmagical'
;

-- 7. Add a copy of "Euclidean PI" to all the stores.

insert into inventory(film_id, store_id)
values((select film_id from film where title = 'Euclidean PI'), 1);
insert into inventory(film_id, store_id)
values((select film_id from film where title = 'Euclidean PI'), 2);
select * from inventory join film on film.film_id = inventory.film_id where title = 'Euclidean PI'
;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
--- no because it exists on another table/ foreign key

delete from film where title = 'Euclidean PI'
;      
-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
--- no because it exists on another table/ foreign key
 
 delete from category where name = 'Mathmagical'
 ;
 
-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- yes b/c it is a primiary key?  not a foreign?

delete from film_category
where film_category.category_id = (select category.category_id from category where category.name = 'Mathmagical')
;

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- deleting Mathmagical worked due to number 10 answer
-- deleting Euclidean PI failed b/c it is not on the primary key
 
delete from category where name = 'Mathmagical'
;
delete from film where title = 'Euclidean PI'
;
-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.


rollback;


  -- undo all changes so we can run this again 
          -- change to commit when we are abolutely sure we wont run this again
           -- doing a commit saves all the changes and we cannot readd some of hte data 
           --due to unique constraints caused by primary keys or we will insert duplicate data which not good!