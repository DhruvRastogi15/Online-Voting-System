package com.app.pojos;

import java.util.List;

import javax.persistence.*;


import java.util.Date;

@Embeddable
public class Schedule {	
	
	private Date partyReg;
	private Date candidateReg;
	private Date voterReg;
	private Date votingReg;
	private Date result;
	
	@Temporal(TemporalType.DATE)
	@Column
	public Date getPartyReg() {
		return partyReg;
	}
	public void setPartyReg(Date partyReg) {
		this.partyReg = partyReg;
	}
	@Temporal(TemporalType.DATE)
	@Column
	public Date getCandidateReg() {
		return candidateReg;
	}
	
	public void setCandidateReg(Date candidateReg) {
		this.candidateReg = candidateReg;
	}
	@Temporal(TemporalType.DATE)
	@Column
	public Date getVoterReg() {
		return voterReg;
	}
	public void setVoterReg(Date voterReg) {
		this.voterReg = voterReg;
	}
	@Temporal(TemporalType.DATE)
	@Column
	public Date getVotingReg() {
		return votingReg;
	}
	public void setVotingReg(Date votingReg) {
		this.votingReg = votingReg;
	}
	@Temporal(TemporalType.DATE)
	@Column
	public Date getResult() {
		return result;
	}
	public void setResult(Date result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "Schedule [partyReg=" + partyReg + ", candidateReg=" + candidateReg + ", voterReg=" + voterReg
				+ ", votingReg=" + votingReg + ", result=" + result +"]";
	}
	public Schedule(Date partyReg, Date candidateReg, Date voterReg, Date votingReg, Date result
			) {
		super();
		this.partyReg = partyReg;
		this.candidateReg = candidateReg;
		this.voterReg = voterReg;
		this.votingReg = votingReg;
		this.result = result;
		
	}
	public Schedule() {
		super();
	}
	 

}
