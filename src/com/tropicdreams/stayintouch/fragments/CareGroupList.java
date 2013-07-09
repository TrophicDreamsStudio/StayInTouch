package com.tropicdreams.stayintouch.fragments;

import java.util.ArrayList;
import com.tropicdreams.stayintouch.GroupDetailActivity;
import com.tropicdreams.stayintouch.adapter.CareGroupAdapter;
import com.tropicdreams.stayintouch.model.CareGroup;
import com.tropicdreams.stayintouch.model.Contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

public class CareGroupList extends ListFragment {
	
	CareGroupAdapter careAdapter;
	ArrayList<CareGroup> data = new ArrayList<CareGroup>();
	CareGroup care;
	public CareGroupList(){
		care = new CareGroup((long) 1.00, "frenzy", "daily");
		data.add(care);
	}
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	    careAdapter = new CareGroupAdapter(getActivity(), data);
	    setListAdapter(careAdapter);
	      
	    }

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String name = data.get(position).getName();
		String freq = data.get(position).getFrequency();
		ArrayList<Contact> conct = data.get(position).getContacts();
		Intent i = new Intent(getActivity() , GroupDetailActivity.class );
		i.putExtra("name", name);
		i.putExtra("freq", freq);
		i.putParcelableArrayListExtra("contact", conct);
		startActivity(i);
		
	}
	 
	 

}
