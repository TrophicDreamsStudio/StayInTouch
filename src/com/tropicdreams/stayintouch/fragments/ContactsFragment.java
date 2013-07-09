package com.tropicdreams.stayintouch.fragments;

import java.util.ArrayList;

import com.tropicdreams.stayintouch.R;
import com.tropicdreams.stayintouch.adapter.ContactAdapter;
import com.tropicdreams.stayintouch.model.Contact;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;

public class ContactsFragment extends ListFragment {
	
	ContactAdapter contactAdapter;
	Intent intent;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		intent = getActivity().getIntent();
		
		ArrayList<Contact> data = intent.getExtras().getParcelableArrayList("contact");
		
		contactAdapter = new ContactAdapter(getActivity(),R.layout.contact_list_row, data);
	    setListAdapter(contactAdapter);
	}
	

}
