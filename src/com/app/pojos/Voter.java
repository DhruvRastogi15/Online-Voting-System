package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name ="voter")
public class Voter  {
	
	private Boolean votingStatus;
	private Person personal;
	private Integer eId;
	private Election id;
	public Voter() {
		super();
	}

	
	public Voter(Boolean votingStatus, Person personal, Integer eId, Election id) {
		super();
		this.votingStatus = votingStatus;
		this.personal = personal;
		this.eId = eId;
		this.id = id;
	}


	public Voter(Election id) {
		super();
		this.id = id;
	}


	public Voter(Person personal, Election id) {
		super();
		this.personal = personal;
		this.id = id;
	}


	public Voter(Boolean votingStatus, Person personal) {
		super();
		this.votingStatus = votingStatus;
		this.personal = personal;
		
	}

	public Voter(Person personal) {
		super();
		this.personal = personal;
	}

	public Voter(Credential c,Detail d,Address a,Authentication at)
	{
		super();
		
		System.out.println(c+"------"+d+"------"+a+"------"+at);
		
		
	}
	@Override
	public String toString() {
		return "Voter [votingStatus=" + votingStatus + ", personal=" + personal + ", eId=" + eId + "]";
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	@Column
	public Boolean getVotingStatus() {
		return votingStatus;
	}

	public void setVotingStatus(Boolean votingStatus) {
		this.votingStatus = votingStatus;
	}
	
	@Column
	public Person getPersonal() {
		return personal;
	}

	public void setPersonal(Person personal) {
		this.personal = personal;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public Election getId() {
		return id;
	}



	public void setId(Election id) {
		this.id = id;
	}
	
	
}
