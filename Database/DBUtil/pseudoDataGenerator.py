import sqlite3
import random
import os

# Author: Isaiah Harville
# Function: Creates Pseudo Data to Populate the Hotel.db Database to demonstrate functionality of the program.

class DataGenerator:
    def __init__(self):
        path = os.path.dirname(__file__)
        self.DB = sqlite3.connect(os.path.abspath(os.path.join(os.path.dirname(__file__), os.pardir, "Hotel.db")))
        self.guestCount = 0
        self.firstNames = open("%s\\Data\\firstnames.txt"%path, "r").read().splitlines()
        self.lastNames = open("%s\\Data\\lastnames.txt"%path, "r").read().splitlines()
        self.emails = open("%s\\Data\\emails.txt"%path, "r").read().splitlines()
        self.phoneNumbers = open("%s\\Data\\phonenumbers.txt"%path, "r").read().splitlines()

        print("Opened Database\n\n")

        if input("Start (y/n) ").lower() == "y":
            self.generatePseudoHotels(generateRooms=True)
        else:
            self.DB.close()
            return


    def generatePseudoHotels(self, generateRooms=True):

        hotels = {
            "Hotel California" : "Los Angeles",
            "Hotel New Mexico" : "Albuquerque",
            "Hotel Tennessee" : "Nashville",
            "Hotel Florida" : "Miami",
            "Hotel Texas" : "Austin",
            "Hotel New York" : "New York City",
            "Hotel Washington" : "Seattle",
            "Hotel Virginia" : "Langley",
            "Hotel Alabama" : "Huntsville",
            "Hotel Tennessee" : "Nashville"
        }

        for hotelNum, i in enumerate(hotels):
            hotelNum += 1
            self.DB.execute(f"INSERT INTO Hotel VALUES ({hotelNum}, '{i}', '{hotels[i]}')")
            if generateRooms:
                self.generatePsuedoRooms(hotelNum)

        self.DB.commit()
        return


    def generatePsuedoRooms(self, hotelNum, generateGuests=True):
        for i in range(1, random.randint(85,150)):
            roomSize = random.choice([2,4,5])
            self.DB.execute(f"INSERT INTO Room VALUES ({i}, {hotelNum}, {roomSize}, {random.choice([True, False])}, {random.choice([True, False])}, {random.randint(80,100) if roomSize == 2 else random.randint(110, 300)})")
        
            if generateGuests:
                self.generatePsuedoGuests(roomSize)

        self.DB.commit()
        return


    def generatePsuedoGuests(self, roomSize):
        for i in range(roomSize):
            self.guestCount += 1
            self.DB.execute(f"INSERT INTO Guest VALUES ({self.guestCount}, '{random.choice(self.firstNames)}', '{random.choice(self.lastNames)}', '{random.choice(self.emails)}', '{random.choice(self.phoneNumbers)}')")
        
        self.DB.commit()


    def generatePseudoBookings(self):
        #TODO
        # guest number, hotel number, room number, checkin date, checkout date, 
        pass

DataGenerator()
