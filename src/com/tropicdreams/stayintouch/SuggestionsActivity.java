package com.tropicdreams.stayintouch;

import java.util.ArrayList;
import com.tropicdreams.stayintouch.logic.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SuggestionsActivity extends Activity {
	CallLogsUtil callsUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);
        callsUtil = new CallLogsUtil(this);
        ArrayList<CallEntry> logEntries = callsUtil.getCallLogs();
        ArrayList<CallFrequency> freqs = callsUtil.getCallLogFrequencies(logEntries);
        ArrayList<GroupSuggestion> suggests = callsUtil.suggestCareGroups(freqs);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<GroupSuggestion>(this, android.R.layout.simple_list_item_1, suggests));
    }    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
  	

}
