<%-- 
    Document   : search
    Created on : Apr 19, 2024, 1:04:37 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="employees" method="GET">
            Account: <select name="displayname">
                <c:forEach items="${requestScope.accounts}" var="a">
                    <option value="${a.username}" >${a.displayname}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search"/>
            <table border="1px">
                <tr>
                    <th>Employee Id</th>
                    <th>Name</th>
                    <th>Dob</th>
                    <th>Gender</th>
                </tr>
                <c:forEach items="${requestScope.employees}" var="e">
                    <tr>
                        <td>${e.id}</td>
                        <td>${e.name}</td>
                        <td>${e.dob}</td>
                        <td><c:if test="${e.gender}">Male</c:if>
                            <c:if test="${!e.gender}">Female</c:if></td>
                        </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
