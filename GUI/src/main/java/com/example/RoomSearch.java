package com.example;

import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class RoomSearch {
    private String city;
    private int minPrice;
    private int maxPrice;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private int size;


    private boolean pets;
    private boolean smoking;


    public RoomSearch() {
    }
    public RoomSearch(String city, int minPrice, int maxPrice, LocalDate checkIn, LocalDate checkOut, int size, boolean pets, boolean smoking) {
        this.city = city;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.size = size;

        this.pets = pets;
        this.smoking = smoking;
    }

    public String toString(){
        /*return city;
        return Integer.toString(minPrice);
        return Integer.toString(maxPrice);
        return checkIn.toString();
        return checkOut.toString();
        return Integer.toString(numBeds);
        return Integer.toString(numBathroom);
        return Boolean.toString(pets);
        return Boolean.toString(smoking);*/
        return "City: " + city + " \nMin Price: " + minPrice + " \nMax Price: " + maxPrice + " \nCheck In: " + checkIn + " \nCheck Out: " + checkOut + " \nRoom Size:  "+ size+ " \nPets: " + pets + " \nSmoking: " + smoking;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getMinPrice() {
        return minPrice;
    }
    
    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }       

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    
}
