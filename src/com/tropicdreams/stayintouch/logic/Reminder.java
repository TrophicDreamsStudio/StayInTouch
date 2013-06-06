package com.tropicdreams.stayintouch.logic;
import java.util.Date;
public class Reminder {

	private String contact_ID;
	private Date when_to_call;
	private int reminder_ID;
	
	public Reminder(String contact, Date when) {
		// TODO Auto-generated constructor stub
		contact_ID = contact;
		when_to_call = when;
		
	}

	public String getContact(){
		return contact_ID;
	}
	
	public Date getWhenToCall(){
		return when_to_call;
	}
	
	public int getID(){
		return reminder_ID;
	}	
}
