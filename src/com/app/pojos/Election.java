package com.app.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "election")
public class Election {
	
	private Integer id;
	private String password;
	private String role;
	private String name;
	private Schedule schedule;
	
	
	private List<VotingLocation> votingLocations;
	private List<WinningCandidate> winningCandidates;
	private List<Party> partys;
	private List<Voter> voters;
	private List<Location> locationsId;

	public Election() {
		super();
	}

	public Election( String name,String password,String role) {
		super();
		this.password = password;
		this.name = name;
		this.role = role;
	}
	
	
	
	
	
	public Election( String password, String name, List<VotingLocation> votingLocations,
			List<WinningCandidate> winningCandidates, List<Party> partys, List<Voter> voters) {
		super();
		
		this.password = password;
		this.name = name;
		this.votingLocations = votingLocations;
		this.winningCandidates = winningCandidates;
		this.partys = partys;
		this.voters = voters;
	}

	public Election(List<Location> locationsId) {
		super();
		this.locationsId = locationsId;
	}
	

	
	public Election(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Election [id=" + id + ", password=" + password + ", role=" + role + ", name=" + name
				+ ", votingLocations=" + votingLocations + ", winningCandidates=" + winningCandidates + ", partys="
				+ partys + ", voters=" + voters + ", allLocations=" + locationsId + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="locationId",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	
	public List<VotingLocation> getVotingLocations() {
		return votingLocations;
	}

	public void setVotingLocations(List<VotingLocation> votingLocations) {
		this.votingLocations = votingLocations;
	}
	
	@OneToMany(mappedBy="id",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	
	public List<WinningCandidate> getWinningCandidates() {
		return winningCandidates;
	}

	public void setWinningCandidates(List<WinningCandidate> winningCandidates) {
		this.winningCandidates = winningCandidates;
	}

	@OneToMany(mappedBy="id",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	
	public List<Party> getPartys() {
		return partys;
	}

	public void setPartys(List<Party> partys) {
		this.partys = partys;
	}

	@OneToMany(mappedBy="id",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	
	public List<Voter> getVoters() {
		return voters;
	}

	public void setVoters(List<Voter> voters) {
		this.voters = voters;
	}

	@OneToMany(mappedBy="id",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	public List<Location> getAllLocations() {
		return locationsId;
	}

	public void setAllLocations(List<Location> locationsId) {
		this.locationsId = locationsId;
	}
	@Column
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Column
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	

}
