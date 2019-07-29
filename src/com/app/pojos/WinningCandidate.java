package com.app.pojos;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "winningCandidate")
public class WinningCandidate {
	private Integer id;
	private List<Integer> candidate;
	private Election eId;

	public WinningCandidate() {
		super();
	}

	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




	public WinningCandidate(Integer id, List<Integer> candidate) {
		super();
		this.id = id;
		this.candidate = candidate;
	}



	@ElementCollection
	public List<Integer> getCandidate() {
		return candidate;
	}




	public void setCandidate(List<Integer> candidate) {
		this.candidate = candidate;
	}

	@ManyToOne
	public Election getEid() {
		return eId;
	}



	public void setEid(Election eId) {
		this.eId = eId;
	}
	

}
