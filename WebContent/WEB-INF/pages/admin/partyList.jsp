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
            
        </script>
    </head>
    <body>
        <div class="container col-xs-12 text-center">
            <h3>Party List</h3>
            <div class="col-xs-12">&nbsp;</div>
            <div class="col-xs-12 col-md-6 col-md-offset-3 form modal-content">
                   <table class="table">
                   <tr style="font-weight: bold;">
                   	<td>Name</td>
                   	<td>Slogan</td>
                   	<td>Location ID</td>
                   </tr>
		<c:forEach var="v" items="${sessionScope.partyList}">
			<tr>
				<td>${v.name}</td>
				<td>${v.slogan}</td>
				<td>${v.eId}</td>
			</tr>
		</c:forEach>
	</table>
            </div>
        </div>
    </body>
</html>