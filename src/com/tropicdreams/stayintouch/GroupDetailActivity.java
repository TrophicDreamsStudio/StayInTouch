package com.tropicdreams.stayintouch;

import com.tropicdreams.stayintouch.fragments.ContactsFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GroupDetailActivity extends FragmentActivity {
	
	TextView txtname;
	TextView txtfreq;
	
	String name;
	String freq;
	
	Intent intent;
	
	Button add;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.care_group_view);
		
		txtname = (TextView)findViewById(R.id.care_group_name);
		txtfreq = (TextView)findViewById(R.id.care_group_freq);
		
		intent = this.getIntent();
		
		name = intent.getExtras().getString("name");
		freq = intent.getExtras().getString("freq");
		
		txtname.setText(name);
		txtfreq.setText(freq);
		
		add = (Button)findViewById(R.id.care_group_btn);
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		ContactsFragment fragment = new ContactsFragment();
		fragmentTransaction.add(R.id.contactListFragment, fragment);
		fragmentTransaction.commit();
	}
	

}
