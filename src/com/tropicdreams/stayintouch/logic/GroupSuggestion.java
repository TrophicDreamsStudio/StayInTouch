package com.tropicdreams.stayintouch.logic;

import java.io.Serializable;

public class GroupSuggestion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4780868969187735572L;
	private String phone;
	private String suggestion;
	
	public GroupSuggestion(String _phone, String _sugg)
	{
		phone = _phone;
		suggestion = _sugg;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public String getSuggestion()
	{
		return suggestion;
	}
	
	@Override 
	public String toString() {
		
		return String.format("Phone number : %s | Group Suggested: %s", this.getPhone(), this.getSuggestion());
		//return String.format("Phone number : %s ", this.PhoneNumber
	}
}

