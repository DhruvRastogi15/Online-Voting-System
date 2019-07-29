<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Remote Election System</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <style>
            <%@include file="style/style1.css" %>
        </style>
        <script>
		function init(){
            var role = document.getElementById("sessionRole").value; // get the value of role here from java session
            //document.write(role);
            var candidateContainer = document.getElementById("candidate_container");
            var partyContainer = document.getElementById("party_container");
            var voterContainer = document.getElementById("voter_container");
            var electionContainer = document.getElementById("election_container")
			if(role == "Voter"){
				candidateContainer.style.display="none";
				partyContainer.style.display="none";
				voterContainer.style.display="block";
                electionContainer.style.display="none";
			}
			else if(role == "Candidate"){
				candidateContainer.style.display="block";
				partyContainer.style.display="none";
				voterContainer.style.display="none";
                electionContainer.style.display="none";
			}
			else if(role == "Party"){
				candidateContainer.style.display="none";
				partyContainer.style.display="block";
				voterContainer.style.display="none";
                electionContainer.style.display="none";
			}
            else if(role == "Election"){
				candidateContainer.style.display="none";
				partyContainer.style.display="none";
				voterContainer.style.display="none";
                electionContainer.style.display="block";
			}
            //else
                //window.location = "login.html";
		}window.onload=init;
        </script>
    </head>
    <body>
        <input type="hidden" id="sessionRole" name="sessionRole" value="${sessionScope.role}">
        <div id="candidate_container" class="candidate_container container">
            <h3 class="text-center col-xs-12 col-md-4 col-md-offset-4">Candidate Profile</h3>
            <div class="form modal-content  col-sm-offset-4 col-sm-4 col-xs-12">
                
                <div class="col-xs-4">Name:</div>
                <div class="col-xs-7 col-xs-offset-1">Name goes here</div>
                <div class="col-xs-12">&nbsp;</div>
            
                <div class="col-xs-4">Age:</div>
                <div class="col-xs-7 col-xs-offset-1">Age goes here</div>
                <div class="col-xs-12">&nbsp;</div>
            
                <div class="col-xs-4">Gender:</div>
                <div class="col-xs-7 col-xs-offset-1">Gender goes here</div>
                <div class="col-xs-12">&nbsp;</div>
            
                <div class="col-xs-4">Location:</div>
                <div class="col-xs-7 col-xs-offset-1">Location goes here</div>
                <div class="col-xs-12">&nbsp;</div>
            
                <div class="col-xs-4">Email:</div>
                <div class="col-xs-7 col-xs-offset-1">Email goes here</div>
                <div class="col-xs-12">&nbsp;</div>
            
                <div class="col-xs-4">Mobile No.:</div>
                <div class="col-xs-7 col-xs-offset-1">Mobile goes here</div>
                <div class="col-xs-12">&nbsp;</div>
            
                <div class="col-xs-4">Aadhar No.:</div>
                <div class="col-xs-7 col-xs-offset-1">Aadhar goes here</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-12">Party Candidates</div>
                <div class="col-xs-12">List of Candidates goes here</div>
                <div class="col-xs-12">&nbsp;</div>
            
                <div class="col-xs-12">Agenda</div>
                <div class="col-xs-12">List of agenda goes here</div>
                <div class="col-xs-12">&nbsp;</div>
            </div>
        </div>
        
        <div id="party_container" class="party_container container">
            <h3 class="text-center col-xs-12 col-md-4 col-md-offset-4">Party Profile</h3>
            <div class="form modal-content  col-sm-offset-4 col-sm-4 col-xs-12">
                <div class="col-xs-4">Name:</div>
                <div class="col-xs-7 col-xs-offset-1">Name goes here</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-4">Email:</div>
                <div class="col-xs-7 col-xs-offset-1">Email goes here</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-4">Mobile No.:</div>
                <div class="col-xs-7 col-xs-offset-1">Mobile goes here</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-4">Symbol:</div>
                <div class="col-xs-7 col-xs-offset-1">Symbol goes here</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-4">Slogan:</div>
                <div class="col-xs-7 col-xs-offset-1">Slogan goes here</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-12">Party Candidates</div>
                <div class="col-xs-12">List of Candidates goes here</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-12">Agenda</div>
                <div class="col-xs-12">List of agenda goes here</div>
                <div class="col-xs-12">&nbsp;</div>
            </div>
        </div>
        
        <div id="voter_container" class="voter_container container">
            <h3 class="text-center col-xs-12 col-md-4 col-md-offset-4">Voter Profile</h3>
            <div class="form modal-content  col-sm-offset-4 col-sm-4 col-xs-12">
                <div class="col-xs-4">Name:</div>
                <div class="col-xs-7 col-xs-offset-1">${sessionScope.Voter_dtls.personal.detail.name}</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-4">Age:</div>
                <div class="col-xs-7 col-xs-offset-1">${sessionScope.Voter_dtls.personal.detail.age}</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-4">Gender:</div>
                <div class="col-xs-7 col-xs-offset-1">${sessionScope.Voter_dtls.personal.detail.gender}</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-4">Location:</div>
                <div class="col-xs-7 col-xs-offset-1">${sessionScope.Voter_dtls.personal.locationId}</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-4">Email:</div>
                <div class="col-xs-7 col-xs-offset-1">${sessionScope.Voter_dtls.personal.auth.email}</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-4">Mobile No.:</div>
                <div class="col-xs-7 col-xs-offset-1">${sessionScope.Voter_dtls.personal.auth.mobile}</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-4">Aadhar No.:</div>
                <div class="col-xs-7 col-xs-offset-1">${sessionScope.Voter_dtls.personal.auth.aadhar}</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-4">Address:</div>
                <div class="col-xs-7 col-xs-offset-1">${sessionScope.Voter_dtls.personal.address.area}</div>
                <div class="col-xs-12">&nbsp;</div>
            </div>
        </div>
        
        <div id="election_container" class="election_container container">
            <h3 class="text-center col-xs-12 col-md-4 col-md-offset-4">Election Profile</h3>
            <div class="form modal-content col-sm-offset-4 col-sm-4 col-xs-12">
                <div class="col-xs-4">Name:</div>
                <div class="col-xs-7 col-xs-offset-1">${sessionScope.user_dtls.name}</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="location_list col-xs-12" id="location_list">Location List goes here</div>
                <div class="col-xs-12">&nbsp;</div>
                
                <table style="background-color: cyan; margin: auto;" border="1">
                    <c:forEach var="v" items="${sessionScope.partyList}">
                        <tr>
                            <td>${v.name}</td>
                            <td>${v.slogan}</td>
                            <td>${v.credential}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-xs-12">&nbsp;</div>
        </div>
    </body>
</html>