package com.tropicdreams.stayintouch;

import android.support.v4.app.DialogFragment;
import java.util.ArrayList;

import com.tropicdreams.stayintouch.adapter.SuggestionAdapter;
import com.tropicdreams.stayintouch.fragments.CareList;
import com.tropicdreams.stayintouch.logic.CallEntry;
import com.tropicdreams.stayintouch.logic.CallFrequency;
import com.tropicdreams.stayintouch.logic.CallLogsUtil;
import com.tropicdreams.stayintouch.logic.GroupSuggestion;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AlertDialogManager extends DialogFragment {

		 ArrayList<CallEntry> logEntries;
	     ArrayList<CallFrequency> freqs ;
	     ArrayList<GroupSuggestion> suggests;
	     SuggestionAdapter adapter;

		public static AlertDialogManager newInstance(int title) {
			AlertDialogManager frag = new AlertDialogManager();
	        Bundle args = new Bundle();
	        args.putInt("title", title);
	        frag.setArguments(args);
	        return frag;
	    }

		public void showAlertDialog(Activity context, String title) {
			CallLogsUtil util = new CallLogsUtil(context);
			logEntries = util.getCallLogs();
	        freqs = util.getCallLogFrequencies(logEntries);
	        suggests = util.suggestCareGroups(freqs);
	        adapter=new SuggestionAdapter(context,R.layout.suggestion_list_row, suggests);
	        
	        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
	        View vi;
	        ViewGroup parent = null;
			vi = inflater.inflate(R.layout.dialog_list, parent, false);
			ListView listview = (ListView)vi.findViewById(R.id.custom_list);
			listview.setEmptyView(vi.findViewById(R.id.empty_list_view));
			listview.setAdapter(adapter);

			AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
			alertDialog.setTitle(title);
			alertDialog.setIcon(R.drawable.success);
			alertDialog.setView(vi);
			alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					CareList.doPositiveClick();
				}
			});
			alertDialog.create();

			// Showing Alert Message
			alertDialog.show();
		}
		
	}

