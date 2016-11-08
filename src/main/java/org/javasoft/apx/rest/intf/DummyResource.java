/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.apx.rest.intf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ayojava
 */
@Path("/resource")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface DummyResource {
    
    @GET
    @Path("/response")
    public Response getDummyResponse();
}
