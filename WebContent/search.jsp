<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	
	
	<title>Flight Search</title>
	
</head>

<body>
<div align = "center" class = "container" style=" margin-top:50px;">

	<div id ="header" style="width:100% ; background-color: aliceblue ; margin-bottom:20px">
		<h2>Welcome! Enter your search here</h2>
	</div>
	
  	<form name="form" action = "search" method = "get" onsubmit="return InputValidation();">
  		<table cellpadding="10">
			<tr>
				<td style="width: 200px; padding: 10px;">Departure Location :</td>
				<td>
					<select name="dept" style="width: 200px;">
  					  <c:forEach items = "${deptLoc}" var = "deptLoc">
  						 <option value="${deptLoc}">${deptLoc}</option>
  					  </c:forEach>	
					</select>  
				</td>
			</tr>
			
			<tr>
				<td style="width: 200px; padding: 10px;">Arrival Location : </td>
				<td>
					<select name="ariv" style="width: 200px;">
  						<c:forEach items = "${arivLoc}" var = "arivLoc">
  							<option value="${arivLoc}">${arivLoc}</option>
  						</c:forEach>	
					</select>  
				</td>
			</tr>
			
			<tr>
				<td style="width: 200px; padding: 10px;">Flight Date : </td>
				<td>
					<input type = "date" name = "date" style="width: 200px;" /> 
				</td>
			</tr>
			
			<tr>
				<td style="width: 200px; padding: 10px;">Flight Class : </td>
				<td>
				  	<select name="fclass" style="width: 200px;">
  						<option value="E">Economic</option>
  						<option value="B">Business</option>
					</select> 
				</td>
			</tr> 
			
			<tr>
				<td style="width: 200px; padding: 10px;">Output Preference : </td>
				<td>
					<select name="preference" style="width: 200px;">
  						<option value="fare">Fare</option>
  						<option value="both">Fare & Flight Duration</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td align = "right">
					<input class="btn btn-primary" type = "submit" value = "Search>>" /> 
				</td>
			</tr>  				
	  	</table>
  	</form>
  	
</div>
</body>
	
<script>
	function InputValidation(){
		if (document.form.dept.value == "")
		{
			alert ( "Please enter Departure Location." );
			document.form.dept.focus();
			return false;
		}
		if (document.form.ariv.value == "")
		{
			alert ( "Please enter Arrival Location." );
			document.form.ariv.focus();
			return false;
		}
		if (document.form.date.value == "")
		{
			alert ( "Please enter Flight Date." );
			document.form.date.focus();
			return false;
		}
		if (document.form.fclass.value == "")
		{
			alert ( "Please enter Flight Class." );
			document.form.fclass.focus();
			return false;
		}
		if (document.form.preference.value == "")
		{
			alert ( "Please enter Output Preference." );
			document.form.preference.focus();
			return false;
		}	
		return true;
	}
</script>

</html>