package com.app.dao;


import java.util.List;

import com.app.pojos.*;

public interface ElectionManagement {

	public void registerElection(Election e);
	public void registerVoter(Voter v);
	public void registerCandidate(Candidate cand);
	public void registerParty(Party party);

	public Object validateUser(String name, String pass,String role);
	public List<Party> partyList(Election id);
	public void addLocation(Location loc);
	public void removeLocation(int locationId);
	public List<Location> locList(Election elec);
	public List<Candidate> candList(Election elec);
	public List<Party> partyListForVoter(Voter elec);
	public List<Location> locListForVoter(Voter elec);
	public List<Candidate> candListForVoter(Voter elec);
	public Object fetchCandidate(int candidateVoted);
	public void candUpVote(Candidate candUpVote);
	public Party fetchParty(Integer partyId);
	public void partyUpVote(Party partyUpVote);
	public Candidate winningCandidate(Integer id,Integer locationId);
	public void voterVotingStatus(Voter voted);
	public List<Voter> voterList(Election elec);
	public List<Party> allPartyList();
	public List<Location> allLocList();
	public List<Election> allElecList();

}
