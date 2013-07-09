package com.tropicdreams.stayintouch.adapter;

import java.util.ArrayList;
import com.tropicdreams.stayintouch.R;
import com.tropicdreams.stayintouch.model.CareGroup;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CareGroupAdapter extends BaseAdapter {
    
    private Activity activity;
    private ArrayList<CareGroup> data;
    private static LayoutInflater inflater=null; 
    
    public CareGroupAdapter(Activity a, ArrayList<CareGroup> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        
        CareGroup care;
        if(convertView==null)
            vi = inflater.inflate(R.layout.care_group_list_row, null);

        TextView name = (TextView)vi.findViewById(R.id.care_group_list_name); // title
        TextView freq = (TextView)vi.findViewById(R.id.care_group_list_suggestion); // artist name
        
        
        care = data.get(position);
        
        // Setting all values in listview
        name.setText(care.getName());
        freq.setText(care.getFrequency());
        return vi;
    }
}