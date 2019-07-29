package com.app.pojos;

import javax.persistence.*;

@Embeddable
public class Person {
	
	private Credential credential;
	private Detail detail;
	private Authentication auth;
	private Address address;
	private Integer locationId;
	
	
	public Person() {
		super();
	}


	public Person(Credential credential, Detail detail, Authentication auth, Address address, Integer locationId) {
		super();
		this.credential = credential;
		this.detail = detail;
		this.auth = auth;
		this.address = address;
		this.locationId = locationId;
	}


	public Person(Credential credential, Detail detail, Authentication auth, Address address) {
		super();
		this.credential = credential;
		this.detail = detail;
		this.auth = auth;
		this.address = address;
		
	}
	


	@Override
	public String toString() {
		return "Person [credential=" + credential + ", detail=" + detail + ", auth=" + auth + ", address=" + address
				+ ", locationId=" + locationId + "]";
	}

	@Column
	public Credential getCredential() {
		return credential;
	}


	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	@Column
	public Detail getDetail() {
		return detail;
	}


	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	@Column
	public Authentication getAuth() {
		return auth;
	}


	public void setAuth(Authentication auth) {
		this.auth = auth;
	}

	@Column
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	@Column
	public Integer getLocationId() {
		return locationId;
	}


	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	
	
	
	
	
	

}
