package com.register.webservices.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.register.beans.VehicleBean;
import com.register.entities.Vehicle;


@Path("/vehicles")
@Transactional
public class VehicleWebService {
	
	public VehicleWebService(){
		
	}
	
	@PersistenceContext(unitName="register")
	EntityManager em;
	
	@EJB
	VehicleBean vb;
	
	@Context
	UriInfo vUriInfo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehicle> getVehicles(){
		
		List<Vehicle> vList = vb.getVehicles();
		
		return vList;
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{vehicle_id}")
	public Vehicle getVehicle(@PathParam("vehicle_id") int vehicleId){
				
		Vehicle v = vb.getVehicle(vehicleId);
		
		if(v == null) {
			throw new NotFoundException("The vehicle with an id of" + vehicleId + "was not found!");
		}
		
		return v;
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addVehicle(Vehicle v){
		
		v = vb.addVehicle(v);
		
		UriBuilder vUriBuilder = vUriInfo.getAbsolutePathBuilder();
		
		URI vUri = vUriBuilder.path(String.valueOf(v.getId())).build();
		
		return Response.created(vUri).build();
		
	}
	
	@PUT
	@Consumes("application/json")
	@Path("/edit/{vId}")
	public Response updateVehicle(@PathParam("vId") int vehicleId, Vehicle vUpdated){
		
		vUpdated = vb.updateVehicle(vehicleId, vUpdated);
		
		if(vUpdated == null){
			throw new NotFoundException("The vehicle with an id of " + vehicleId + "was not found!");
		}
		
		return Response.ok(vUpdated).build();
		
	}
	
	@DELETE
	@Path("{vehicle_id}")
	public Response deleteVehicle(@PathParam("vehicle_id") int vehicleId){
		
		Vehicle vRemove = em.find(Vehicle.class, vehicleId);
		
		if(vRemove == null){
			throw new NotFoundException("The vehicle with an id of " + vehicleId + "was not found!");
		}
		
		em.remove(vRemove);
		
		return Response.noContent().build();
		
	}

}
