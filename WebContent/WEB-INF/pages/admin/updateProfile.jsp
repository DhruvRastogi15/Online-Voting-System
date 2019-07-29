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
            input[type="text"], input[type="email"], input[type="number"], selop {height: 40px;}
            #user1, #user2{display: none;}
            #user3 {display: block;}
            .form {padding: 25px;}
            #captcha input {height: 30px; width: 30px; font-weight: bold;}
            #num1, #num2, #num3 {text-align: center;}
        </style>
        <script>
            function showParty(elementId) {
                var role = document.getElementById("roleParty");
                var selection = role.options[role.selectedIndex];
                for(i=1;i<=3;i++){
                    if(selection.value==document.getElementById("o"+i).value)
                        document.getElementById("user"+i).style.display="block";
                    else
                        document.getElementById("user"+i).style.display="none";
                }
            }
            function showCandidate(elementId) {
                var role = document.getElementById("roleCandidate");
                var selection = role.options[role.selectedIndex];
                for(i=1;i<=3;i++){
                    if(selection.value==document.getElementById("o"+i).value)
                        document.getElementById("user"+i).style.display="block";
                    else
                        document.getElementById("user"+i).style.display="none";
                }
            }
            function showVoter(elementId) {
                var role = document.getElementById("roleVoter");
                var selection = role.options[role.selectedIndex];
                for(i=1;i<=3;i++){
                    if(selection.value==document.getElementById("o"+i).value)
                        document.getElementById("user"+i).style.display="block";
                    else
                        document.getElementById("user"+i).style.display="none";
                }
            }
            function addAgendaParty(){
                document.getElementById("agenda-container-party").innerHTML += '<input type="text" id="agenda" name="agenda" placeholder="Agenda" class="agenda col-xs-8">';
            }
            function addAgendaCandidate(){
                document.getElementById("agenda-container-candidate").innerHTML += '<input type="text" id="agenda" name="agenda" placeholder="Agenda" class="agenda col-xs-8">';
            }
            function check(){
                var num1 = document.getElementById("num1");
                var num2 = document.getElementById("num2");
                var num3 = document.getElementById("num3").value;
                var num4 = document.getElementById("num4");
                var num5 = document.getElementById("num5");
                var num6 = document.getElementById("num6").value;
                var num7 = document.getElementById("num7");
                var num8 = document.getElementById("num8");
                var num9 = document.getElementById("num9").value;
                var val1 = parseInt(num1.value) + parseInt(num2.value);
                var val2 = parseInt(num4.value) + parseInt(num5.value);
                var val3 = parseInt(num7.value) + parseInt(num8.value);
                if(val1 == num3)
                    document.getElementById("sub1").removeAttribute("disabled");
                else
                    document.getElementById("sub1").disabled = "true";
                if(val2 == num6)
                    document.getElementById("sub2").removeAttribute("disabled");
                else
                    document.getElementById("sub2").disabled = "true";
                if(val3 == num9)
                    document.getElementById("sub3").removeAttribute("disabled");
                else
                    document.getElementById("sub3").disabled = "true";
            }
            function init(){
                var num1 = document.getElementById("num1");
                var num2 = document.getElementById("num2");
                num1.value = Math.floor(10 * Math.random());
                num2.value = Math.floor(10 * Math.random());
                
                var num4 = document.getElementById("num4");
                var num5 = document.getElementById("num5");
                num4.value = Math.floor(10 * Math.random());
                num5.value = Math.floor(10 * Math.random());
                
                var num7 = document.getElementById("num7");
                var num8 = document.getElementById("num8");
                num7.value = Math.floor(10 * Math.random());
                num8.value = Math.floor(10 * Math.random());
            }window.onload = init;
        </script>
    </head>
    <body>
        <div class="container text-center form-group">
            <div id="user1">
                <h3>Party Updation Form</h3>
                <form method="post" action="party" class="form modal-content  col-sm-offset-4 col-sm-4 col-xs-12">
                    <label class="control-label col-xs-2" for="company">Role:</label>
                    <div class="col-xs-9 col-xs-offset-1">
                        <select id="roleParty" name="role" class="selop form-control" onchange="showParty(this)">
                            <option id="o1"   selected class="selop form-control">Party</option>
                            <option id="o2" class="selop form-control" >Candidate</option>
                            <option id="o3" class="selop form-control">Voter</option>
                        </select>
                    </div>
                    
                    <input type="text" id="name" name="name" placeholder="name" class="name form-control col-xs-12">
                     <input type="password" id="password" name="password" placeholder="Password" class="name form-control col-xs-12">
                     <input type="number" id="election" name="electionId" placeholder="ElectionId" class="election form-control col-xs-12">   
                    
                    <label class="form-control col-xs-12 btn">Enter Address: </label>
                            
                    <input type="text" id="area" name="area" placeholder="Area" class="area form-control col-xs-12">
                            
                    <input type="text" id="city" name="city" placeholder="City" class="city col-xs-4">
                            
                    <input type="text" id="state" name="state" placeholder="State" class="state col-xs-4">
                            
                    <input type="number" id="pincode" name="pincode" placeholder="Pincode" class="pincode col-xs-4">
                            
                    <input type="text" id="mobile" name="mobile" placeholder="Mobile" class="mobile col-xs-4">
                            
                    <input type="email" id="email" name="email" placeholder="Email" class="email col-xs-4">
                            
                    <input type="text" id="aadhar" name="aadhar" placeholder="Aadhar" class="aadhar col-xs-4">
                            
                    <input type="text" id="slogan" name="slogan" placeholder="Slogan" class="slogan col-xs-12">
                            
                    <div id="agenda-container-party">
                        <input type="text" id="agendaParty" name="agenda" placeholder="Agenda" class="agenda col-xs-8">
                    </div>
                                
                    <input type="button" value="Add agenda" class="btn col-xs-4 input-sm" onclick="addAgendaParty()">
                            
                    <div class="col-xs-12 col-sm-4 col-sm-offset-4 btn" id="captcha">
                        <input type="number" id="num1" disabled>
                        <span>&nbsp;&nbsp;+&nbsp;&nbsp;</span>
                        <input type="number" id="num2" disabled>
                        <span>&nbsp;&nbsp;=&nbsp;&nbsp;</span>
                        <input type="text" id="num3" placeholder="?" onkeyup="check()">
                    </div>
                    
                    <input type="submit" id="sub1" value="Submit" class="btn btn-primary col-xs-12" disabled>
                </form>
            </div>
                    
            <div id="user2"> 
                <h3>Candidate Updation Form</h3>
                <form method="post" action="candidate"  class="form modal-content  col-sm-offset-4 col-sm-4 col-xs-12">
                    <label class="control-label col-xs-2" for="company">Role:</label>
                    <div class="col-xs-9 col-xs-offset-1">
                        <select id="roleCandidate" name="role" class="form-control" onchange="showCandidate(this)">
                            <option id="o1">Party</option>
                            <option id="o2" selected>Candidate</option>
                            <option id="o3">Voter</option>
                        </select>
                    </div>
                    
                    <input type="text" id="name" name="name" placeholder="name" class="name form-control col-xs-12" ">
                      <input type="password" id="password" name="password" placeholder="Password" class="name form-control col-xs-12">   
                    <input type="number" id="age" name="age" placeholder="Age" class="age form-control col-xs-12">
                        
                    <label><input type="radio" name="gender">Male</label>
                        
                    <label><input type="radio" name="gender">Female</label>
                       <input type="text" id="profession" name="profession" placeholder="Profession" class="profession form-control col-xs-12">  
                    <input type="text" id="location" name="locationId" placeholder="Location" class="location form-control col-xs-12">
                    <input type="number" id="election" name="electionId" placeholder="ElectionId" class="election form-control col-xs-12">   
                        
                    <label class="form-control col-xs-12 btn">Enter Address: </label>
                        
                    <input type="text" id="area" name="area" placeholder="Area" class="area form-control col-xs-12">
                        
                    <input type="text" id="city" name="city" placeholder="City" class="city col-xs-4">
                        
                    <input type="text" id="state" name="state" placeholder="State" class="state col-xs-4">
                        
                    <input type="number" id="pincode" name="pincode" placeholder="Pincode" class="pincode col-xs-4">
                        
                    <input type="text" id="mobile" name="mobile" placeholder="Mobile" class="mobile col-xs-4">
                        
                    <input type="email" id="email" name="email" placeholder="Email" class="email col-xs-4">
                        
                    <input type="text" id="aadhar" name="aadhar" placeholder="Aadhar" class="aadhar col-xs-4">
                        
                    <input type="number" id="partyId" name="partyId" placeholder="PartyId" class="slogan col-xs-12">
                        
                    <div id="agenda-container-candidate">
                            <input type="text" id="agendaCandidate" name="agenda" placeholder="Agenda" class="agenda col-xs-8">
                    </div>
                            
                    <input type="button" value="Add agenda" class="btn col-xs-4 input-sm" onclick="addAgendaCandidate()">
                        
                    <div class="col-xs-12 col-sm-4 col-sm-offset-4 btn" id="captcha">
                        <input type="number" id="num4" disabled>
                        <span>&nbsp;&nbsp;+&nbsp;&nbsp;</span>
                        <input type="number" id="num5" disabled>
                        <span>&nbsp;&nbsp;=&nbsp;&nbsp;</span>
                        <input type="text" id="num6" placeholder="?" onkeyup="check()">
                    </div>
                    
                    <input type="submit" id="sub2" value="Submit" class="btn btn-primary col-xs-12" disabled>
                </form>
            </div>
            <div id="user3">
                <h3>Voter Updation Form</h3>
                <form method="post" action="voter" class="form modal-content  col-sm-offset-4 col-sm-4 col-xs-12">
                    <label class="control-label col-xs-2" for="company">Role:</label>
                    <div class="col-xs-9 col-xs-offset-1">
                        <select id="roleVoter" class="form-control" name="role" onchange="showVoter(this)">
                            <option id="o1">Party</option>
                            <option id="o2">Candidate</option>
                            <option id="o3" selected>Voter</option>
                        </select>
                    </div>
                    
                    <input type="text" id="name" name="name" placeholder="name" class="name form-control col-xs-12" value="${sessionScope.Voter_dtls.personal.detail.name}">
                       <input type="password" id="password" name="password" placeholder="Password" class="name form-control col-xs-12">  
                    <input type="number" id="age" name="age" placeholder="Age" class="age form-control col-xs-12">
                        
                    <label><input type="radio" name="gender" value="male">Male</label>
                        
                    <label><input type="radio" name="gender" value="female">Female</label>
                        
                    <input type="text" id="profession" name="profession" placeholder="Profession" class="profession form-control col-xs-12">
                        
                    <input type="number" id="location" name="locationId" placeholder="LocationId" class="location form-control col-xs-12">
                      <input type="number" id="election" name="electionId" placeholder="ElectionId" class="election form-control col-xs-12">   
                    <label class="form-control col-xs-12 btn">Enter Address: </label>
                        
                    <input type="text" id="area" name="area" placeholder="Area" class="area form-control col-xs-12">
                        
                    <input type="text" id="city" name="city" placeholder="City" class="city col-xs-4">
                        
                    <input type="text" id="state" name="state" placeholder="State" class="state col-xs-4">
                        
                    <input type="number" id="pincode" name="pincode" placeholder="Pincode" class="pincode col-xs-4">
                        
                    <input type="text" id="mobile" name="mobile" placeholder="Mobile" class="mobile col-xs-4">
                        
                    <input type="email" id="email" name="email" placeholder="Email" class="email col-xs-4">
                        
                    <input type="text" id="aadhar" name="aadhar" placeholder="Aadhar" class="aadhar col-xs-4">
                        
                    <div class="col-xs-12 col-sm-4 col-sm-offset-4 btn" id="captcha">
                        <input type="number" id="num7" disabled>
                        <span>&nbsp;&nbsp;+&nbsp;&nbsp;</span>
                        <input type="number" id="num8" disabled>
                        <span>&nbsp;&nbsp;=&nbsp;&nbsp;</span>
                        <input type="text" id="num9" placeholder="?" onkeyup="check()">
                    </div>
                    <input type="submit" id="sub3" value="Submit" class="btn btn-primary col-xs-12" disabled>
                </form>
            </div>
        </div>
    </body>
</html>