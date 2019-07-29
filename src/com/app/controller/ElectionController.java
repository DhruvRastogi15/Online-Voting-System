package com.app.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.*;
import com.app.service.*;
import com.app.utils.SendMail;

import javassist.expr.Instanceof;

@Controller
@RequestMapping("/admin")
public class ElectionController {

	@Autowired
	@Qualifier("dao_based_service")
	private RemoteElection obj;

	public ElectionController() {
		System.out.println("in test controller constr");

	}
	
	// @RequestMapping(method="get")
	@GetMapping("/hello")
	public String testMe(Model map) {
		System.out.println("in test");
		// map.addAttribute("date",new Date());
		map.addAttribute(new Date());
		return "test/welcome";
		
	}

	@GetMapping("/login")
	public String showLogin() {
		System.out.println("in login");
		// map.addAttribute("date",new Date());

		return "admin/login";
	}

	@PostMapping("/login")
	public String processLogin(@RequestParam String name, @RequestParam String pass, Model map, HttpSession hs,
			@RequestParam String role) {
 
		System.err.println(name + "-----" + pass + "-----" + role);

		System.out.println("in process login form");
		Object v = null;

		try {

			v = obj.validateUser(name, pass, role);

		} catch (NoResultException e4) {
			System.out.println("err in vendor controller " + e4);
			map.addAttribute("status", "Invalid Login , pls retry");
			return "admin/login";

		}
		if (v instanceof Voter) {
			// save validated user dtls under session scope
			hs.setAttribute("Voter_dtls", v);
			hs.setAttribute("role", ((Voter) v).getPersonal().getCredential().getRole());
			hs.setAttribute("status", "Successful Login for " + ((Voter) v).getPersonal().getCredential().getRole());
			System.out.println(((Voter) v).getId().getId());
			hs.setAttribute("Voter_dtls_id", ((Voter) v).getId());

			Election elec = new Election(((Voter) v).getId().getId());

			List<Party> partyList = obj.partyList(elec);
			System.out.println(partyList);
			hs.setAttribute("partyList", partyList);

			List<Location> locList = obj.locList(elec);
			hs.setAttribute("locList", locList);

			List<Candidate> candList = obj.candList(elec);
			hs.setAttribute("candList", candList);

			return "redirect:/admin/voter";
		}
		if (v instanceof Party) {
			// save validated user dtls under session scope
			hs.setAttribute("Party_dtls", v);
			hs.setAttribute("role", ((Party) v).getCredential().getRole());
			hs.setAttribute("status", "Successful Login for " + ((Party) v).getCredential().getRole());
			return "redirect:/admin/party";
		}
		if (v instanceof Candidate) {
			// save validated user dtls under session scope
			hs.setAttribute("Candidate_dtls", v);
			hs.setAttribute("role", ((Candidate) v).getPersonal().getCredential().getRole());
			hs.setAttribute("status",
					"Successful Login for " + ((Candidate) v).getPersonal().getCredential().getRole());
			return "redirect:/admin/candidate";
		}
		if (v instanceof Election) {
			// save validated user dtls under session scope
			hs.setAttribute("user_dtls", v);
			hs.setAttribute("role", ((Election) v).getRole());
			hs.setAttribute("status", "Successful Login for " + ((Election) v).getRole());

			Election elec = new Election(((Election) v).getId());
			List<Party> partyList = obj.partyList(elec);
			System.out.println(partyList);
			hs.setAttribute("partyList", partyList);
			System.out.println("hello" + ((Election) v).getRole());

			List<Location> locList = obj.locList(elec);
			hs.setAttribute("locList", locList);

			List<Candidate> candList = obj.candList(elec);
			hs.setAttribute("candList", candList);
			
			
			List<Voter> voterList =  obj.voterList(elec);
			hs.setAttribute("voterList", voterList);
			
			return "redirect:/admin/election";
			
			
			
			
		}

		// successful login
		// save validated user dtls under session scope
		// hs.setAttribute("user_dtls", v);
		// add status in session scope
		// hs.setAttribute("status", "Successful Login for " + ((Voter)
		// v).getId());

		return "admin/login";
	}

