/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.apx.rest.service;

import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.javasoft.apx.rest.intf.DummyResource;

/**
 *
 * @author ayojava
 */
@Slf4j
public class DummyService implements DummyResource{

    @Override
    public Response getDummyResponse() {
        return Response.status(Response.Status.OK).build();
    }
    
}
