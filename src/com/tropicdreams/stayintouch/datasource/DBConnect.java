

/**
 * 
 */
package com.tropicdreams.stayintouch.datasource;

import java.util.Date;
import java.util.List;

/**
 * @author LRB
 *
 */

/**
 * @author LRB
 *
 */
public interface DBConnect {
	/**
	 * Gets the available care groups names
	 * @return a list of groups
	 */
public List<String> GetCareGroups();

/**
 * Gets contacts in a care group
 * @param careGroup
 * @return a List of contact Id s
 */
public List<String> GetCareGroupContacts(String careGroup);

/**
 * Adds a contact to a care group using the contact's ID
 * @param contactId
 * @param groupName
 * @return a boolean indicating the status of the transaction
 */
public boolean AddContactToCareGroup(String contactId,String groupName);

/**
 * Adds a new care group
 * @param groupName
 * @return
 */
public boolean AddCareGroup(String groupName);

/**
 * Gets the user group using the user id
 * @param contactId
 * @return the group name
 */

public String GetContactGroup(String contactId);

/**
 * Returns a boolean indicating if the reminder was added successfully for the specified contact
 * @param contactId
 * @param reminderDate
 * @return boolean
 */
public boolean AddReminderForContact(String contactId,Date reminderDate);
}