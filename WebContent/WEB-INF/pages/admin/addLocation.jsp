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
            <form method="post" action="addLocation">  <!-- location_adder.html works in background and redirects back to this page with success message -->
                <h3>Add Location</h3>
                <input type="number" id="lId" class="lId col-xs-12" name="locationId" placeholder="Location Id">
                <div class="col-xs-12">&nbsp;</div>
                <div class="col-xs-12 btn">Address</div>
                <div class="col-xs-12">&nbsp;</div>
                <input type="text" id="area" class="area col-xs-12" name="area" placeholder="Area">
                <div class="col-xs-12">&nbsp;</div>
                <input type="text" id="city" class="city col-xs-12" name="city" placeholder="City">
                <div class="col-xs-12">&nbsp;</div>
                <input type="text" id="state" class="state col-xs-12" name="state" placeholder="State">
                <div class="col-xs-12">&nbsp;</div>
                <input type="number" id="pincode" class="pincode col-xs-12" name="pincode" placeholder="Pincode">
                <div class="col-xs-12">&nbsp;</div>
                <input type="number" id="pId" class="pId col-xs-12" name="parentLocationId" placeholder="Parent Location Id">
                <div class="col-xs-12">&nbsp;</div>
                <input type="submit" class="btn col-xs-12" value="Add Location">
                <div class="col-xs-12">&nbsp;</div>
                <div id="res" class="res" name="res">${sessionScope.loc_status}</div>
            </form>
        </div>
    </body>
</html>