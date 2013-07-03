package com.tropicdreams.stayintouch;


import java.util.ArrayList;
import java.util.HashMap;
import com.tropicdreams.stayintouch.logic.CallEntry;
import com.tropicdreams.stayintouch.logic.CallFrequency;
import com.tropicdreams.stayintouch.logic.CallLogsUtil;
import com.tropicdreams.stayintouch.logic.GroupSuggestion;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;

public class CareList extends ListFragment {
	/**
	 * Array with strings to show in list
	 */
	Adapter adapter;
	static String KEY_NAME = "name";
	HashMap<String, String> map = new HashMap<String, String>();
	 ArrayList<CallEntry> logEntries;
     ArrayList<CallFrequency> freqs ;
     ArrayList<GroupSuggestion> suggests;
     
     AlertDialogManager alert = new AlertDialogManager();
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        alert.showAlertDialog(getActivity(), "Stay in touch");
	        CallLogsUtil util = new CallLogsUtil(getActivity());
	         logEntries = util.getCallLogs();
	         freqs = util.getCallLogFrequencies(logEntries);
	         suggests = util.suggestCareGroups(freqs);
	        adapter=new Adapter(getActivity(),R.layout.list_row ,suggests);
	        setListAdapter(adapter);
	       
	    }
	 
	 
	 @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setEmptyText("No suggestion Left");
	}


	public static void doPositiveClick() {
		    // Do stuff here.
		    Log.i("FragmentAlertDialog", "Positive click!");
		}
}

