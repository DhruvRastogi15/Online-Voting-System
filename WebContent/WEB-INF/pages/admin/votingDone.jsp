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

        </style>
        <script>
            
        </script>
    </head>
    <body>
        <div class="voted col-xs-12 text-center">
            Voted Successfully to 
        </div>
       		 <div class="col-xs-3">Name</div>
           	 <div class="col-xs-9">${sessionScope.votedCandidate.personal.detail.name}</div>
           	 <div class="col-xs-3">Party --ID</div>
           	  <div class="col-xs-12">&nbsp;</div>
             <div class="col-xs-9">${sessionScope.votedCandidate.partyId}</div>
    </body>
</html>