package org.sanchit.services.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public class CommentResource {
	
	@GET
	public String test(){
		return "new Sub Resource";
	}

	
	@GET
	@Path("/{commentId}")
	public String test2(){
		return "this is new method of sub resource";
	}
}
