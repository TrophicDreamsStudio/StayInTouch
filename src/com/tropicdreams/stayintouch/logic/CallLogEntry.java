package com.tropicdreams.stayintouch.logic;


import java.util.Date;



public class CallLogEntry {
	private  String PhoneNumber;
	private Date CallDate;
	
	public String getPhone(){
		return PhoneNumber;
	}
	
	public Date getCallDate(){
		return CallDate;
	}
	
	public void setCallDate(Date calldate){
		
		CallDate = calldate;
	}
	
	public void setPhone(String phone){
		PhoneNumber = phone;
	}
	
	public CallLogEntry(String phone,Date calldate){
		PhoneNumber = phone;
		CallDate = calldate;
	}
	
	@Override 
	public String toString() {
		
		return String.format("Phone number : %s | Call date: %s", this.PhoneNumber, this.CallDate);
	}
}
