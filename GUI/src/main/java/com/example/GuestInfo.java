package com.example;
// comment
public class GuestInfo {
    private string name;
    private int guestNum;
    private int cardNum;
    private string email;
    private string phoneNum;
    private int roomNum;

    public GuestInfo(string name, int guestNum, int cardNum, string email, string phoneNum, int roomNum){
        this.name = name;
        this.guestNum = guestNum;
        this.cardNum = cardNum;
        this.email = email;
        this.phoneNum = phoneNum;
        this.roomNum = roomNum;
    }

    public void setName(string name){
        this.name = name;
    }
    public string getName(){
        return this.name;
    }
    public void setGuestNum(string num){
        this.guestNum = num;
    }
    public string getGuestNum(){
        return this.guestNum;
    }    
    public void setCardNum(string cardNum){
        this.cardNum = cardNum;
    }
    public string getCardNum(){
        return this.cardNum;
    }    
    public void setEmail(string email){
        this.email = email;
    }
    public string getEmail(){
        return this.email;
    }    
    public void setPhoneNum(string phoneNum){
        this.phoneNum = phoneNum;
    }
    public string getPhoneNum(){
        return this.phoneNum;
    }
    public void setRoomNum(int roomNum){
        this.roomNum = roomNum;
    }
    public int getRoomNum(){
        return this.roomNum;
    }

    GuestInfo(){
        GuestName = "Neo Matrix";
        GuestNum = 00000001;
        GuestCardNum = 12345678;
        GuestEmail = "iamtheone@gmail.com";
        GuestPhoneNum = 0000000001;
    }
}