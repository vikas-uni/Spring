<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>Employee Data Form</h2>
		<form:form method="GET" action="addEmp">
		  		<table>
			    <tr>
			        <td width="127">Employee Id:</td>
			        <td width="102"><form:input path="id" /></td>
			    </tr>
			    <tr>
			        <td>Employee Name:</td>
			        <td><form:input path="name" /></td>
			        <!-- path attribute is bound into java properties using java beans convention. -->
			    </tr>
			    <tr>
			        <td>Employee role:</td>
			        <td><form:input path="role" /></td>
			    </tr>
			    	  <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table>  
		</form:form>
	</body>
</html>