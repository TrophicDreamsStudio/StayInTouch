package com.tropicdreams.stayintouch.adapter;

import java.util.ArrayList;
import com.tropicdreams.stayintouch.R;
import com.tropicdreams.stayintouch.fragments.CareList;
import com.tropicdreams.stayintouch.model.Contact;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ContactAdapter extends ArrayAdapter<Contact> {
    
    private ArrayList<Contact> data;
    private int layoutResourceId;
    private Context context; 
    
    CareList gtt = new CareList();
    
    
    public ContactAdapter(Context a, int layoutResourceId, ArrayList<Contact> suggests) {
    	super(a,layoutResourceId,suggests);
        this.context = a;
        this.data = suggests;
        this.layoutResourceId = layoutResourceId;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        ContactHolder holder = null;
       
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        vi = inflater.inflate(layoutResourceId, parent, false);

        holder = new ContactHolder();
        holder.contact = data.get(position);
        
        holder.remove = (Button)vi.findViewById(R.id.contact_group_remove);
        holder.remove.setTag(holder.contact);
        
        holder.name = (TextView)vi.findViewById(R.id.contact_list_name);
        holder.frequency = (TextView)vi.findViewById(R.id.contact_list_freq);
        setRemoveButton(holder);
        vi.setTag(holder);
        setupItem(holder);
        return vi;
        
    }
    
    private void setupItem(ContactHolder holder){
    	holder.name.setText(holder.contact.getName());
    	holder.frequency.setText(holder.contact.getPhone());
    }
    
    public static class ContactHolder{
    	Contact contact;
    	TextView name;
    	TextView frequency;
    	Button remove;
    }
    
    private void setRemoveButton(final ContactHolder holder){
    	holder.remove.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Contact item = (Contact)v.getTag();
				remove(item);
			}
		});
    }
}