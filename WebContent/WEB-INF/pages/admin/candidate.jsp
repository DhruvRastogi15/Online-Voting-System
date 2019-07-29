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

        </style>
        <script>
            
        </script>
    </head>
    <body>
     <h3 align="center">${sessionScope.status}</h3>
        <div class="container col-xs-12 text-center col-md-4 col-md-offset-4">
            <h3>Candidate Home</h3>
            <a href="viewProfile" class="btn btn-primary col-xs-12">View Profile</a>
            <div class="col-xs-12">&nbsp;</div>
            <a href="update_profile.html" class="btn btn-primary col-xs-12">Update Profile</a>
            <div class="col-xs-12">&nbsp;</div>
            <a href="view_party_list.html" class="btn btn-primary col-xs-12">View Party List</a>
            <div class="col-xs-12">&nbsp;</div>
            <a href="view_candidate_list.html" class="btn btn-primary col-xs-12">View Candidate List</a>
            <div class="col-xs-12">&nbsp;</div>
            <a href="view_party_candidate_list.html" class="btn btn-primary col-xs-12">View Party Candidate List</a>
            <div class="col-xs-12">&nbsp;</div>
            <a href="view_schedule.html" class="btn btn-primary col-xs-12">View Schedule</a>
            <div class="col-xs-12">&nbsp;</div>
            <a href="view_result.html" class="btn btn-primary col-xs-12">View Result</a>
        </div>
    </body>
</html>