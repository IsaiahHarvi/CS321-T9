package com.example;

import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class RoomSearch {
    private String city;
    private int minPrice;
    private int maxPrice;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numBeds;
    private int numBathroom;
    private boolean pets;
    private boolean smoking;


    public RoomSearch() {
    }
    public RoomSearch(String city, int minPrice, int maxPrice, LocalDate checkIn, LocalDate checkOut, int numBeds, int numBathroom, boolean pets, boolean smoking) {
        this.city = city;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numBeds = numBeds;
        this.numBathroom = numBathroom;
        this.pets = pets;
        this.smoking = smoking;
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

    public int getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }

    public int getNumBathroom() {
        return numBathroom;
    }

    public void setNumBathroom(int numBathroom) {
        this.numBathroom = numBathroom;
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
