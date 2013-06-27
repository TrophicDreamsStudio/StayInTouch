package com.tropicdreams.stayintouch;

import java.util.ArrayList;

import com.tropicdreams.stayintouch.model.CareGroup;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CareGroupsListAdapter extends BaseAdapter{

	private Activity activity;
    private ArrayList<CareGroup> data;
    private static LayoutInflater inflater =null; 
    
    public CareGroupsListAdapter(Activity a, ArrayList<CareGroup> d){
    	activity = a;
    	data = d;
    	inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi= convertView;
//		if (convertView==null) {
//			vi= inflater.inflate(R.layout.caregroup_item, root)
//		}
		return null;
	}
	
}
