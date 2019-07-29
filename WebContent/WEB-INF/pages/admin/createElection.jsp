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
            input{padding: 5px;}
        </style>
    </head>
    <body>
        <div class="container col-xs-12 col-md-4 col-md-offset-4">
            <h2>Election Setup</h2>
            <form method="post" class="form modal-content">
                <div class="col-xs-12">
                    <input type="text" id="name" class="name col-xs-12" name="name" placeholder="Name">
                </div>
                
                <div class="col-xs-12">&nbsp;</div>
                
                <div class="col-xs-12">
                    <input type="password" id="password" min="3" max="8" class="password col-xs-12" name="password" placeholder="Password">
                </div>
                <div class="col-xs-12">&nbsp;</div>
                
                    
              
                <div class="col-xs-12">
                    <input type="submit" value="Submit Election Details" class="btn btn-primary col-xs-12">
                </div>
            </form>
            <div class="col-xs-12">&nbsp;</div>
            <div id="result" name="result">
                Election ID: ${sessionScope.regElectionId}
            </div>
        </div>
    </body>

</html>