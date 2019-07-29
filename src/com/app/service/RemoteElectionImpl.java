package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ElectionManagement;
import com.app.dao.ElectionManagementImpl;
import com.app.pojos.*;


@Service("dao_based_service")
@Transactional
public class RemoteElectionImpl implements RemoteElection{

	@Autowired
	private ElectionManagement dao;

	public RemoteElectionImpl() {
		System.out.println("in test service constr");
		 
		
	}

	@Override
	public void registerElection(Election e) {
		System.out.println(e.getName());
		dao.registerElection(e);
		
	}

	@Override
	public void registerVoter(Voter v) {
//		System.out.println(v.getName());
		dao.registerVoter(v);
		
	}

	@Override
	public void registerCandidate(Candidate cand) {
		// TODO Auto-generated method stub
		dao.registerCandidate(cand);
	}

	@Override
	public void registerParty(Party party) {
		dao.registerParty(party);
		
	}

	@Override
	public Object validateUser(String name, String pass,String role) {
		
		return dao.validateUser(name,pass,role);
	}

	@Override
	public List<Party> partyList(Election id) {
		// TODO Auto-generated method stub
		return dao.partyList(id);
	}

	@Override
	public void addLocation(Location loc) {
		// TODO Auto-generated method stub
		dao.addLocation( loc);
	}

	@Override
	public void removeLocation(int locationId) {
		// TODO Auto-generated method stub
		dao.removeLocation( locationId);
		
	}

	@Override
	public List<Location> locList(Election elec) {
		// TODO Auto-generated method stub
		 return dao.locList(elec);
	}

	@Override
	public List<Candidate> candList(Election elec) {
		// TODO Auto-generated method stub
		return dao.candList(elec);
	}

	@Override
	public List<Party> partyListForVoter(Voter elec) {
		// TODO Auto-generated method stub
		return dao.partyListForVoter(elec);
	}

	@Override
	public List<Location> locListForVoter(Voter elec) {
		// TODO Auto-generated method stub
		return dao.locListForVoter(elec);
	}

	@Override
	public List<Candidate> candListForVoter(Voter elec) {
		// TODO Auto-generated method stub
		return dao.candListForVoter(elec);
	}

	@Override
	public Object fetchCandidate(int candidateVoted) {
		// TODO Auto-generated method stub
		return dao.fetchCandidate(candidateVoted);
		
	}

	@Override
	public void candUpVote(Candidate candUpVote) {
		// TODO Auto-generated method stub
		 dao.candUpVote(candUpVote);
		
	}

	@Override
	public Party fetchParty(Integer partyId) {
		// TODO Auto-generated method stub
		return dao.fetchParty(partyId);
	}

	@Override
	public void partyUpVote(Party partyUpVote) {
		// TODO Auto-generated method stub
		dao.partyUpVote(partyUpVote);
	}

	@Override
	public Candidate winningCandidate(Integer id,Integer locationId) {
		// TODO Auto-generated method stub
		return dao.winningCandidate(id,locationId);
	}

	@Override
	public void voterVotingStatus(Voter voted) {
		dao.voterVotingStatus(voted);
		
	}

	@Override
	public List<Voter> voterList(Election elec) {
		// TODO Auto-generated method stub
		return dao.voterList(elec);
	}

	@Override
	public List<Party> allPartyList() {
		// TODO Auto-generated method stub
		return dao.allPartyList();
	}

	@Override
	public List<Location> allLocList() {
		// TODO Auto-generated method stub
		return dao.allLocList();	}

	@Override
	public List<Election> allElecList() {
		// TODO Auto-generated method stub
		return dao.allElecList();
	}



	
	
	
}
