package org.sanchit.services.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.sanchit.services.messenger.model.Message;
import org.sanchit.services.messenger.resources.beans.MessageFilterBean;
import org.sanchit.services.messenger.service.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResources {

	MessageService messageservice = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
		
		if (filterBean.getYear() > 0){
			
			return messageservice.getAllMessagesForYear(filterBean.getYear());
		}
		
		if (filterBean.getStart() > 0 && filterBean.getSize() > 0){
			return messageservice.getAllMessagesPaignated(filterBean.getStart(), filterBean.getSize());
		}
		
		return messageservice.getAllMessages();
	}
	
	@POST
	public Response addMessage(Message message){
		Message newMessage = messageservice.addMessage(message);
		
		return Response.status(Status.CREATED)
				.entity(newMessage)
				.build();
		//return messageservice.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id,Message message){
			message.setId(id);
			return messageservice.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id){
		 messageservice.removeMessage(id);
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo){
		
		Message message = messageservice.getMessage(id);
	
		message.addLink(getUriForSelf(uriInfo, message), "self");
		
		return message;
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder()
			   .path(MessageResources.class)
			   .path(Long.toString(message.getId()))
			   .build()
			   .toString();
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
}
