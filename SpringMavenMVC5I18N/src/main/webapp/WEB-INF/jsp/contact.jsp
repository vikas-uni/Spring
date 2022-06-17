<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- spring:message to retrieve the message with the given code -->
<html>
<head>
	<title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>
<h3><spring:message code="label.title"/></h3>
<span style="float: right">
	<a href="?lang=en">en</a> 
	<a href="?lang=de">de</a>
</span>
<form:form method="post" action="addContact">
	<table>
	<tr>
		<td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
		<td><form:input path="firstname" /></td> 
	</tr>
	<tr>
		<td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
		<td><form:input path="lastname" /></td>
	</tr>
	<tr>
		<td><form:label path="email"><spring:message code="label.email"/></form:label></td>
		<td><form:input path="email" /></td>
	</tr>
	<tr>
		<td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
		<td><form:input path="telephone" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message code="label.addcontact"/>"/>
		</td>
	</tr>
</table>	
</form:form>
</body>
</html>
