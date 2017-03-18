package org.sanchit.service.messenger.database;

import java.util.HashMap;

import org.sanchit.services.messenger.model.Message;
import org.sanchit.services.messenger.model.Profile;

public class DatabaseClass {

	private static HashMap<Long,Message> messages = new HashMap<>();
	
	private static HashMap<String,Profile> profiles = new HashMap<>();
	
	public static HashMap<Long, Message>  getMessage(){
		return messages;
	}
	
	public static HashMap<String,Profile> getProfile(){
		return profiles;
	}
	
}
