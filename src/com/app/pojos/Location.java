package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="location")
public class Location {

	private Integer locationId;
	private Integer parentLocationId;
	private Address address;
	private Election id;
	public Location() {
		super();
	}
	
	
	
	public Location(Integer locationId, Integer parentLocationId, Address address, Election id) {
		super();
		this.locationId = locationId;
		this.parentLocationId = parentLocationId;
		this.address = address;
		this.id = id;
	}



	public Location(Integer locationId, Integer parentLocationId, Address address) {
		super();
		this.locationId = locationId;
		this.parentLocationId = parentLocationId;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", parentLocationId=" + parentLocationId + ", address=" + address
				+ "]";
	}
	@Id
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	@Column
	public Integer getParentLocationId() {
		return parentLocationId;
	}
	
	@ManyToOne
	public Election getId() {
		return id;
	}
	public void setId(Election id) {
		this.id = id;
	}
	public void setParentLocationId(Integer parentLocationId) {
		this.parentLocationId = parentLocationId;
	}
	@Column
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
