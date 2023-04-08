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


--GET ROOMS WIHTOUT CONFLICTING BOOKINGS
SELECT hotel_No, room_No FROM Room WHERE (hotel_No, room_No) NOT IN (SELECT hotel_No, room_No FROM Booking WHERE check_in_date <= ? AND check_out_date > ?)


--GET ROOMS WITH SMOKING
SELECT * FROM Room
WHERE smoking = 1;


--GET ROOMS WITH PETS
SELECT * FROM Room
WHERE pets = 1;
*/



