package com.tropicdreams.stayintouch.logic;

public class GroupSuggestion {

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

