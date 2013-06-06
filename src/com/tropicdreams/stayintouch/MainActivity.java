package com.tropicdreams.stayintouch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	if (is_first_time()) {
			Toast.makeText(getApplicationContext(), "First Time Application Laumch", Toast.LENGTH_SHORT).show();
		}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent= new Intent(getApplicationContext(), FirstTimeActivity.class);
        startActivity(intent);
    }    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public boolean is_first_time(){
		SharedPreferences prefs;
		prefs=getSharedPreferences(MY_PREFS, MODE_PRIVATE);
		if (prefs.getString(FIRST_TIME, "").isEmpty()) {
			return true;
		}
		return false;
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