	@GetMapping("/register")
	public String register(Model map,HttpSession hs) {
		System.out.println("in register");

		List<Party> allPartyList = obj.allPartyList();
		System.out.println(allPartyList);
		hs.setAttribute("partyList", allPartyList);
		

		List<Location> allLocList = obj.allLocList();
		hs.setAttribute("locList", allLocList);
//		for()
		System.out.println(allLocList);
		
		List<Election> allElecList = obj.allElecList();
		hs.setAttribute("elecList", allElecList);
		System.out.println(allElecList);
		
		
		return "admin/register";
	}

	@PostMapping("/register")
	public String Processregister(Model map, @RequestParam String role, @RequestParam String name) {
		System.out.println("in register");

		System.out.println(role + "----" + name);
		if (role == "voter") {

		}
		return "admin/register";
	}

	// @PostMapping("/voter")
	// public String ProcessVoterRegister(Model map,@RequestParam String
	// role,@RequestParam String name,@RequestParam int age,@RequestParam String
	// gender,@RequestParam String profession,@RequestParam int
	// locationId,@RequestParam String area,@RequestParam String
	// state,@RequestParam String city,@RequestParam String mobile
	// ,@RequestParam String aadhar,@RequestParam String email,@RequestParam int
	// pincode )
	// {
	// System.out.println("in Voter register");
	//
	// System.out.println(role+"----"+name+"----"+age+"----"+gender+"----"+locationId+"----"+area+"----"+state+"----"+city+"----"+mobile+"----"+aadhar+"----"+email+"----"+pincode+"----"+profession);
	//
	// return "admin/register";
	// }

	// @PostMapping("/candidate")
	// public String ProcessCandidateRegister(Model map,@RequestParam String
	// role,@RequestParam String name,@RequestParam int age,@RequestParam String
	// gender,@RequestParam int locationId,@RequestParam String
	// area,@RequestParam String state,@RequestParam String city,@RequestParam
	// String mobile ,@RequestParam String aadhar,@RequestParam String
	// email,@RequestParam int pincode ,@RequestParam String
	// slogan,@RequestParam List<String> agenda)
	// {
	// System.out.println("in Candidate register");
	//
	// System.out.println(role+"----"+name+"----"+age+"----"+gender+"----"+locationId+"----"+area+"----"+state+"----"+city+"----"+mobile+"----"+aadhar+"----"+email+"----"+pincode+"-----"+slogan+"----"+agenda);
	//
	// return "admin/register";
	// }

	@GetMapping("/createElection")
	public String createElection(Model map) {
		System.out.println("in test");
		// Election e=new Election();

		// System.out.println("in show reg form " + e);
		return "admin/createElection";
	}

	// @PostMapping("/createElection")
	// public String ProcessCreateElection(Model map,@RequestParam String
	// name,@RequestParam int password,@RequestParam int location1,@RequestParam
	// String area1,@RequestParam String city1,@RequestParam String
	// state1,@RequestParam int pincode1,@RequestParam int pLocation1 )
	// {
	// System.out.println("in test..cere");
	//
	// System.out.println(name+"----"+password+"----"+location1+"----"+area1+"----"+city1+"----"+state1+"----"+pincode1+"----"+pLocation1);
	// return "admin/createElection";
	//
	// }

	// @PostMapping("/createElection")
	// public String ProcessCreateElection(Model map,@RequestParam String
	// name,@RequestParam int password )
	// {
	// System.out.println("in test..cere");
	//
	// System.out.println(name+"--------"+password);
	// obj.registerElection(name,password);
	// return "admin/createElection";
	//
	// }

