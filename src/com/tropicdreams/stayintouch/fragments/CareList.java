package com.tropicdreams.stayintouch.fragments;

import com.tropicdreams.stayintouch.AlertDialogManager;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;

public class CareList extends ListFragment {
	AlertDialogManager alert;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        alert = new AlertDialogManager();
	        alert.showAlertDialog(getActivity(), "Stay in Touch");
	    }


	public static void doPositiveClick() {
		    // Do stuff here.
		    Log.i("FragmentAlertDialog", "Positive click!");
		}
}

