package com.tropicdreams.stayintouch.model;

import java.util.ArrayList;

/**
 * @author LRB
 *
 */
public class CareGroup {
	private long Id;
	private String Name;
	private String Frequency;
	public ArrayList<Contact> Contacts;
	
	public CareGroup(long id, String name,String freq ){
		Id  = id;
		Name = name;
		Frequency = freq;
		Contacts = new ArrayList<Contact>();
		Contacts.add(new Contact("wande","0703253647"));
		Contacts.add(new Contact("jamay","0703253643"));
	}
	
	
	public ArrayList<Contact> getContacts(){
		return Contacts;
	}
	public Contact addContact(Contact contact){
		Contacts.add(contact);
		return contact;
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getFrequency() {
		return Frequency;
	}


	public void setFrequency(String frequency) {
		Frequency = frequency;
	}


	public void setContacts(ArrayList<Contact> contacts) {
		Contacts = contacts;
	}
	
	
}
