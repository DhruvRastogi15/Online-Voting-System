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
            #user1, #user2{display: none;}
            #user3 {display: block;}
        </style>
        <script>

        </script>
    </head>
    <body>
        <div id="election_container" class="election_container container col-xs-12 col-md-8 col-md-offset-2">
            <h3>Vote a candidate</h3>
            <div class="col-xs-3">Name</div>
            <div class="col-xs-9">${sessionScope.Voter_dtls.personal.detail.name}</div>
            <div class="col-xs-12">&nbsp;</div>
            <div class="location_list col-xs-12" id="location_list" name="location_list"></div>
            <div class="col-xs-12">&nbsp;</div>
            
                <table class="table">
                <tr>
                	<td>Name</td>
                	<td>Location ID</td>
                	<td>Candidate ID</td>
                	<td>Party ID</td>
                </tr>
		          <c:forEach var="c" items="${sessionScope.candListForVoter}">
                    <tr>
				       <td>${c.personal.detail.name}</td>
						<td>${c.personal.locationId}</td>
						<td>${c.eId}</td>
						<td>${c.partyId}</td>
                        <td>
                            <form method="post" action="votingDone">
                                <input type="hidden" name="candidateVoted" value=${c.eId}>
                                <input class="btn btn-primary" type="submit" value="Vote">
                            </form>
                        </td>
                    </tr>
		          </c:forEach>
	           </table>
            <div class="col-xs-12">&nbsp;</div>
        </div>
    </body>
</html>