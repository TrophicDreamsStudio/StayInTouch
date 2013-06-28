package com.tropicdreams.stayintouch.logic;


import java.util.Date;



public class CallEntry {
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
	
	public CallEntry(String phone,Date calldate){
		PhoneNumber = phone;
		CallDate = calldate;
	}
	
	//an alternative constructor for assigning just the Phone number
	public CallEntry(String phone){
		PhoneNumber = phone;
	}
	
	@Override 
	public String toString() {
		
		return String.format("Phone number : %s | Call date: %s", this.PhoneNumber, this.CallDate);
		//return String.format("Phone number : %s ", this.PhoneNumber);
	}
}
