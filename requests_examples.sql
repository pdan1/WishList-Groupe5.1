/* This script show some examples of request on the desiderat-app database */

-------------------------------------------------------------------------------
-- COUNT
-------------------------------------------------------------------------------
-- Get the total number of user

SELECT SUM(1) FROM Users;

-- Get the number of friends of one user
SELECT SUM(1)
FROM Users usr, Friends frd
WHERE usr.name = 'Morgane Leclerc'
    and frd.status = 'approved'
    and (usr.userid = frd.userid1
        or usr.userid = frd.userid2)
;

-- See the number of wishes in a wishlist
SELECT SUM(1)
FROM Wishes wsh, Wishlists lst
WHERE wsh.list = 'Video Games'
    and wsh.userid = 'Juli1'
;

-------------------------------------------------------------------------------
-- FIND
-------------------------------------------------------------------------------

-- See an user's wishes across all lists
SELECT wsh.*
FROM Users usr, Wishes wsh
WHERE usr.userid = 'Frenchton' and usr.userid = wsh.userid
;

-- See an user's wishes in one list
SELECT wsh.*
FROM Users usr, Wishes wsh
WHERE usr.userid = 'Frenchton'
    and wsh.list = '2Watch'
    and usr.userid = wsh.userid
;

-- See The friends of one user
SELECT usr.*
FROM Friends frd, Users usr
WHERE frd.userid1 = 'Austry'
    and usr.userid = frd.userid2
UNION
SELECT usr.*
FROM Friends frd, Users usr
WHERE frd.userid2 = 'Austry'
    and usr.userid = frd.userid1
;

-------------------------------------------------------------------------------
-- CHECK
-------------------------------------------------------------------------------

-- Check if lists are non empty
SELECT
    lst.name,
    lst.userid,
    (SELECT MIN(1, COUNT(*))
        FROM Wishes wsh
        WHERE wsh.list = lst.name
            and wsh.userid = lst.userid)
    AS isNonEmpty
FROM Wishlists lst
;

-------------------------------------------------------------------------------
-- COMPUTE
-------------------------------------------------------------------------------

-- Compute the number of wishes for each users
SELECT DISTINCT
    wsh1.userid,
    (SELECT COUNT(*)
        FROM Wishes wsh2
        WHERE wsh1.userid = wsh2.userid)
    AS amountOfWishes
FROM Wishes wsh1
;

-- Compute the total price of each wishlist
SELECT DISTINCT
    wsh1.list,
    (SELECT SUM(wsh2.price*wsh2.amount)
        FROM Wishes wsh2
        WHERE wsh1.list = wsh2.list)
    AS total
FROM Wishes wsh1
;

-------------------------------------------------------------------------------
-- GET
-------------------------------------------------------------------------------

SELECT lst.name AS list, usr.name AS owner
FROM Users usr, Wishlists lst
WHERE lst.userid = usr.userid
;

-- Bonus

-- Get the wishes of an user, ordered by lists then wishrate
SELECT wsh.userid, wsh.name, wsh.list, wsh.wishrate
FROM Wishes wsh
--GROUP BY wsh.list
WHERE wsh.userid = 'Frenchton'
ORDER BY wsh.list DESC, wsh.wishrate DESC
;

-- Get the list of wishlists an user can edit
SELECT acs.list
FROM Accesses acs
WHERE acs.perm = 'edit'
    and acs.userid = 'Austry'
UNION
SELECT lst.name
FROM Wishlists lst
WHERE lst.userid = 'Austry'
;

-- NB: There is no notion of "categories" in our app, so the second request from the "compute" section of the TP4's statement could not be written as it do not really makes sens with our database
