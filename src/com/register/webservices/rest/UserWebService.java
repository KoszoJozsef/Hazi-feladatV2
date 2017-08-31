package com.register.webservices.rest;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.register.beans.UserBean;
import com.register.entities.ApplicationUser;


@Path("/users")
@Transactional
public class UserWebService {
	
	public UserWebService() {
		
	}
	
	@PersistenceContext(unitName="register")
	EntityManager em;
	
	@EJB
	UserBean ub;
	
	@PUT
	@Consumes("application/json")
	@Path("/edit/{uId}")
	public Response updateUser(@PathParam("uId") int userId, ApplicationUser uUpdated){
		
		uUpdated = ub.updateUser(userId, uUpdated);
		
		if(uUpdated == null){
			throw new NotFoundException("The user with an id of " + userId + "was not found!");
		}
		
		return Response.ok(uUpdated).build();
		
	}
	
	

}
