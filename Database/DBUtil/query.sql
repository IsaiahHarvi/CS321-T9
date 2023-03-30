--Query program to test SqliteJDBC.java

/*
SELECT *
FROM Room
JOIN Hotel
ON Room.hotel_No = Hotel.hotel_No

SELECT room_No, size, price, name, city
FROM Room
JOIN Hotel
ON Room.hotel_No = Hotel.hotel_No 
WHERE Hotel.city = 'Denver';
*/

SELECT * 
FROM Guest
WHERE Guest.first_name = 'John' AND Guest.last_name = 'Doe'