	@PostMapping("/createElection")
	public String ProcessCreateElection(Election e, HttpSession hs) {
		System.out.println("in test..cere");

		System.out.println("in show reg form " + e.getName() + e.getPassword());

		Election elec = new Election(e.getName(), e.getPassword(), "Election");
		obj.registerElection(elec);
		System.out.println("in show reg form " + elec.getName() + elec.getPassword() + elec.getRole());
		hs.setAttribute("regElectionId", elec.getId());
		return "admin/createElection";

	}

	@PostMapping("/voter")
	public String ProcessVoterRegister(Credential c, Detail d, Address a, Authentication at,
			@RequestParam int locationId, @RequestParam int electionId, HttpSession hs) {
		System.out.println("in Voter register");

		// System.out.println(role+"----"+name+"----"+age+"----"+gender+"----"+locationId+"----"+area+"----"+state+"----"+city+"----"+mobile+"----"+aadhar+"----"+email+"----"+pincode+"----"+profession);
		// Credential c=new Credential(role);

		// Voter vo=new Voter();
		System.out.println(c + "------" + d + "------" + a + "------" + at + "---------" + electionId);
		Person p = new Person(c, d, at, a, locationId);
		Election elec = new Election(electionId);
		hs.setAttribute("voterEid", elec);
		Voter v = new Voter(p, elec);
		System.out.println(v);
		obj.registerVoter(v);
		return "admin/rSuccess";
	}

	@PostMapping("/candidate")
	public String ProcessCandidateRegister(HttpSession hs, Credential c, Detail d, Address a, Authentication at,
			@RequestParam int locationId, @RequestParam int partyId, @RequestParam List<String> agenda,
			@RequestParam int electionId) {
		System.out.println("in Candidate register");

		// System.out.println(role+"----"+name+"----"+age+"----"+gender+"----"+locationId+"----"+area+"----"+state+"----"+city+"----"+mobile+"----"+aadhar+"----"+email+"----"+pincode+"----"+profession);
		// Credential c=new Credential(role);

		// Voter vo=new Voter();
		System.out.println(c + "------" + d + "------" + a + "------" + at + "---------" + locationId);
		Person p = new Person(c, d, at, a, locationId);
		Election elec = new Election(electionId);
		hs.setAttribute("candidateEid", elec);
		Candidate cand = new Candidate(agenda,0, p, partyId, elec);
		System.out.println(c);
		obj.registerCandidate(cand);
		return "admin/rSuccess";
	}

	@PostMapping("/party")
	public String ProcessPartyRegister(HttpSession hs, Model map, Credential c, @RequestParam String name,

			@RequestParam String slogan, @RequestParam List<String> agenda, @RequestParam int electionId) {
		System.out.println("in party register");

		// System.out.println(role+"----"+name+"----"+agenda+"----"+area+"----"+state+"----"+city+"----"+mobile+"----"+aadhar+"----"+email+"----"+pincode+"-----"+slogan);

		Election elec = new Election(electionId);
		hs.setAttribute("partyEid", elec);

		Party party = new Party(c, name, agenda, slogan,0, elec);
		obj.registerParty(party);
		return "admin/rSuccess";
	}

	@GetMapping("/election")
	public String electionOptionDisplay(Model map) {
		System.out.println("i m in electionOptionDisplay");

		return "admin/election";

	}

	@GetMapping("/candidate")
	public String candidateOptionDisplay(Model map) {
		System.out.println("i m in candidateOptionDisplay");

		return "admin/candidate";

	}

