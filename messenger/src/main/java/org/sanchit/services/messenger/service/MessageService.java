package org.sanchit.services.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.sanchit.service.messenger.database.DatabaseClass;
import org.sanchit.services.messenger.model.Message;

public class MessageService {
	
	private HashMap<Long, Message> messages = DatabaseClass.getMessage();
	
	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
		
	}
	
	

}
