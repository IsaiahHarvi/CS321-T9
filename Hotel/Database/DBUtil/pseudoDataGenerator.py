import sqlite3
import random
import os

# Author: Isaiah Harville
# Function: Creates Pseudo Data to Populate the Hotel.db Database to demonstrate functionality of the program.
# Note: This is slow, it generates ~100,000 < x < ~1,500,000 guests who each have a booking and belong to a room which belongs to a hotel.  
#       It is only used to populate the databse, not for production.


class DataGenerator:
    def __init__(self):
        path = os.path.dirname(__file__)
        self.DB = sqlite3.connect(os.path.abspath(os.path.join(os.path.dirname(__file__), os.pardir, "Hotel.db")))

        # Init Variables
        self.guestNum = 0
        self.roomSize = 0
        self.hotelNum = 0
        self.roomAmount = 0

        # Data Files
        self.hotels = open("%s\\Data\\hotels.txt"%path, "r").read().splitlines()
        self.firstNames = open("%s\\Data\\firstnames.txt"%path, "r").read().splitlines()
        self.lastNames = open("%s\\Data\\lastnames.txt"%path, "r").read().splitlines()
        self.emails = open("%s\\Data\\emails.txt"%path, "r").read().splitlines()
        self.phoneNumbers = open("%s\\Data\\phonenumbers.txt"%path, "r").read().splitlines()

        # Input Options
        task = {
            "1" : self.createTables,
            "2": self.generatePseudoHotels, # there is a line of succession
            "3" : self.end                  # data, it would not exist.  so to start we call hotels.  
        }                                    

        self.menu() # print the menu

        while True:
            task[self.validInput(input("> "))]() # get the input call function
            print("\n")
        

    # Menu
    def menu(self):
        print("   Data Generator")
        print("1. Create Tables")
        print("2. Generate Data")
        print("3. Exit\n")


    # Input Validation
    def validInput(self, string, parameters=["1","2","3"]):
        inp = string.lower()
        while 1:
            if inp in parameters:
                return inp
            inp = str(input(str))


    # Exit
    def end(self):
        print("\n\n\n\nClosing...")
        self.DB.close()
        exit()


    # Create Tables
    def createTables(self):
        print("Creating Tables...")
        self.DB.execute(
        """
            CREATE TABLE Hotel
            (
                hotel_No INT PRIMARY KEY,
                name VARCHAR(50),
                city VARCHAR(50)
            );
        """
        )

        self.DB.execute(
        """
            CREATE TABLE Room
            (
                room_No INT,
                hotel_No INT,
                size INT,
                smoking BOOLEAN,
                pet BOOLEAN,
                price INT,
                PRIMARY KEY (room_No, hotel_No),
                FOREIGN KEY (hotel_No) REFERENCES Hotel(hotel_No)
            );
        """
        )

        self.DB.execute(
        """
            CREATE TABLE Guest
            (
                first_name VARCHAR(50),
                last_name VARCHAR(50),
                email VARCHAR(50),
                phone VARCHAR(50)
            );
        """
        )

        self.DB.execute(
        """
            CREATE TABLE Booking
            (
                guest_No INT,
                hotel_No INT,
                room_No INT,
                check_in_date STRING,
                check_out_date STRING,
                --PRIMARY KEY (hotel_No, room_No, check_in_date),
                FOREIGN KEY (guest_No) REFERENCES Guest(guest_No),
                FOREIGN KEY (hotel_No) REFERENCES Hotel(hotel_No),
                FOREIGN KEY (room_No) REFERENCES Room(room_No)
            );
        """
        )
        print("Done.")
        self.DB.commit()
        return


    # Generate Pseudo Hotels from hotels.txt
    def generatePseudoHotels(self):
        print("Creating Hotels...", end="")
        for i in range(0, len(self.hotels), 2):
            self.hotelNum += 1
            self.DB.execute(f"INSERT INTO Hotel VALUES ({self.hotelNum}, '{self.hotels[i]}', '{self.hotels[i+1]}')")
            self.generatePsuedoRooms()

        
        self.DB.commit()
        return


    # Generate 1000-5000 Pseudo Rooms per hotel with random room attributes, called by generatePseudoHotels
    def generatePsuedoRooms(self):
        print(f"\n\nCreating Rooms for Hotel {self.hotelNum}...")
        self.roomAmount = random.choice([1000, 2000, 3000])
        for i in range(1, self.roomAmount):
            self.roomSize = random.choice([2,3,4,5])
            self.roomNumber = i
            self.DB.execute(f"INSERT INTO Room VALUES ({self.roomNumber}, {self.hotelNum}, {self.roomSize}, {random.choice([True, False])}, {random.choice([True, False])}, {random.randint(80,100) if self.roomSize == 2 else random.randint(110, 300)})")
            
            self.generatePsuedoGuests()

        print(f"Done. Created {self.roomAmount} Rooms for Hotel {self.hotelNum}.")
        self.DB.commit()
        return


    # Generate Psuedo Guests per room size and a booking for each guest, called by generatePseudoRooms
    def generatePsuedoGuests(self):
        if self.roomNumber % 1000 == 0:
            print(f"Creating Guests and Bookings for Room {self.roomNumber}...")


        # Guests phone number is the ID
        year = 2023
        month = random.randint(1,12)
        day = random.randint(1,30)

        checkInDate = ('%s-%s-%s'%(year, month, day))

        checkOutDay = day + random.randint(1,7)
        if checkOutDay > 30:
            month += 1
            checkOutDay -= 30
        
        if month > 12:
            month = 1
            year += 1

        checkOutDate = ('%s-%s-%s}'%(year, month, checkOutDay))


        phoneNumber = random.choice(self.phoneNumbers)


        self.guestNum += 1
        self.DB.execute(f"INSERT INTO Guest VALUES ('{random.choice(self.firstNames)}', '{random.choice(self.lastNames)}', '{random.choice(self.emails)}', '{phoneNumber}')")
        self.DB.execute(f"INSERT INTO Booking VALUES ('{phoneNumber}', {int(self.hotelNum)}, {int(self.roomNumber)}, '{str(checkInDate)}', '{str(checkOutDate)}')")



        self.DB.commit()
        return


DataGenerator()
