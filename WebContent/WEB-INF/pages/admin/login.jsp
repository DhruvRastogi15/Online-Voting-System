<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Remote Election System</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <style>
            <%@include file="style/style1.css" %>
        </style>
        <script>
            function check(){
                var num1 = document.getElementById("num1");
                var num2 = document.getElementById("num2");
                var num3 = document.getElementById("num3").value;
                var num4 = parseInt(num1.value) + parseInt(num2.value);
                if(num4 == num3)
                    document.getElementById("sub").removeAttribute("disabled");
                else
                    document.getElementById("sub").disabled = "true";
            }
            function init(){
                var num1 = document.getElementById("num1");
                var num2 = document.getElementById("num2");
                num1.value = Math.floor(10 * Math.random());
                num2.value = Math.floor(10 * Math.random());
            }window.onload = init;
        </script>
    </head>
    <body><h3 align="center">${SessionScope.status}</h3>
        <div class="container text-center ">
            <h3>Remote Election System</h3>
            <form class="form modal-content  col-sm-offset-4 col-sm-4 col-xs-12" method="post">
                <h2>Login Form</h2>
            	<select name="role" class="col-xs-8 col-xs-offset-2">
            		<option value="Election">Election</option>
            		<option value="Party">Party</option>
            		<option value="Candidate">Candidate</option>
            		<option value="Voter" selected>Voter</option>
            	</select>
                <div class="col-xs-12">&nbsp;</div>
                <input type="text" id="name" class="name col-xs-8 col-xs-offset-2" name="name" placeholder="Name"><br><br>
                <div class="col-xs-12">&nbsp;</div>
                <input type="password" id="pass" class="pass col-xs-8 col-xs-offset-2" name="pass" placeholder="Password"><br><br>
                <div class="col-xs-12">&nbsp;</div>
                <div class="col-xs-12 col-sm-4 col-sm-offset-4 btn" id="captcha">
                    <input type="number" id="num1" disabled>
                    <span>&nbsp;&nbsp;+&nbsp;&nbsp;</span>
                    <input type="number" id="num2" disabled>
                    <span>&nbsp;&nbsp;=&nbsp;&nbsp;</span>
                    <input type="text" id="num3" placeholder="?" onkeyup="check()">
                </div>
                <input type="submit" id="sub" value="Login" class="btn btn-primary col-xs-8 col-xs-offset-2" disabled>
                <span class="psw"><a href="#" class="btn col-xs-8 col-xs-offset-2">Forget Password?</a></span>
            </form>
        </div>
    </body>
</html>