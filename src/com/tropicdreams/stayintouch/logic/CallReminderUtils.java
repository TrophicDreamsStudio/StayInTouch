package com.tropicdreams.stayintouch.logic;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Date;


public class CallReminderUtils extends Activity{

	public CallReminderUtils() {
		// TODO Auto-generated constructor stub
	}

	public void CreateReminder(){}
	
	public ArrayList<Reminder> GetReminders(){
		return new ArrayList<Reminder>();
	}
	
	public void editReminder(int reminderID, Date when){
		//edit the dude and persist changes
	}
	
	public void deleteReminder(int reminderID){
		//delete the dude from persistence
	}
	
	public void saveReminder(Reminder r){
		//put that dude in the Db
	}
	
}
