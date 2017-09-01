package com.register.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



import com.register.entities.ApplicationUser;
import com.register.entities.Vehicle;

/**
 * Session Bean implementation class VehicleBean
 */
@Stateless
@LocalBean
public class VehicleBean {

    /**
     * Default constructor. 
     */
    public VehicleBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="register")
    private EntityManager em;
    
    public Vehicle addVehicle(Vehicle v) {
    	
    	em.persist(v);
    	
    	return v;
    	
    }
    
    public List<Vehicle> getVehicles() {
    	
    	TypedQuery<Vehicle> query = em.createQuery("SELECT v FROM Vehicle v" , Vehicle.class);
    	
    	List<Vehicle> results = query.getResultList();
    	
    	return results;
    }
    
    public Vehicle getVehicle(int vehicleId){
    	
    	TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findById", Vehicle.class);
    	
    	query.setParameter("idVehicle", vehicleId);
    	
    	Vehicle v = null;
    	
    	try{
    		
    		v = query.getSingleResult();
    	
    	} catch(NoResultException e){
    		return null;
    	}
    	
    	return v;
    	
    }
    
    public Vehicle updateVehicle(int vehicleId, Vehicle vUpdated){
    	
    	vUpdated.setId(vehicleId);
    	
    	Vehicle vCheckExist = em.find(Vehicle.class, vehicleId);
    	
    	if(vCheckExist == null){
    		return null;
    	}
    	
    	em.merge(vUpdated);
    	
    	return vUpdated;
    }
    
    public void addNewVehicleToUser(Vehicle v, String uid) {
    	
    	em.persist(v);
    	
    	
    	
    	TypedQuery<ApplicationUser> uQuery = em.createNamedQuery("ApplicationUser.findById", ApplicationUser.class);
    	
    	uQuery.setParameter("idApplicationUser", Integer.parseInt(uid));
    	
    	ApplicationUser u = uQuery.getSingleResult();
    	
    	List<Vehicle> vList = u.getVehicles();
    	
    	vList.add(v);
    	
    	u.setVehicles(vList);
    	
    	v.setUserForVehicle(u);
    	
    }

}
