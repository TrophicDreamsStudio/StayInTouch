package com.tropicdreams.stayintouch.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import java.util.Map;
import java.util.HashMap;

public class CallLogsUtils extends Activity {

	public CallLogsUtils() {
		// TODO Auto-generated constructor stub
	}
	
	//this method returns an arraylist containig the Call Logs on the device..i really wish we could restrict it 
	//to just calls dated two weeks back
	public ArrayList<CallLogEntry> getCallLogs(){

		ArrayList<CallLogEntry>  callEntries = new ArrayList<CallLogEntry>();
		//do the magic....and return a list of recently called numbers
		final String[] projection = null;
		final String selection  = null;
		final String[] selectionArgs  = null;
		final String sortOrder = android.provider.CallLog.Calls.DATE + " DESC";
		Cursor cursor  = null;
		try{
			cursor  = this.getContentResolver().query(Uri.parse("content://call_log/calls"),
					projection, 
					selection, 
					selectionArgs,
					sortOrder);
			while(cursor.moveToNext()){
				// phone number
				String callNumber  = cursor.getString(cursor.getColumnIndex(android.provider.CallLog.Calls.NUMBER));
				//call date
				String callDate = cursor.getString(cursor.getColumnIndex(android.provider.CallLog.Calls.DATE));
				//call type --1-incoming --2-outgoing --3-missed
				String callType = cursor.getString(cursor.getColumnIndex(android.provider.CallLog.Calls.TYPE));
				
				if(Integer.parseInt(callType) == 2)
				{ //outgoing calls
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date = dateFormat.parse(callDate);
					CallLogEntry ent = new CallLogEntry(callNumber,date);
					callEntries.add(ent);
				}
			}			
		}
		catch(Exception ex)
		{
			return null;
		}
		finally
		{
			return callEntries;
		}
	}

	
	//Accepts: An ArrayList of the Call Log entry containing all the calls made 
	
	//Returns:  A dictionary of the Call Log entry mapped to the number of times its been called
	public Map<CallLogEntry, Integer> createCallLogFrequencies(ArrayList<CallLogEntry> entries){
		Map<CallLogEntry, Integer> frequencies = new HashMap<CallLogEntry, Integer>();
		
		int freq = 0;
		
		for(CallLogEntry ent : entries ){
			freq = Collections.frequency(entries, ent);
			frequencies.put(ent, freq);
		}
		return frequencies;
	}
	
	
	//Accepts: An ArrayList of the Call Log entry containing all the calls made 
	
	//Returns: An ArrayList of the Call Log entry containing all the calls made but this time filtered to just two weeks from current time
	//public ArrayList<CallLogEntry> filterCallLogsByTime(){
		
		//fixed time frame of two weeks.
		
		//get only logs that are within the kast two weeks
		
	//}

	
	//Accepts: A Dictionary of the Call Log entries mapped to frequency of calls
	
	//Returns: A dictionary of the Call Log entries mapped to the suggested Care group
	public Map<CallLogEntry, String> suggestCareGroups(Map<CallLogEntry, Integer> entries){
		
		//Dictionary-like holder of the care group suggestions; It maps a call log entry to the suggested care group it should be added to
		Map<CallLogEntry, String> careGroupSuggests = new  HashMap<CallLogEntry, String>();
		for(CallLogEntry  ent : entries.keySet()){
			if(entries.get(ent) == 1){
				careGroupSuggests.put(ent, "Monthly");
			}
			else if(entries.get(ent) >= 2 | entries.get(ent) <= 8){
				careGroupSuggests.put(ent, "Weekly");
			}
			else if(entries.get(ent) > 8){
				careGroupSuggests.put(ent, "Daily");
			}
		}
		return careGroupSuggests;
	}
}