	@GetMapping("/voter")
	public String voterOptionDisplay(Model map, HttpSession hs) {
		 System.out.println("i m in voterOptionDisplay");
		// Object ob = hs.getAttribute("Voter_dtls_id");
		//// System.out.println(ob);
		 Voter vote=(Voter)  hs.getAttribute("Voter_dtls");
		// System.out.println(vote +"-----"+ vote.get);
		// System.out.println(vote +"-----"+ vote.getId());
		// Voter v=new Voter(vote.getId());
		// List<Party> partyList=obj.partyListForVoter(v);
		// System.out.println(partyList);
		// hs.setAttribute("partyList",partyList );
		//
		//
		// List<Location> locList=obj.locListForVoter(vote);
		// hs.setAttribute("locList",locList );
		//
		 
		 List<Candidate> candList=obj.candListForVoter(vote);
		 hs.setAttribute("candListForVoter",candList );

		return "admin/voter";

	}

	@GetMapping("/party")
	public String partyOptionDisplay(Model map) {
		System.out.println("i m in partyOptionDisplay");

		return "admin/party";

	}

	@GetMapping("/viewProfile")
	public String displayViewProfile(Model map) {
		System.out.println("i m in viewProfile");

		return "admin/viewProfile";

	}

	@GetMapping("/addLocation")
	public String addLocation(Model map) {
		System.out.println("i m in addLocation");

		return "admin/addLocation";

	}

	@PostMapping("/addLocation")
	public String addLocationProcess(Model map, @RequestParam int locationId, @RequestParam int parentLocationId,
			Address a, HttpSession hs) {
		System.out.println("i m in addLocationprocess");
		Election elec = (Election) hs.getAttribute("user_dtls");
		System.out.println(elec + "-----" + elec.getId());
		Election e = new Election(elec.getId());
		Location loc = new Location(locationId, parentLocationId, a, e);
		System.out.println(loc);

		obj.addLocation(loc);
		hs.setAttribute("loc_status", "Location added");
		return "admin/addLocation";

	}

	@GetMapping("/removeLocation")
	public String removeLocation(Model map) {
		System.out.println("i m in removeLocation");

		return "admin/removeLocation";

	}

	@PostMapping("/removeLocation")
	public String removeLocationProcess(Model map, @RequestParam int locationId, HttpSession hs) {
		System.out.println("i m in removeLocationProcess");
		obj.removeLocation(locationId);
		hs.setAttribute("locRem_status", "Location removed");
		return "admin/removeLocation";

	}

	@GetMapping("/candidateList")
	public String displayCandidateList(Model map) {
		System.out.println("i m in displayCandidateList");

		return "admin/candidateList";

	}

	@GetMapping("/partyList")
	public String displayPartyList(Model map) {
		System.out.println("i m in displayPartyList");

		return "admin/partyList";

	}

	@GetMapping("/voting")
	public String votingProcess(Model map, HttpSession hs) {
		System.out.println("i m in votingProcess");
		Voter voter = (Voter) hs.getAttribute("Voter_dtls");
		if (voter.getVotingStatus() == null) {
			Credential credential=new Credential(voter.getPersonal().getCredential().getPassword(),voter.getPersonal().getCredential().getRole());
			Detail detail=new Detail(voter.getPersonal().getDetail().getName(),voter.getPersonal().getDetail().getAge(),voter.getPersonal().getDetail().getGender(),voter.getPersonal().getDetail().getProfession()) ;
			Authentication auth =new Authentication(voter.getPersonal().getAuth().getMobile(),voter.getPersonal().getAuth().getEmail(),voter.getPersonal().getAuth().getAadhar());
			Address address=new Address(voter.getPersonal().getAddress().getArea(),voter.getPersonal().getAddress().getCity(),voter.getPersonal().getAddress().getState(),voter.getPersonal().getAddress().getPincode()) ;
			Integer locationId=voter.getPersonal().getLocationId();
	
		
		Person personal=new Person(credential,detail,auth,address,locationId); 
		Election el=new Election( voter.getId().getId());
		Voter voted=new Voter(true ,personal, voter.geteId() ,el );
		obj.voterVotingStatus(voted);
			
			return "admin/voting";
		
		
		}
		return "admin/voter";

	}

