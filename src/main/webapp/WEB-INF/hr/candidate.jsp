<%-- 
    Document   : listCandidate
    Created on : Dec 28, 2019, 10:44:16 AM
    Author     : Rizky
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Action</th>
            </tr>
            <c:forEach var = "list" items = "${listCandidate}">
                <tr>
                    <td>${list.id}</td>
                    <td>${list.firstName}</td>
                    <td>${list.lastName}</td>
                    <td>
                        <a href="/view/${list.id}">View</a>
                        <a href="/delete/${list.id}">Delete</a>
                        <a href="/edit/${list.id}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <h1>klasjdfkjdafdlsakflkasj</h1>
    </body>
</html>
