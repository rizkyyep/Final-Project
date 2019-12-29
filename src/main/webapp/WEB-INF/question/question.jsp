<%-- 
    Document   : listQuestion
    Created on : Dec 28, 2019, 2:28:03 PM
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
        <h1><h:outputText value="Hello World!"/> Question List</h1>
        <table border="1">
            <tr>
                <th>No</th>
                <th>Id</th>
                <th>Soal</th>
                <th>A</th>
                <th>B</th>
                <th>C</th>
                <th>D</th>
                <th>E</th>
                <th>F</th>
                <th>Date</th>
                <th>Jawaban</th>
                <th>Action</th>
            </tr>
            <c:forEach var = "list" items = "${listQuestion}">
                
                <tr>
                    <td>${list.id}</td>
                    <td>${list.question}</td>
                    <td>${list.a}</td>
                    <td>${list.b}</td>
                    <td>${list.c}</td>
                    <td>${list.d}</td>
                    <td>${list.e}</td>
                    <td>${list.f}</td>
                    <td>${list.created}</td>
                    <td>${list.answer}</td>
                    <td>
                        <a href="/view/${list.id}">View</a>
                        <a href="/deleteQuestion/${list.id}">Delete</a>
                        <a href="/updateQuestion/${list.id}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <hr>
        <form method="post" action="/question/save">
            <table>
                <input type="text" name="id" id="id" hidden placeholder="input question" />
                <tr>
                    <td>Soal</td><td>:</td>
                    <td><input type="text" name="question" id="question" placeholder="input question" /></td>
                </tr>
                <tr>
                    <td>Option A</td><td>:</td>
                    <td><input type="text" name="a" id="a" placeholder="input option A" /></td>
                </tr>
                <tr>
                    <td>Option B</td><td>:</td>
                    <td><input type="text" name="b" id="b" placeholder="input option B" /></td>
                </tr>
                <tr>
                    <td>Option C</td><td>:</td>
                    <td><input type="text" name="c" id="c" placeholder="input option C" /></td>
                </tr>
                <tr>
                    <td>Option D</td><td>:</td>
                    <td><input type="text" name="d" id="d" placeholder="input option D" /></td>
                </tr>
                <tr>
                    <td>Option E</td><td>:</td>
                    <td><input type="text" name="e" id="e" placeholder="input option E" /></td>
                </tr>
                <tr>
                    <td>Option F</td><td>:</td>
                    <td><input type="text" name="f" id="f" placeholder="input option F" /></td>
                </tr>
                <tr>
                    <td>Date Created</td><td>:</td>
                    <td><input type="date" name="created" id="created" placeholder="input created" /></td>
                </tr>
                <tr>
                    <td>answer</td><td>:</td>
                    <td>
                        <select name="answer" id="answer">
                            <option value="a">A</option>
                            <option value="b">B</option>
                            <option value="c">C</option>
                            <option value="d">D</option>
                            <option value="e">E</option>
                            <option value="f">F</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
