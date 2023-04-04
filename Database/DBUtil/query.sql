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


SELECT * 
FROM Guest
WHERE Guest.first_name = 'Casey' AND Guest.last_name = 'Bramlett'
*/

SELECT * 
FROM Room
WHERE Room.hotel_No = 1 AND Room.room_No = 1 AND Room.size = 1 
AND Room.price < 1000 AND Room.price > 0  AND Room.pet = 1 AND Room.smoking = 0