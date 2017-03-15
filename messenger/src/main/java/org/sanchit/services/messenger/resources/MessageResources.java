package org.sanchit.services.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sanchit.services.messenger.model.Message;
import org.sanchit.services.messenger.service.MessageService;

@Path("messages")
public class MessageResources {

	MessageService messageservice = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageservice.getAllMessages();
	}
}
