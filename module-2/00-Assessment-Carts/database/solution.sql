-- Select all the columns in cart where the username is kmilner1j

SELECT *
FROM cart
WHERE username = 'kmilner1j'
;

-- Select the id and name columns from items where the item was added on or after Jan. 15, 2019 and the weight is null
SELECT id, name
FROM items
WHERE item added > 2019-01-15
      and weight IS NULL
;

-- Select username and the cookie_value from carts where the username isn't null, ordered by the created date, latest first
SELECT username, cookie_value
FROM carts
WHERE username is not null
      and ordered by created date desc
 ;   


-- Select the added date and the count of all the items added on that date
SELECT date_added, COUNT(*)
FROM items
WHERE date_added
;

-- Select the cart's username and created date and the item's name for all carts created in the month of Sept. 2019
SELECT carts_username, date_created, items_name
FROM *
WHERE carts created between 2019-09-01 and 2019-09-30
;