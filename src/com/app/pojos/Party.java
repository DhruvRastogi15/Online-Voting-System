package com.app.pojos;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "party")
public class Party {
	
	private Credential credential;
	private String name;
	private List<String> agenda;
	private Boolean authStatus;
	private String slogan;
	private Integer numVotes;
	private Integer eId;
	private Election id;

	private List<Integer> candidateId;


	

	
	
	public Party() {
		super();
	}

	
	
	
	
	public Party(Credential credential, String name, List<String> agenda, Boolean authStatus, String slogan,
			Integer numVotes, Integer eId, Election id, List<Integer> candidateId) {
		super();
		this.credential = credential;
		this.name = name;
		this.agenda = agenda;
		this.authStatus = authStatus;
		this.slogan = slogan;
		this.numVotes = numVotes;
		this.eId = eId;
		this.id = id;
		this.candidateId = candidateId;
	}


	


	public Party(Credential credential, String name, List<String> agenda, String slogan, Integer numVotes,
			Election id) {
		super();
		this.credential = credential;
		this.name = name;
		this.agenda = agenda;
		this.slogan = slogan;
		this.numVotes = numVotes;
		this.id = id;
	}





	public Party(Credential credential, String name, List<String> agenda, String slogan, Election id) {
		super();
		this.credential = credential;
		this.name = name;
		this.agenda = agenda;
		this.slogan = slogan;
		this.id = id;
	}



	public Party(List<Integer> candidateId) {
		super();
		this.candidateId = candidateId;
	}



	public Party(Credential credential, String name, List<String> agenda,
			String slogan) {
		super();
		this.credential = credential;
		this.name = name;
		this.agenda = agenda;
	
		
		this.slogan = slogan;
		
		
	
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
	public Credential getCredential() {
		return credential;
	}



	public void setCredential(Credential credential) {
		this.credential = credential;
	}


	@Column
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	@ElementCollection
	public List<String> getAgenda() {
		return agenda;
	}



	public void setAgenda(List<String> agenda) {
		this.agenda = agenda;
	}


	@Column
	public Boolean getAuthStatus() {
		return authStatus;
	}



	public void setAuthStatus(Boolean authStatus) {
		this.authStatus = authStatus;
	}





	@Column
	public String getSlogan() {
		return slogan;
	}



	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}


	@Column
	public Integer getNumVotes() {
		return numVotes;
	}



	public void setNumVotes(Integer numVotes) {
		this.numVotes = numVotes;
	}


	

	
	@ManyToOne
	public Election getId() {
		return id;
	}



	public void setId(Election id) {
		this.id = id;
	}
	
	@ElementCollection
	public List<Integer> getCandidateId() {
		return candidateId;
	}



	public void setCandidateId(List<Integer> candidateId) {
		this.candidateId = candidateId;
	}

}
