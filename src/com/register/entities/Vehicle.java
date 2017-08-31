package com.register.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehicle
 *
 */
@Entity
@NamedQuery(name="Vehicle.findById", query="SELECT v FROM Vehicle v WHERE v.idVehicle = :idVehicle")
public class Vehicle implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Vehicle() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idVehicle;
	
	private String brand;
	private String model;
	private String typeDesignation;
	private String VIN;
	private String comment;
	private boolean seatHeating;
	private boolean airbags;
	private boolean overturningSystem;
	
	@ManyToOne
	@JoinColumn(name = "user_fk")
	private ApplicationUser userForVehicle;

	public int getId() {
		return idVehicle;
	}
	public void setId(int idVehicle) {
		this.idVehicle = idVehicle;
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
	public void setVIN(String VIN) {
		this.VIN = VIN;
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
	public ApplicationUser getUserForVehicle() {
		return userForVehicle;
	}
	public void setUserForVehicle(ApplicationUser userForVehicle) {
		this.userForVehicle = userForVehicle;
	}
   
}
