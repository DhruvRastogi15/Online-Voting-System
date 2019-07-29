<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Remote Election System</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
<%@include file="/WEB-INF/pages/admin/style/style1.css" %>
</style>
</head>
<body>
	<div class="container col-xs-12 text-center">
            <h3>Remote Election System</h3>
            <div class="form modal-content  col-sm-offset-4 col-sm-4 col-xs-12">
            <div class="col-sm-8 col-sm-offset-2">
            	<div class="col-xs-12">Registration Successful!</div>
                <a href="createElection" class="btn btn-primary col-xs-12">Setup Election</a>
                <div class="col-xs-12">&nbsp;</div>
                <a href="register" class="btn btn-primary col-xs-12">Register</a>
                <div class="col-xs-12">&nbsp;</div>
                <a href="login" class="btn btn-primary col-xs-12">Login</a>
            </div>
            </div>
        </div>
</body>
</html>