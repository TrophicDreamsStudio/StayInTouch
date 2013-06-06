

/**
 * 
 */
package com.tropicdreams.stayintouch.datasource;

/**
 * @author LRB
 *
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Database extends SQLiteOpenHelper {
	private static final String MYDATABASE = "stayintouch.db";
	private static final String CREATE_DATABASE = "create table contact (id integer primary key autoincrement, name text, groupid integer);"
			+ "create table caregroups(id integer primary key autoincrement, name text,date_created text);"
			+ "create table reminders(id integer primary key autoincrement,contactId text, date_to_launch text, status text);";
	public static final String CAREGROUP_TABLE="caregroups";
	public static final String CONTACT_TABLE="contact";
	public static final String REMINDERS_TABLE="reminders";
	
	//The following are static fields for the various columns in the care groups table
	public static final String CAREGROUP_COLUMN_ID="id";
	public static final String CAREGROUP_COLUMN_NAME="name";
	public static final String CAREGROUP_COLUMN_DATE="date_created";
	
	//The following are static fields for the various columns in the contacts table
	public static final String CONTACT_COLUMN_ID="id";
	public static final String CONTACT_COLUMN_NAME="name";
	public static final String CONTACT_COLUMN_GROUPID="groupid";
	
	//the following are static fields for the reminders table columns
	public static final String REMINDERS_COLUMN_ID="id";
	public static final String REMINDERS_COLUMN_DATE="date_to_launch";
	public static final String REMINDERS_COLUMN_STATUS="status";//determines the state of a reminder
	public static final String REMINDERS_COLUMN_CONTACT="contactId";
	private static final int VERSION = 1;
	/**
	 * Manages the database connection
	 * @param connection
	 */
	public Database(Context connection) {
		super(connection, MYDATABASE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_DATABASE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("");
		onCreate(db);
	}
	
	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
	
}
