<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1px" bordercolor="black" width=80% align="center">
                <tr>
                    <td>id</td>
                    <td>name</td>
                    <td>Role</td>
                         </tr>
                <c:forEach items="${model.emplist}" var="element">
                    <tr>
                        <td><c:out value="${element.id}" /></td>
                        <td><c:out value="${element.name}" /></td>

                        <td><c:out value="${element.role}" /></td>

                          </tr>

                </c:forEach>
            </table>
	</body>
</html>