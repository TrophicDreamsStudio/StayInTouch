package com.tropicdreams.stayintouch;


import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class CareList extends ListFragment {
	
	/**
	 * Array with strings to show in list
	 */
	Adapter adapter;
	static String KEY_NAME = "name";
	ArrayList<HashMap<String, String>> contacts = new ArrayList<HashMap<String,String>>();
	HashMap<String, String> map = new HashMap<String, String>();
	
	public  CareList() {
		 map.put(KEY_NAME, "John Utaka");
		 contacts.add(map);
	}
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        adapter=new Adapter(getActivity(), contacts);
	        // Create an array adapter for the list view, using the data array
	      //  setListAdapter(new ArrayAdapter<String>(getActivity(), layout, dataArray));
	        setListAdapter(adapter);
	    }
	
	@Override
	public void onListItemClick(ListView list, View v, int position, long id) {
		/**
		 * Toast message will be shown when you click any list element
		 */
		String text = contacts.get(position).get(KEY_NAME);
		Toast.makeText(getActivity(),text, Toast.LENGTH_LONG).show();
	}

	

}
