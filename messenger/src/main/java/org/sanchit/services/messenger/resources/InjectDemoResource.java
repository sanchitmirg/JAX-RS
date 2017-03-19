package org.sanchit.services.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String getParamUsingAnnotations(@MatrixParam("param") String matrixparam,
											@HeaderParam("customHeaderValue") String header){
		return matrixparam + header;
	}
	
	@GET
	@Path("context")
	public String getParamusingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		
		String path = uriInfo.getAbsolutePath().toString();
		return path;
	}


}