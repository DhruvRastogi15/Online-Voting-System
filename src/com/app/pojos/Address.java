package com.app.pojos;

import javax.persistence.*;

@Embeddable
public class Address {
	
	private String area;
	private String city;
	private String State;
	private Integer pincode;
	public Address() {
		super();
		System.out.println("in ocnst ADD");
	}
	public Address(String area, String city, String state, Integer pincode) {
		super();
		this.area = area;
		this.city = city;
		this.State = state;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [area=" + area + ", city=" + city + ", State=" + State + ", pincode=" + pincode + "]";
	}
	@Column(length=20)
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Column(length=20)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(length=20)
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	@Column
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	

}
