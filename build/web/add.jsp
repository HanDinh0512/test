<%-- 
    Document   : add.jsp
    Created on : Apr 19, 2024, 1:23:33 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AddEmployee" method="POST">
            ID: <input type="number" name="id"/><br/>
            Name: <input type="text" name="name"/><br/>
            Dob: <input type="date" name="dob"/><br/>
            Gender: <input type="radio" name="gender" value="male"/> Male
            <input type="radio" name="gender" value="female"/> Female <br/>
            Certificates:<br>
            <c:forEach items="${requestScope.certs}" var="c">
                <input type="checkbox" value="${c.id}" name="cert${c.id}"/> ${c.name} at <input type="date" name="datecert${c.id}"/><br>
            </c:forEach>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
