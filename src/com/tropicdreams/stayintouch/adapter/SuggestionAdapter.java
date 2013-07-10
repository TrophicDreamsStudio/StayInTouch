package com.tropicdreams.stayintouch.adapter;

import java.util.ArrayList;

import com.tropicdreams.stayintouch.CirclePix;
import com.tropicdreams.stayintouch.R;
import com.tropicdreams.stayintouch.fragments.CareList;
import com.tropicdreams.stayintouch.logic.GroupSuggestion;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuggestionAdapter extends ArrayAdapter<GroupSuggestion> {
    
    private ArrayList<GroupSuggestion> data;
    private int layoutResourceId;
    private Context context; 
    
    CareList gtt = new CareList();
    Bitmap bit;
    CirclePix pix = new CirclePix();
    
    
    
    public SuggestionAdapter(Context a, int layoutResourceId, ArrayList<GroupSuggestion> suggests) {
    	super(a,layoutResourceId,suggests);
        this.context = a;
        this.data = suggests;
        this.layoutResourceId = layoutResourceId;
        this.bit = BitmapFactory.decodeResource(a.getResources(), R.drawable.tife);
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        ContactHolder holder = null;
       
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        vi = inflater.inflate(layoutResourceId, parent, false);

        holder = new ContactHolder();
        holder.contact = data.get(position);
        
        holder.add = (Button)vi.findViewById(R.id.add);
        holder.add.setTag(holder.contact);
        
        holder.remove = (Button)vi.findViewById(R.id.remove);
        holder.remove.setTag(holder.contact);
        
        holder.name = (TextView)vi.findViewById(R.id.list_name);
        holder.phoneNumber = (TextView)vi.findViewById(R.id.list_suggestion);
        holder.badge = (ImageView)vi.findViewById(R.id.list_image);
        
        
        
        setRemoveButton(holder);
        setAddButton(holder);
        vi.setTag(holder);
        setupItem(holder);
        return vi;
        
    }
    
    private void setupItem(ContactHolder holder){
    	holder.name.setText(holder.contact.getPhone());
    	holder.phoneNumber.setText(holder.contact.getSuggestion());
    	
    	holder.badge.setImageBitmap(pix.getRoundedShape(bit));
    }
    
    public static class ContactHolder{
    	GroupSuggestion contact;
    	TextView name;
    	TextView phoneNumber;
    	Button add;
    	Button remove;
    	ImageView badge;
    }
    
    private void setRemoveButton(final ContactHolder holder){
    	holder.remove.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GroupSuggestion item = (GroupSuggestion)v.getTag();
				remove(item);
			}
		});
    }
    
    private void setAddButton(final ContactHolder holder){
    	holder.add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//GroupSuggestion item = (GroupSuggestion)v.getTag();
				Log.i("Adapter", "add to frequency list");
			}
		});
    }
    
}