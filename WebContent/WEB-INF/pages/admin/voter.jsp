<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
            	var vStatus = document.getElementById("vStatus").value;
            	if(vStatus)
            		document.getElementById("vote").innerHTML = '<a href="" class="btn btn-primary col-xs-12" id="vote">Already Voted</a>';
            }window.onload=init;
        </script>
    </head>
    <body>
    <h3 align="center">${sessionScope.user_dtls.personal.credential.role}</h3>
    <h3 align="center">${sessionScope.role}</h3> 
        <div id="menu" class="menu col-xs-12">
            <div class="col-xs-5 col-md-2 col-md-offset-4 col-xs-offset-1">
                <a href="voter.html" class="col-xs-12 btn btn-primary">Home</a>
            </div>
            <div class="col-xs-5 col-md-2">
                <a href="logout.html" class="col-xs-12 btn btn-primary">Logout</a>
            </div>
        </div>
        <div class="container col-xs-12 text-center">
            <h3>Voter Home</h3>
            <input type="hidden" id="vStatus" value=${sessionScope.Voter_dtls.votingStatus}>
            <div class="form modal-content  col-sm-offset-4 col-sm-4 col-xs-12">
                <a href="viewProfile" class="btn btn-primary col-xs-12">View Profile</a>
                <div class="col-xs-12">&nbsp;</div>
                <a href="updateProfile" class="btn btn-primary col-xs-12">Update Profile</a>
                <div class="col-xs-12">&nbsp;</div>
                <a href="partyList" class="btn btn-primary col-xs-12">View Party List</a>
                <div class="col-xs-12">&nbsp;</div>
                <a href="candidateList" class="btn btn-primary col-xs-12">View Candidate List</a>
                <div class="col-xs-12">&nbsp;</div>
                <a href="viewSchedule" class="btn btn-primary col-xs-12">View Schedule</a>
                <div class="col-xs-12">&nbsp;</div>
                <div id="vote"><a href="voting" class="btn btn-primary col-xs-12">Vote</a></div>
                <div class="col-xs-12">&nbsp;</div>
                <a href="viewResult" class="btn btn-primary col-xs-12">View Result</a>
            </div>
        </div>
    </body>
</html>