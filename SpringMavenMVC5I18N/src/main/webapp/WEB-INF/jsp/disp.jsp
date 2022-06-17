<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.title"/></h3>

<%--<span style="float: right">
	<a href="?lang=en">en</a> 
	| 
	<a href="?lang=de">de</a>
	
</span> --%>
First name 
${contact.firstname}
last name ${contact.lastname }