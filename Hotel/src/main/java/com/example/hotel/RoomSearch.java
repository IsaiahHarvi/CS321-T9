/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.hotel;

import javafx.scene.control.DatePicker;
import java.sql.Date;


/**
 * This is the class that take in the room filters / parameters. This object with be parsed through to get its variables.
 * There are getter and setter methods for each of variables below 
 * 
 * @author caseybramlett
 */
public class RoomSearch {
    private String city;
    private int minPrice;
    private int maxPrice;
    private Date checkIn;
    private Date checkOut;

    private int size;


    private boolean pets;
    private boolean smoking;


    public RoomSearch() {
    }
    public RoomSearch(String city, int minPrice, int maxPrice, Date checkIn, Date checkOut, int size, boolean pets, boolean smoking) {
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

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
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
