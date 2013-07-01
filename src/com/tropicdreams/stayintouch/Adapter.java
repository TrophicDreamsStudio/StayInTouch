package com.tropicdreams.stayintouch;

import java.util.ArrayList;

import com.tropicdreams.stayintouch.logic.GroupSuggestion;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter extends BaseAdapter {
    
    private Activity activity;
    private ArrayList<GroupSuggestion> data;
    private static LayoutInflater inflater=null;
   // public ImageLoader imageLoader; 
    
    public Adapter(Activity a, ArrayList<GroupSuggestion> suggests) {
        activity = a;
        data=suggests;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     //   imageLoader=new ImageLoader(activity.getApplicationContext());
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
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView name = (TextView)vi.findViewById(R.id.list_name);
        TextView sugg = (TextView)vi.findViewById(R.id.list_suggestion);
        name.setText(data.get(position).getPhone());
        sugg.setText(data.get(position).getSuggestion());
        return vi;
    }
}