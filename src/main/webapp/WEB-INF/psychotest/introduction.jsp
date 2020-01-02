<%-- 
    Document   : introduction
    Created on : Dec 30, 2019, 8:39:19 AM
    Author     : Rizky
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1><h:outputText value="Hello World!"/>Hello, this is the online psychotest page</h1>
            <h3>You have 2 hours to complete this test. the test include 10 question that you have to answer it.<br>
                Good Luck!</h3>
            <a href="/starttest" >Start Test!</a>
        </body>


    </html>
</f:view>
