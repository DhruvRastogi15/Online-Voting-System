package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Embeddable
public class Schedular {
	
	private Date startDate;
	private Date endDate;
	@Temporal(TemporalType.DATE)
	@Column
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Temporal(TemporalType.DATE)
	@Column
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Schedular [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	public Schedular(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Schedular() {
		super();
	}


	

}
