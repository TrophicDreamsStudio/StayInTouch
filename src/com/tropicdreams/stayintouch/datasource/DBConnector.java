package com.tropicdreams.stayintouch.datasource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * @author LRB
 * 
 */
public class DBConnector implements DBConnect {
	private SQLiteDatabase database;
	private Database dbHelper;
	private String LOGTAG= "message";
	private String[] caregroupcolumns = new String[] {
			Database.CAREGROUP_COLUMN_ID, Database.CAREGROUP_COLUMN_NAME,
			Database.CAREGROUP_COLUMN_DATE };
	private String[] contactcolumns = new String[] {
			Database.CONTACT_COLUMN_ID, Database.CONTACT_COLUMN_NAME,
			Database.CONTACT_COLUMN_GROUPID };

	public DBConnector(Context context) {
		dbHelper = new Database(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
		Log.i(LOGTAG, "Dabase Opened");
	}

	public void close() throws SQLException {
		dbHelper.close();
		Log.i(LOGTAG, "Dabase Closed");
	}

	@Override
	public List<String> GetCareGroups() {
		// TODO Load the caregroups from the stayintouch database
		List<String> careGroups = new ArrayList<String>();
		Cursor cursor = database.query(Database.CAREGROUP_TABLE,
				caregroupcolumns, null, null, null, null,
				Database.CAREGROUP_COLUMN_NAME);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			String careGroup = cursor.getString(2);
			careGroups.add(careGroup);
		}
		return careGroups;
	}

	@Override
	public List<String> GetCareGroupContacts(String careGroup) {
		// TODO get the contact ids
		// TODO Get the group then use the id to query the contacts
		List<String> contactIds = new ArrayList<String>();
		Cursor cursor = database.query(Database.CAREGROUP_TABLE,
				caregroupcolumns, Database.CAREGROUP_COLUMN_NAME + "="
						+ careGroup, null, null, null, null, "LIMIT 1");
		cursor.moveToFirst();
		int groupId = cursor.getInt(0);
		cursor = database.query(Database.CONTACT_TABLE, contactcolumns,
				Database.CONTACT_COLUMN_GROUPID + "=" + groupId, null,
				Database.CONTACT_COLUMN_NAME, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			String contact = cursor.getString(2);
			contactIds.add(contact);
		}
		return contactIds;
	}
	//i don port o

	@Override
	public String GetContactGroup(String contactId) {
		// TODO Get the contact's group
		Cursor cursor = database.query(Database.CONTACT_TABLE, contactcolumns,
				Database.CONTACT_COLUMN_NAME + "=" + contactId, null, null,
				null, null, null);
		cursor.moveToFirst();
		String groupId = cursor.getString(2);
		return groupId;
	}

	@Override
	public boolean AddReminderForContact(String contactId, Date reminderDate) {
		// TODO Save a reminder for a contact
		ContentValues values = new ContentValues();
		values.put(Database.REMINDERS_COLUMN_DATE, reminderDate.toString());
		values.put(Database.REMINDERS_COLUMN_CONTACT, contactId);
		values.put(Database.REMINDERS_COLUMN_STATUS, "Pending");
		long insertid = database.insert(Database.REMINDERS_TABLE, null, values);
		if (insertid > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean AddContactToCareGroup(String contactId, String groupName) {
		// TODO Add a contact to a care Group
		// TODO retrieve the groupId and insert into the contact table
		Cursor cursor = database.query(Database.CAREGROUP_TABLE,
				caregroupcolumns, Database.CAREGROUP_COLUMN_NAME + "="
						+ groupName, null, null, null, null, "LIMIT 1");
		cursor.moveToFirst();
		int groupId = cursor.getInt(0);
		ContentValues values = new ContentValues();
		values.put(Database.CONTACT_COLUMN_NAME, contactId);
		values.put(Database.CONTACT_COLUMN_GROUPID, groupId);
		long insertid = database.insert(Database.CONTACT_TABLE, null, values);
		if (insertid > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean AddCareGroup(String groupName) {
		// TODO Auto-generated method stub
		ContentValues values=new ContentValues();
		values.put(Database.CAREGROUP_COLUMN_NAME, groupName);
		values.put(Database.CAREGROUP_COLUMN_DATE, new Date().toString());
		long insertid=database.insert(Database.CAREGROUP_TABLE, null, values);
		if(insertid > 0)
		return true;
		else return false;
	}

}
