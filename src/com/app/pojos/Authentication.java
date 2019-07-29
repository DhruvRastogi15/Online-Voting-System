package com.app.pojos;

import javax.persistence.*;

@Embeddable
public class Authentication {

	private String mobile;
	private String email;
	private String aadhar;
	private Boolean aadharStatus;
	
	public Authentication() {
		super();
	}
	
	public Authentication(String mobile, String email,String aadhar) {
		super();
		this.mobile = mobile;
		this.email = email;
		this.aadhar=aadhar;
		
	}
	
	@Override
	public String toString() {
		return "Authentication [mobile=" + mobile + ", email=" + email + ", aadhar=" + aadhar + ", aadharStatus="
				+ aadharStatus + "]";
	}
	
	@Column(length=20)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Column(length=20)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=20)
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	@Column
	public Boolean getAadharStatus() {
		return aadharStatus;
	}
	public void setAadharStatus(Boolean aadharStatus) {
		this.aadharStatus = aadharStatus;
	}
	
	
}
