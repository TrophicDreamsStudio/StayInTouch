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
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

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

	       // adapter=new Adapter(getActivity(), contacts);
	         logEntries = util.getCallLogs();
	         freqs = util.getCallLogFrequencies(logEntries);
	         suggests = util.suggestCareGroups(freqs);
	        adapter=new Adapter(getActivity(), suggests);
	        setListAdapter(adapter);
	    }
	 
	 public static void doPositiveClick() {
		    // Do stuff here.
		    Log.i("FragmentAlertDialog", "Positive click!");
		}
	 
	
	@Override
	public void onListItemClick(ListView list, View v, int position, long id) {
		/**
		 * Toast message will be shown when you click any list element
		 */
		String phone = suggests.get(position).getPhone();
		String sugg = suggests.get(position).getSuggestion();
		Toast.makeText(getActivity(),"you need to be calling "+ phone+" "+ sugg, Toast.LENGTH_SHORT).show();
	}
}

