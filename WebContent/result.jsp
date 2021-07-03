<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="Model.Flight" %>
    
<!DOCTYPE html>
<html>
<head>
		
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	
	
	<title>Available Flights</title>
	
</head>

<body>
<div class="container" style="margin-top:30px">

	<div id ="header">
		<table width="100%">
			<tr>
				<td>
					<c:if test="${availableFlights.size() != 0}">
						<h4><c:out value="${availableFlights.size()}"></c:out> Flights found!</h4>
					</c:if>
					<c:if test="${availableFlights.size() == 0}">
						<h4>No Flights As per Your Input!!</h4>
					</c:if>
				</td>
				<td align = "right">
					<table>
					<tr>
						<td>
						<form action="loggedinsearch">
							<input class="btn btn-primary" type = "submit" value = "SearchFlight"/>
						</form>
						</td>
						<td>
						<form action="logout">
							<input class="btn btn-primary" type = "submit" value = "LogOut"/>
						</form>
						</td>
					</tr>
					</table>
				</td>
			</tr>
		 </table>
	</div>
	
	<div>
	<c:if test="${availableFlights.size() != 0}">
	<table class = "table table-bordered" style="text-align:center;background-color: aliceblue;margin-top:20px">
			<tr>
				<th> FLIGHT NUMBER </th>
				<th> DEPARTURE LOCATION </th>
				<th> ARRIVAL LOCATION </th>
				<th> VALID TILL </th>
				<th> FLIGHT TIME </th>
				<th> FLIGHT DURATION </th>
				<th> FARE </th>
			</tr>
			
			<c:forEach items = "${availableFlights}" var = "flight">
			<tr >
  				<td>${flight.getFlightNumber()}</td>  					
  				<td>${flight.getFlightDeparture()}</td>
  				<td>${flight.getFlightArrival()}</td>
  				<td>${flight.getValidTill()}</td>
  				<td>${flight.getFlightTime()}</td>
  				<td>${flight.getFlightDuration()}</td>
  				<td>${flight.getFlightFare()}</td>  					
			</tr>
  			</c:forEach>
		
	</table>
	</c:if>		
	</div>

</div>	
</body>
</html>