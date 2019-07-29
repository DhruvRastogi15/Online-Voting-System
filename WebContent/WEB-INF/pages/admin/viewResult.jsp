<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Remote Election System</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <style>
            #vote_distribution{display: none;}
            #myChart{width: 400px; height: 400px;}
            .form {padding: 10px;}
        </style>
        <script>
            function showResult(){
                document.getElementById("result").className="btn btn-basic";
                document.getElementById("distribution").className="btn btn-default";
                document.getElementById("result_container").style.display="block";
                document.getElementById("vote_distribution").style.display="none";
            }
            function showDistribution(){
                document.getElementById("result").className="btn btn-default";
                document.getElementById("distribution").className="btn btn-basic";
                document.getElementById("result_container").style.display="none";
                document.getElementById("vote_distribution").style.display="block";
            }
        </script>
    </head>
    <body>
        <div class="container col-xs-12 col-md-8 col-md-offset-2">
            <div id="menu" class="menu" name="menu col-xs-12 text-center">
                <input type="button" id="result" class="btn btn-basic" value="Result" onclick="showResult()">
                <input type="button" id="distribution" class="btn btn-default" value="Vote Distribution" onclick="showDistribution()">
            </div>
            <div class="col-xs-12">&nbsp;</div>
            <div id="result_container">
               <table class="table">
		         
                    <tr>
                    	<td>Winner from your location is: </td>
				        <td>${sessionScope.Winning_Candidate_dtls.personal.detail.name}</td>
				        <td>${sessionScope.Winning_Candidate_dtls.personal.locationId}</td>
				        <td>${sessionScope.Winning_Candidate_dtls.partyId}</td>
                    </tr>
		          
	           </table>
            </div>
            <div id="vote_distribution">
                <h3 class="text-center col-xs-12">Election Result</h3>
            <div id="chartContainer" class="col-md-8 col-md-offset-2 col-xs-12"></div>
            </div>
            </div>
                <script>
            // div element to contain canvas elements
            var chartContainer = document.getElementById("chartContainer");
            
            // winningCandidate is broken into 3 array. elements at same index together are properties of one candidate object
//             var candidate = ["arnav", "kumar", "ashutosh", "sharma", "ayush", "bansal", "gupta", "sorabh", "tomar", "harsh", "vardhan", "amit", "anjit", "abhishek", "rvind", "abhinav", "tarunav", "pranav", "jainav"];
//             var loc = ["loc1", "loc2", "loc3", "loc2", "loc2", "loc1", "loc3", "loc1", "loc2", "loc2","loc4", "loc5", "loc5", "loc4", "loc1", "loc4","loc4","loc4","loc5"];
//             var numVotes = [40, 30, 70, 100, 120, 34, 44, 94, 45, 130, 111, 222, 121, 233, 111, 322, 222, 232, 199];
            
            var i=0;
            var candidate=[];
            var loc=[];
            var numVotes=[];
            
    		<c:forEach var="c" items="${sessionScope.candList}">
    			
    			candidate[i]="${c.personal.detail.name}";
    				loc[i]=${c.personal.locationId};

    				numVotes[i]=${c.numVotes};
    			i++;
    		
    		</c:forEach>
    		
    		
            // created an array on location without repeatation
            var locationArray = [];     // holds non repeatable location list
            locationArray[0] = loc[0];
            var flag = false;
            for(i=0; i<=loc.length; i++){
                for(j=0; j<=locationArray.length; j++){
                    if(loc[i] == locationArray[j])
                        flag = true;
                }
                if(flag == false){
                    locationArray[locationArray.length] = loc[i];
                }
                else
                    flag = false;
            }
            
            // inserted canvas elements one for each location into a div container named chartContainer
            for(i=0; i<=locationArray.length-1; i++){
                chartContainer.innerHTML += '<canvas id="myChart'+i+'"></canvas>';
            }
            
            // got the canvas elements
            var ctx = [];
            for(i=0; i<=locationArray.length-1; i++){
                ctx[i] = document.getElementById('myChart'+i);
            }
            
            // printed location wise graph one in each canvas element
            for(i=0; i<locationArray.length; i++){
                var tempName = [];
                var tempVote = [];
                for(j=0; j<loc.length; j++){
                    if(locationArray[i] == loc[j]){
                        tempName.push(candidate[j]);
                        tempVote.push(numVotes[j]);
                    }
                }
                new Chart(ctx[i], {
                    // The type of chart we want to create
                    type: 'bar',

                    // The data for our dataset
                    data: {
                        labels: tempName,
                        datasets: [{
                            label: locationArray[i],
                            backgroundColor: 'rgb(155, 199, 232)',
                            borderColor: 'rgb(255, 99, 132)',
                            data: tempVote,
                        }]
                    },
                    // Configuration options go here
                    options: {}
                });
            }
        </script>
    </body>
</html>