-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)  -- filsm are in film table. actor in actor table. 2 tables. No direct link between them
               --film actor table does link them. Need 3 tables. 
Select title 
from film
     inner join 
     film_actor 
   on film.film_id = film_actor.film_id
     inner join
    actor  
   on film_actor.actor_id = actor.actor_id
where actor.first_name = 'NICK' and actor.last_name = 'STALLONE' 
   ;
 

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
 
 Select title
from actor 
 inner join 
     film_actor 
   on actor.actor_id = film_actor.actor_id
     inner join
     film 
   on film.film_id = film_actor.film_id
where first_name = 'RITA' 
   and last_name = 'REYNOLDS' 
   ;


-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
Select title
from actor 
 inner join 
     film_actor 
   on actor.actor_id = film_actor.actor_id
     inner join
     film 
   on film.film_id = film_actor.film_id
where first_name = 'JUDY'
   and last_name = 'DEAN' 
   OR 
      first_name = 'RIVER'
   and last_name = 'DEAN'
   ;
-- 4. All of the the ‘Documentary’ films
-- (68 rows)
Select title
from category
    inner join 
    film_category
   on category.category_id = film_category.category_id
    inner join
    film 
   on film.film_id = film_category.film_id
 where name = 'Documentary'
 ;
    
-- 5. All of the ‘Comedy’ films
-- (58 rows)
Select title
from category
    inner join 
    film_category
   on category.category_id = film_category.category_id
    inner join
    film 
   on film.film_id = film_category.film_id
 where name = 'Comedy'
 ;

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
Select title
from category
    inner join 
    film_category
   on category.category_id = film_category.category_id
    inner join
    film 
   on film.film_id = film_category.film_id
 where name = 'Children Films'
         and film.rating = 'G'
 ;

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
Select title
from category
    inner join 
    film_category
   on category.category_id = film_category.category_id
    inner join
    film 
   on film.film_id = film_category.film_id
 where name = 'Family'
         and film.rating = 'G'
         and film.length < '120'
 ;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
Select title
from actor 
 inner join 
     film_actor 
   on actor.actor_id = film_actor.actor_id
     inner join
     film 
   on film.film_id = film_actor.film_id
where first_name = 'MATTHEW' 
   and last_name = 'LEIGH' 
   and film.rating = 'G'
   ;

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
Select title
from category
    inner join 
    film_category
   on category.category_id = film_category.category_id
    inner join
    film 
   on film.film_id = film_category.film_id
 where name = 'Sci-fi'
        and film.release_year = 2006
 ;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
Select title
from film
    inner join 
    film_category
   on film.film_id = film_category.film_id
    join
    category 
   on category.category_id = film_category.category_id
    join 
     film_actor 
   on film.film_id = film_actor.film_id
   join
   actor
   on film_actor.actor_id = actor.actor_id
 where category.name = 'Action' and actor.first_name = 'NICK' and actor.last_name = 'STALLONE'
   ;

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
Select store, address, city, district, country
From country
     inner join 
     city
     On country.country_id = city.country_id
     inner join
     address
     on city.city_id = address.city_id
     inner join
     store
     on address.address_id = store.store_id
     ; 

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
Select store_id, address, first_name, last_name
from staff
     inner join 
     address
     on staff.address_id = address.address_id 
     ;

-- 13. The first and last name of the top ten customers ranked by number of rentals
-- (#1 should be “ELEANOR HUNT�? with 46 rentals, #10 should have 39 rentals)
Select first_name, last_name, COUNT(*)
From rental
     inner join
     customer
     on rental.customer_id = customer.customer_id
     Group BY customer.customer_id
     Order By count desc
     Limit 10
;

-- 14. The first and last name of the top ten customers ranked by dollars spent
-- (#1 should be “KARL SEAL�? with 221.55 spent, #10 should be “ANA BRADLEY�? with 174.66 spent)
Select first_name, last_name, SUM(amount)
From payment
     inner join
     customer
     on payment.customer_id = customer.customer_id
     Group BY customer.customer_id
     Order By sum(amount) desc
     Limit 10
;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that while a customer has only one primary store, they may rent from either store.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
Select store.store_id, address.address, Count(store.store_id), sum(payment.amount), avg(payment.amount)
from store
     inner join
     address
     on store.address_id = address.address_id
     join
     inventory
     on store.store_id = inventory.store_id
      join 
     rental 
     on inventory.inventory_id = rental.inventory_id
     join
     payment
     on rental.rental_id = payment.rental_id
     group by store.store_id, address.address_id
     ;

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD�? with 34 rentals and #10 should have 31 rentals)
Select title, COUNT(*)
From  rental
      inner join
      inventory 
      on rental.inventory_id = inventory.inventory_id 
      inner join
      film
      on inventory.film_id = film.film_id
      group by film.title
      order by count desc
      limit 10 

-- 17. The top five film categories by number of rentals
-- (#1 should be “Sports�? with 1179 rentals and #5 should be “Family�? with 1096 rentals)
Select title, COUNT(*)
From  category
      inner join
      film_category 
      on category.category_id = film_category.id
      join film
  
      on inventory.film_id = film.film_id
      group by film.categories
      order by count desc
      limit 5



-- 18. The top five Action film titles by number of rentals
-- (#1 should have 30 rentals and #5 should have 28 rentals)
Select title, COUNT(rental_id)
From  rental
      inner join
      inventory
      on rental.inventory_id = inventory.inventory_id
      inner join
      film
      on inventory.film_id = film.film_id
      inner join
      category
      on film_category.category_id = category.category_id
   Where name = 'Action'
   Group by title 
   order by COUNT desc
   limit 5
   ;


-- 19. The top 10 actors ranked by number of rentals of films starring that actor
-- (#1 should be “GINA DEGENERES�? with 753 rentals and #10 should be “SEAN GUINESS�? with 599 rentals)

Select first_name, last_name, COUNT(rental_id)
From actor 
     inner join 
     film_actor
   on actor.actor_id = film_actor.actor_id 
   order by 1 desc
   limit 10;
     -- group by unique vslues. Puts Susan Davis's together. 

-- 20. The top 5 “Comedy�? actors ranked by number of rentals of films in the “Comedy�? category starring that actor
-- (#1 should have 87 rentals and #5 should have 72 rentals)
Select first_name, last_name, count(*)
from actor
      inner join
      film_actor 
      on actor.actor_id = film_actor.actor_id
      join
      film
      on film_actor.film_id = film.film_id
      join 
      film_categoy
      on film.film_id = inventory.film_id
      join
      rental
      on inventory.inventory_id = rental.inventory_id
      




