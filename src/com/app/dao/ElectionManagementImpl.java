package com.app.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.app.pojos.*;

import javassist.expr.Instanceof;

@Repository
public class ElectionManagementImpl implements ElectionManagement {

	private SessionFactory sf;
	@Autowired
	public ElectionManagementImpl(SessionFactory sf) {
		System.out.println("in test dao constr");
		this.sf=sf;
		
	}
	@Override
	public void registerElection(Election e) {
		
		 sf.getCurrentSession().save(e);
		
		
		System.out.println("after");
		System.out.println("election created with ID "+e.getId());
		
	}
	
	public void registerVoter(Voter v)
	{
		sf.getCurrentSession().save(v);
		
		
		System.out.println("after voter registeration");
		System.out.println("voter created with ID "+v.getId());
	}
	@Override
	public void registerCandidate(Candidate cand) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(cand);
		
		
		System.out.println("after Candidate registeration");
		System.out.println("Candidate created with ID "+cand.geteId());
		
	}
	@Override
	public void registerParty(Party party) {
		sf.getCurrentSession().save(party);
		
		
		System.out.println("after PARTY registeration");
		System.out.println("PARTY created with ID "+party.getId());
	}
	@Override
	public Object validateUser(String name, String pass,String role ) {
		
		String jpql1 = "select p from Party p where p.name=:em and p.credential.password=:pa";
		String jpql2 = "select p from Voter p where p.personal.detail.name=:em and p.personal.credential.password=:pa";
		String jpql3 = "select p from Candidate p where p.personal.detail.name=:em and p.personal.credential.password=:pa";
		String jpql4 = "select p from Election p where p.name=:em and p.password=:pa";
		
		Election e = null;
		Party p = null;
		Candidate c = null;
		Voter v = null;
		
		System.out.println(role);
	System.out.println("**************");
	
	if(role.equals("Party"))
	{
	p = sf.getCurrentSession().createQuery(jpql1,Party.class).setParameter("em", name).setParameter("pa", pass).getSingleResult();
	
	if(p != null){
		System.out.println(p);
		return p;
	}
	}
	if(role.equals("Candidate"))
	{
	c = sf.getCurrentSession().createQuery(jpql3,Candidate.class).setParameter("em", name).setParameter("pa", pass).getSingleResult();
	if(c != null){
		System.out.println(c);
		return c;
	}
	}
	if(role.equals("Voter"))
	{
	v = sf.getCurrentSession().createQuery(jpql2,Voter.class).setParameter("em", name).setParameter("pa", pass).getSingleResult();
	if(v != null){
		System.out.println(v);
		return v;
	}
	}
	if(role.equals("Election"))
	{
	e = sf.getCurrentSession().createQuery(jpql4,Election.class).setParameter("em", name).setParameter("pa", pass).getSingleResult();
	if(e != null){
		System.out.println(e);
		return e;
	}
	System.out.println("**************");
		return null;
	}
	return v;
	}
	@Override
	public List<Party> partyList(Election id) {
		
		String jpql = "select p from Party p where p.id=:em ";
		System.out.println("test"+id);
		return sf.getCurrentSession().createQuery(jpql, Party.class).setParameter("em", id).getResultList();
		
	}
	@Override
	public void addLocation(Location loc) {
		
		sf.getCurrentSession().save(loc);
		
		
		System.out.println("after Location adding");
		System.out.println("Candidate created with ID "+loc.getId());
	}
	@Override
	public void removeLocation(int locationId) {
		
		Location loc=sf.getCurrentSession().get(Location.class, locationId);
		System.out.println(loc);
		sf.getCurrentSession().delete(loc);
		System.out.println("removeLocation sucessfull");
		
	}
	@Override
	public List<Location> locList(Election elec) {
		// TODO Auto-generated method stub
		String jpql = "select p from Location p where p.id=:em ";
		System.out.println("test"+elec);
		return sf.getCurrentSession().createQuery(jpql, Location.class).setParameter("em", elec).getResultList();
	}
	@Override
	public List<Candidate> candList(Election elec) {
		// TODO Auto-generated method stub
		String jpql = "select p from Candidate p where p.id=:em ";
		System.out.println("test"+elec);
		return sf.getCurrentSession().createQuery(jpql, Candidate.class).setParameter("em", elec).getResultList();
	}
	@Override
	public List<Party> partyListForVoter(Voter elec) {
		String jpql = "select p from Candidate p where p.id=:em ";
		System.out.println("test"+elec);
		return sf.getCurrentSession().createQuery(jpql, Party.class).setParameter("em", elec).getResultList();
	}
	@Override
	public List<Location> locListForVoter(Voter elec) {
		String jpql = "select p from Candidate p where p.id=:em ";
		System.out.println("test"+elec);
		return sf.getCurrentSession().createQuery(jpql, Location.class).setParameter("em", elec).getResultList();
	}
	@Override
	public List<Candidate> candListForVoter(Voter elec) {
		String jpql = "select p from Candidate p where p.id=:em and p.personal.locationId=:locationId ";
		System.out.println("test"+elec);
		System.out.println("hello");
		Election id=new Election(elec.getId().getId());
		
		return sf.getCurrentSession().createQuery(jpql, Candidate.class).setParameter("em", id).setParameter("locationId", elec.getPersonal().getLocationId()).getResultList();
	}
	@Override
	public Object fetchCandidate(int candidateVoted) {
		
		return sf.getCurrentSession().get(Candidate.class, candidateVoted);
	}
	@Override
	public void candUpVote(Candidate candUpVote) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(candUpVote);
		
	}
	@Override
	public Party fetchParty(Integer partyId) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(Party.class, partyId);
	}
	@Override
	public void partyUpVote(Party partyUpVote) {
		sf.getCurrentSession().update(partyUpVote);
		
	}
	@Override
	public Candidate winningCandidate(Integer id,Integer locationId) {
		String jpql3 = "select p from Candidate p where p.id.id=:id and p.personal.locationId=:locationId and p.numVotes=(select MAX(p.numVotes) from Candidate p where p.id.id=:id and p.personal.locationId=:locationId)";
		Candidate cand =sf.getCurrentSession().createQuery(jpql3,Candidate.class).setParameter("id", id).setParameter("locationId", locationId).getSingleResult();
		System.out.println(cand);
		return cand;
	}
	@Override
	public void voterVotingStatus(Voter voted) {
		// TODO Auto-generated method stub
		
		sf.getCurrentSession().update(voted);
		
	}
	@Override
	public List<Voter> voterList(Election elec) {
		// TODO Auto-generated method stub
		String jpql3 = "select p from Voter p where p.id=:id ";
		List<Voter> voterList= sf.getCurrentSession().createQuery(jpql3,Voter.class).setParameter("id",elec).getResultList();
		return  voterList;
	}
	@Override
	public List<Party> allPartyList() {
		String jpql3 = "select p from Party p  ";
		List<Party> PartyList= sf.getCurrentSession().createQuery(jpql3,Party.class).getResultList();
		System.out.println(PartyList);
		return PartyList;
	}
	@Override
	public List<Location> allLocList() {
		String jpql3 = "select p from Location p  ";
		List<Location> LocationList= sf.getCurrentSession().createQuery(jpql3,Location.class).getResultList();
		System.out.println(LocationList);
		return LocationList;
	}
	@Override
	public List<Election> allElecList() {
		String jpql3 = "select p from Election p  ";
		List<Election> ElectionList= sf.getCurrentSession().createQuery(jpql3,Election.class).getResultList();
		System.out.println(ElectionList);
		return ElectionList;
	}
	
	
}
