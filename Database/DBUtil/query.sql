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