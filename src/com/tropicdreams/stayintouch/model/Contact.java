package com.tropicdreams.stayintouch.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable{
	String phone;
	String name;
	
	public Contact(String nam, String Phone){
		name = nam;
		phone = Phone;
	}
	
	public Contact (Parcel in){
		name = in.readString();
		phone = in.readString();
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(name);
		dest.writeString(phone);
		
	}
	
	public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

}
