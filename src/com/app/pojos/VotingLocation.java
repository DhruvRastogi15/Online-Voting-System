package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "votingLocation")
public class VotingLocation {

	private Integer locationId;
	private Schedule schedule;
	private Election id;
	public VotingLocation() {
		super();
	}
	public VotingLocation(Integer locationId, Schedule schedule) {
		super();
		this.locationId = locationId;
		this.schedule = schedule;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	
	@Column
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	@Override
	public String toString() {
		return "VotingLocation [locationId=" + locationId + ", schedule=" + schedule + "]";
	}
	
	@ManyToOne
	public Election getId() {
		return id;
	}



	public void setId(Election id) {
		this.id = id;
	}
	
}
