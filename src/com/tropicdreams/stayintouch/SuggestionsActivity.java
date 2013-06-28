package com.tropicdreams.stayintouch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.tropicdreams.stayintouch.logic.*;

import android.os.Bundle;
import android.provider.CallLog;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SuggestionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);
        ArrayList<CallEntry> logEntries = getCallLogs();
        ArrayList<CallFrequency> freqs = getCallLogFrequencies(logEntries);
        ArrayList<GroupSuggestion> suggests = suggestCareGroups(freqs);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<GroupSuggestion>(this, android.R.layout.simple_list_item_1, suggests));
    }    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
  	@SuppressWarnings("finally")
	public ArrayList<CallEntry> getCallLogs(){

  		ArrayList<CallEntry> entries = new ArrayList<CallEntry>();
  		final String[] projection = null;
  		final String selection  = null;
  		final String[] selectionArgs  = null;
  		final String sortOrder = android.provider.CallLog.Calls.DATE + " DESC";
  		Cursor cursor  = null;
  		try{
  			cursor  = this.getContentResolver().query(CallLog.Calls.CONTENT_URI,
  					projection, 
  					selection, 
  					selectionArgs,
  					null);
  			while(cursor.moveToNext()){
  				// phone number
  				String callNumber  = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
  				
  				String callType = cursor.getString(cursor.getColumnIndex(CallLog.Calls.TYPE));
  				
  				String callDate = cursor.getString(cursor.getColumnIndex(CallLog.Calls.DATE));
  				
  				//lets parse the date string here...appears to be an epoch thing
  				Date date = new Date(Long.parseLong(callDate));
  				
  				if(Integer.parseInt(callType) == 2) //get only outgoing calls
  				{
  					CallEntry ent = new CallEntry(callNumber, date);
  					entries.add(ent);
  				}
  			}			
  		}
  		catch(Exception ex)
  		{
  			//what shld we do here....uhhmm...
  		}
  		finally
  		{
  			cursor.close();
  			return entries;
  		}
  	}

  //Accepts: An ArrayList of the Call Log entry containing all the calls made 
	
  	//Returns:  A dictionary of the Call Log entry mapped to the number of times its been called
  	public ArrayList<CallFrequency> getCallLogFrequencies(ArrayList<CallEntry> entries){
  		ArrayList<CallFrequency> callFrequencies = new ArrayList<CallFrequency>();
  		int freq = 0;
  		HashMap<String, Integer> entriesCount = getEntryCount(entries);
  		
  		for(String ent : entriesCount.keySet() ){
  			freq = entriesCount.get(ent);
  			CallFrequency cFreq = new CallFrequency(ent, freq);
  			callFrequencies.add(cFreq);
  		}
  		return callFrequencies;
  	}
  	
  	private HashMap<String, Integer> getEntryCount(ArrayList<CallEntry> entries)
  	{
  		HashMap<String, Integer> entryMap = new HashMap<String, Integer>();
  		for(CallEntry e: entries)
  		{
  			int count = 0;
  			if(entryMap.containsKey(e.getPhone()))
  			{
  				entryMap.put(e.getPhone(), entryMap.get(e.getPhone()) + 1);
  			}
  			else
  			{
  				entryMap.put(e.getPhone(), count+1);
  			}
  		}
  		return entryMap;
  	}
  	
  //Accepts: An ArrayList of the Call Log entry containing all the calls made 
	
  	//Returns: An ArrayList of the Call Log entry containing all the calls made but this time filtered to just two weeks from current time
  	public ArrayList<CallEntry> filterCallLogsByTime(){
  		
  		//fixed time frame of two weeks.
  		
  		//get only logs that are within the last two weeks
  		return null;
  	}

  //Returns: A dictionary of the Call Log entries mapped to the suggested Care group
  	public ArrayList<GroupSuggestion> suggestCareGroups(ArrayList<CallFrequency> entries){
  		
  		//Dictionary-like holder of the care group suggestions; It maps a call log entry to the suggested care group it should be added to
  		ArrayList<GroupSuggestion> careGroupSuggests = new  ArrayList<GroupSuggestion>();
  		for(CallFrequency  ent : entries){
  			if(ent.getFrequency() == 1){ 				
  				GroupSuggestion sug = new GroupSuggestion(ent.getPhone(), "Monthly");
  				careGroupSuggests.add(sug);
  			}
  			else if(ent.getFrequency() >= 2 && ent.getFrequency() <= 8){
  				GroupSuggestion sug = new GroupSuggestion(ent.getPhone(), "Weekly");
  				careGroupSuggests.add(sug);
  			}
  			else if(ent.getFrequency() > 8){
  				GroupSuggestion sug = new GroupSuggestion(ent.getPhone(), "Daily");
  				careGroupSuggests.add(sug);
  			}
  		}
  		return careGroupSuggests;
  	}

}
