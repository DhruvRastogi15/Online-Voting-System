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
        <div class="container col-xs-12 text-center">
            <form method="post" action="removeLocation">  <!-- location_remover.html works in background and redirects back to this page with success message -->
                <h3>Remove Location</h3>
                <input type="number" id="lId" class="lId col-xs-12" name="locationId" placeholder="Location Id">
                <div class="col-xs-12">&nbsp;</div>
                <input type="submit" class="btn col-xs-12" value="Remove Location">
                <div class="col-xs-12">&nbsp;</div>
                <div id="res" class="res" name="res">${sessionScope.loc_status}</div>
            </form>
        </div>
    </body>
</html>