package com.app.pojos;

import javax.persistence.*;

@Embeddable
public class Detail {
	
	private String name;
	private String gender;
	private String profession;
	
	private Integer age;
	public Detail() {
		super();
	}
	public Detail(String name,Integer age, String gender, String profession ) {
		super();
		this.name = name;
		this.gender = gender;
		this.profession = profession;
		
		this.age = age;
	}
	@Override
	public String toString() {
		return "Detail [name=" + name + ", gender=" + gender + ", profession=" + profession + 
				 ", age=" + age + "]";
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(length=20)
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	@Column
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
		
}
