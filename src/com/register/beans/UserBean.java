package com.register.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.register.entities.ApplicationUser;
import com.register.entities.Vehicle;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
@LocalBean
public class UserBean {

    /**
     * Default constructor. 
     */
    public UserBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="register")
    private EntityManager em;
    
    public void addUser(ApplicationUser u) {
    	
    	em.persist(u);
    	
    }
    
    public List<ApplicationUser> getUsers() {
    	
    	TypedQuery<ApplicationUser> query = em.createQuery("SELECT u FROM ApplicationUser u" , ApplicationUser.class);
    	
    	List<ApplicationUser> results = query.getResultList();
    	
    	return results;
    }
    
    public void addVehicleToUser(String idVehicle, String idUser) {
    	
    	TypedQuery<ApplicationUser> uQuery = em.createNamedQuery("ApplicationUser.findById", ApplicationUser.class);
    	
    	uQuery.setParameter("idApplicationUser", Integer.parseInt(idUser));
    	
    	ApplicationUser u = uQuery.getSingleResult();
    	
    	TypedQuery<Vehicle> vQuery = em.createNamedQuery("Vehicle.findById", Vehicle.class);
    	
    	vQuery.setParameter("idVehicle", idVehicle);
    	
    	Vehicle v = vQuery.getSingleResult();
    	
    	List<Vehicle> vList = u.getVehicles();
    	
    	vList.add(v);
    	
    	u.setVehicles(vList);
    	
    	v.setUserForVehicle(u);
    	
    }
    
    public ApplicationUser updateUser(int userId, ApplicationUser uUpdated){
    	
    	uUpdated.setId(userId);
    	
    	ApplicationUser uCheckExist = em.find(ApplicationUser.class, userId);
    	
    	if(uCheckExist == null){
    		return null;
    	}
    	
    	em.merge(uUpdated);
    	
    	return uUpdated;
    }

}
