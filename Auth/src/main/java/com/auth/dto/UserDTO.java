package com.auth.dto;

import com.auth.model.Role;

public class UserDTO {
	private int id;
	private String email;
	private Role role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public UserDTO(int id, String email, Role role) {
		super();
		this.id = id;
		this.email = email;
		this.role = role;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
