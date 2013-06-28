package com.tropicdreams.stayintouch.logic;

public class CallFrequency {

	private String phone;
	private int freq;
	
	public CallFrequency(String _phone, int _freq)
	{
		phone  = _phone;
		freq = _freq;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public int getFrequency()
	{
		return freq;
	}
	
	@Override 
	public String toString() {
		
		return String.format("Phone number : %s | Frequency: %s", this.getPhone(), this.getFrequency());
		//return String.format("Phone number : %s ", this.PhoneNumber);
	}
}
