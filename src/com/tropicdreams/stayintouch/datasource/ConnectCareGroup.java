package com.tropicdreams.stayintouch.datasource;

import com.tropicdreams.stayintouch.model.CareGroup;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * @author Tomiwa Ijaware
 * 
 */
public class ConnectCareGroup {
	private SQLiteDatabase database;
	private Database dbHelper;
	private String LOGTAG= "message";
	private String[] caregroupcolumns = new String[] {
			Database.CAREGROUP_COLUMN_ID, Database.CAREGROUP_COLUMN_NAME,
			Database.CAREGROUP_COLUMN_DATE };

	public ConnectCareGroup(Context context) {
		dbHelper = new Database(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
		Log.i(LOGTAG, "Database Opened");
	}

	public void close() throws SQLException {
		dbHelper.close();
		Log.i(LOGTAG, "Dabase Closed");
	}

	public CareGroup create(CareGroup careGroup){
		ContentValues values= new ContentValues();
	//	values.put(Database.CAREGROUP_COLUMN_NAME, careGroup.Name);
	//	values.put(Database.CAREGROUP_COLUMN_DATE, careGroup.Date);
		long insertId= database.insert(Database.CAREGROUP_TABLE, null, values);
	//	careGroup.Id=insertId;
		return careGroup;
	}
	
}
