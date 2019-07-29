package com.app.pojos;

import javax.persistence.*;

@Embeddable
public class Credential {
	
	
	private String password;
	private String role;
	
	public Credential() {
		super();
	}

	public Credential(String role) {
		super();
		this.role = role;
	}

	public Credential( String password, String role) {
		super();
		
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Credential [ password=" + password + ", role=" + role + "]";
	}
	
	@Column(length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=20)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	

}
