package com.register.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQuery(name="User.findById", query="SELECT u FROM User u WHERE u.id = :id")
public class User implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Temporal(TemporalType.DATE)
	private Date lastLogin;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="vehicle_fk")
	private Vehicle vehicleDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Vehicle getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(Vehicle vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}
	
   
}
