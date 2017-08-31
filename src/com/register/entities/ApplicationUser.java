package com.register.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQuery(name="ApplicationUser.findById", query="SELECT u FROM ApplicationUser u WHERE u.idApplicationUser = :idApplicationUser")
public class ApplicationUser implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public ApplicationUser() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idApplicationUser;
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Temporal(TemporalType.DATE)
	private Date lastLogin;
	
	@OneToMany(mappedBy = "userForVehicle")
	private List<Vehicle> vehicles;

	public int getId() {
		return idApplicationUser;
	}

	public void setId(int id) {
		this.idApplicationUser = id;
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

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
   
}
