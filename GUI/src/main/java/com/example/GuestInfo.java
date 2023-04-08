package com.example;
// comment
public class GuestInfo {
    private String name;
    private int guestNum;
    private int cardNum;
    private String email;
    private String phoneNum;
    private int roomNum;

    public GuestInfo(){
        this.name = "";
        this.guestNum = 0;
        this.cardNum = 0;
        this.email = "";
        this.phoneNum = "";
        this.roomNum = 0;
    }

    public GuestInfo(String name, int guestNum, int cardNum, String email, String phoneNum, int roomNum){
        this.name = name;
        this.guestNum = guestNum;
        this.cardNum = cardNum;
        this.email = email;
        this.phoneNum = phoneNum;
        this.roomNum = roomNum;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setGuestNum(int num){
        this.guestNum = num;
    }
    public int getGuestNum(){
        return this.guestNum;
    }    
    public void setCardNum(int cardNum){
        this.cardNum = cardNum;
    }
    public int getCardNum(){
        return this.cardNum;
    }    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }    
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    public String getPhoneNum(){
        return this.phoneNum;
    }
    public void setRoomNum(int roomNum){
        this.roomNum = roomNum;
    }
    public int getRoomNum(){
        return this.roomNum;
    }
}