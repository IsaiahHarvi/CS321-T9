--Query program to test SqliteJDBC.java
/*

--SELECT SPECIFIC GUEST BASED ON NAME
SELECT * 
FROM Guest
WHERE Guest.first_name = 'John' AND Guest.last_name = 'Doe'


--REMOVE GUEST AND BOOKING BY FIRST AND LAST NAME
DELETE FROM Booking
WHERE guest_No IN (
    SELECT guest_No FROM Guest
    WHERE first_name = 'John' AND last_name = 'Doe'
);

DELETE FROM Guest
WHERE first_name = 'John' AND last_name = 'Doe';


--GET LAST GUEST ADDED NUMBER
SELECT MAX(guest_No) as largestGuestNumber FROM Guest

*/