	@PostMapping("/votingDone")
	public String votingDone(Model map, @RequestParam int candidateVoted, HttpSession hs) {
		System.out.println("i m in votingDone");
		Voter voter = (Voter) hs.getAttribute("Voter_dtls");
		
			Candidate cand = (Candidate) obj.fetchCandidate(candidateVoted);

			if (cand.getNumVotes() == null) {
				Candidate candUpVote = new Candidate(cand.getAgenda(), 1, cand.geteId(), cand.getPersonal(),
						cand.getPartyId(), cand.getId());
				obj.candUpVote(candUpVote);
			}

			else {
				Candidate candUpVote = new Candidate(cand.getAgenda(), cand.getNumVotes() + 1, cand.geteId(),
						cand.getPersonal(), cand.getPartyId(), cand.getId());
				obj.candUpVote(candUpVote);
			}
			// System.out.println(candUpVote);
			Party party = obj.fetchParty(cand.getPartyId());
			if (party.getNumVotes() == null) {
				Party partyUpVote = new Party(party.getCredential(), party.getName(), party.getAgenda(),
						party.getAuthStatus(), party.getSlogan(), 1, party.geteId(), party.getId(),
						party.getCandidateId());
				obj.partyUpVote(partyUpVote);
			} else {
				Party partyUpVote = new Party(party.getCredential(), party.getName(), party.getAgenda(),
						party.getAuthStatus(), party.getSlogan(), party.getNumVotes() + 1, party.geteId(),
						party.getId(), party.getCandidateId());
				obj.partyUpVote(partyUpVote);
			}

			hs.setAttribute("votedCandidate", cand);
			Credential credential=new Credential(voter.getPersonal().getCredential().getPassword(),voter.getPersonal().getCredential().getRole());
			Detail detail=new Detail(voter.getPersonal().getDetail().getName(),voter.getPersonal().getDetail().getAge(),voter.getPersonal().getDetail().getGender(),voter.getPersonal().getDetail().getProfession()) ;
			Authentication auth =new Authentication(voter.getPersonal().getAuth().getMobile(),voter.getPersonal().getAuth().getEmail(),voter.getPersonal().getAuth().getAadhar());
			Address address=new Address(voter.getPersonal().getAddress().getArea(),voter.getPersonal().getAddress().getCity(),voter.getPersonal().getAddress().getState(),voter.getPersonal().getAddress().getPincode()) ;
			Integer locationId=voter.getPersonal().getLocationId();
	
		
		Person personal=new Person(credential,detail,auth,address,locationId); 
		Election el=new Election( voter.getId().getId());
		Voter voted=new Voter(true ,personal, voter.geteId() ,el );
		obj.voterVotingStatus(voted);
		
		
//		else
//		{	  
//			return "admin/voter";
//			
//		}
		return "admin/votingDone";

	}

	@GetMapping("/viewResult")
	public String viewResultDisplay(Model map, HttpSession hs) {
		System.out.println("i m in votingProcess");
		Voter voter = (Voter) hs.getAttribute("Voter_dtls");
		Candidate cand = obj.winningCandidate(voter.getId().getId(), voter.getPersonal().getLocationId());
		hs.setAttribute("Winning_Candidate_dtls", cand);
		return "admin/viewResult";

	}

	@GetMapping("/updateProfile")
	public String updateProfile(Model map, HttpSession hs) {
		System.out.println("i m in updateProfile");

		return "admin/updateProfile";

	}
	
	@GetMapping("/sendEmail")
	public String sendEmail(Model map, HttpSession hs) {
		System.out.println("i m in sendEmail");
		@SuppressWarnings("unchecked")
		List<Voter> voterList= (List<Voter>) hs.getAttribute("voterList");
		System.out.println(voterList);
		for(Voter v : voterList)
		{
			SendMail.send(v.getPersonal().getAuth().getEmail());
		}
		return "admin/sendEmail";

	}

}
