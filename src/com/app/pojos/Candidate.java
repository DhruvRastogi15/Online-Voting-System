package com.app.pojos;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name ="candidate")
public class Candidate  {

		private List<String> agenda;
		private Integer numVotes;
		private Integer eId;
		private Person personal;
		private Integer partyId;
		private Election id;
		




		public Candidate() {
			super();
		}
		
		
		
		public Candidate(List<String> agenda, Integer numVotes, Integer eId, Person personal, Integer partyId,
				Election id) {
			super();
			this.agenda = agenda;
			this.numVotes = numVotes;
			this.eId = eId;
			this.personal = personal;
			this.partyId = partyId;
			this.id = id;
		}

		

		public Candidate(List<String> agenda, Integer numVotes, Person personal, Integer partyId, Election id) {
			super();
			this.agenda = agenda;
			this.numVotes = numVotes;
			this.personal = personal;
			this.partyId = partyId;
			this.id = id;
		}



		public Candidate(List<String> agenda, Person personal, Integer partyId, Election id) {
			super();
			this.agenda = agenda;
			this.personal = personal;
			this.partyId = partyId;
			this.id = id;
		}



		public Candidate( Integer partyId,List<String> agenda, Person personal) {
			super();
			this.agenda = agenda;
			this.partyId=partyId;
			
			this.personal = personal;
		}



		@Override
		public String toString() {
			return "Candidate [agenda=" + agenda + ", numVotes=" + numVotes + ", personal=" + personal + "]";
		}
		



		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Integer geteId() {
			return eId;
		}



		public void seteId(Integer eId) {
			this.eId = eId;
		}
	


		@ElementCollection(fetch = FetchType.EAGER)
		public List<String> getAgenda() {
			return agenda;
		}



		public void setAgenda(List<String> agenda) {
			this.agenda = agenda;
		}


		@Column
		public Integer getNumVotes() {
			return numVotes;
		}



		public void setNumVotes(Integer numVotes) {
			this.numVotes = numVotes;
		}


		@Column
		public Person getPersonal() {
			return personal;
		}



		public void setPersonal(Person personal) {
			this.personal = personal;
		}

		@Column
		public Integer getPartyId() {
			return partyId;
		}



		public void setPartyId(Integer partyId) {
			this.partyId = partyId;
		}



		@ManyToOne
		public Election getId() {
			return id;
		}



		public void setId(Election id) {
			this.id = id;
		}
		
		
		
}
