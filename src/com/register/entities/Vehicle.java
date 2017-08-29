package com.register.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehicle
 *
 */
@Entity
@NamedQuery(name="Vehicle.findById", query="SELECT v FROM Vehicle v WHERE v.id = :id")
public class Vehicle implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Vehicle() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String brand;
	private String model;
	private String typeDesignation;
	private String VIN;
	private String comment;
	private boolean seatHeating;
	private boolean airbags;
	private boolean overturningSystem;
	
	@OneToOne(mappedBy = "vehicleDetails")
	private User user;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTypeDesignation() {
		return typeDesignation;
	}
	public void setTypeDesignation(String typeDesignation) {
		this.typeDesignation = typeDesignation;
	}
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isSeatHeating() {
		return seatHeating;
	}
	public void setSeatHeating(boolean seatHeating) {
		this.seatHeating = seatHeating;
	}
	public boolean isAirbags() {
		return airbags;
	}
	public void setAirbags(boolean airbags) {
		this.airbags = airbags;
	}
	public boolean isOverturningSystem() {
		return overturningSystem;
	}
	public void setOverturningSystem(boolean overturningSystem) {
		this.overturningSystem = overturningSystem;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
   
}
