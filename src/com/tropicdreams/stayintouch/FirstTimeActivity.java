package com.tropicdreams.stayintouch;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;

public class FirstTimeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_time);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_time, menu);
		return true;
	}
	
	public void set_not_first_time(){
		SharedPreferences prefs;
		prefs=getSharedPreferences(MY_PREFS, MODE_PRIVATE);
		SharedPreferences.Editor editor= prefs.edit();
		editor.putString(FIRST_TIME, "completed");
		editor.commit();
	}
	
	public final static String MY_PREFS="MyPrefs";
    public final static String FIRST_TIME="firstTime";

}
