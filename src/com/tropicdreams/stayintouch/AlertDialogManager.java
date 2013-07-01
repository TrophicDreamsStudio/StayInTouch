package com.tropicdreams.stayintouch;

import java.util.ArrayList;
import com.tropicdreams.stayintouch.logic.CallEntry;
import com.tropicdreams.stayintouch.logic.CallFrequency;
import com.tropicdreams.stayintouch.logic.CallLogsUtil;
import com.tropicdreams.stayintouch.logic.GroupSuggestion;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.ListView;

public class AlertDialogManager extends DialogFragment{
	
	 ArrayList<CallEntry> logEntries;
     ArrayList<CallFrequency> freqs ;
     ArrayList<GroupSuggestion> suggests;
     Adapter adapter;
	
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
       adapter=new Adapter(context, suggests);
		ListView list = new ListView(context);
		list.setAdapter(adapter);
		
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle(title);
		alertDialog.setIcon(R.drawable.success);
		alertDialog.setView(list);
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

