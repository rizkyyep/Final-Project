<%-- 
    Document   : newjsf
    Created on : Dec 29, 2019, 12:07:49 AM
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
            <h1>Form Update Question</h1>
            <form method="post" action="/question/save">
                <table>
                    <input type="text" value="${listUpdate.id}" name="id" id="id" hidden />
                    <tr>
                        <td>Soal</td><td>:</td>
                        <td><input type="text" value="${listUpdate.question}" name="question" id="question" placeholder="input question" /></td>
                    </tr>
                    <tr>
                        <td>Option A</td><td>:</td>
                        <td><input type="text" value="${listUpdate.a}" name="a" id="a" placeholder="input option A" /></td>
                    </tr>
                    <tr>
                        <td>Option B</td><td>:</td>
                        <td><input type="text" value="${listUpdate.b}" name="b" id="b" placeholder="input option B" /></td>
                    </tr>
                    <tr>
                        <td>Option C</td><td>:</td>
                        <td><input type="text" value="${listUpdate.c}" name="c" id="c" placeholder="input option C" /></td>
                    </tr>
                    <tr>
                        <td>Option D</td><td>:</td>
                        <td><input type="text" value="${listUpdate.d}" name="d" id="d" placeholder="input option D" /></td>
                    </tr>
                    <tr>
                        <td>Option E</td><td>:</td>
                        <td><input type="text" value="${listUpdate.e}" name="e" id="e" placeholder="input option E" /></td>
                    </tr>
                    <tr>
                        <td>Option F</td><td>:</td>
                        <td><input type="text" value="${listUpdate.f}" name="f" id="f" placeholder="input option F" /></td>
                    </tr>
                    <tr>
                        <td>Date Created</td><td>:</td>
                        <td><input type="date" value="${listUpdate.created}" name="created" id="created" placeholder="input created" /></td>
                    </tr>
                    <tr>
                        <td>answer</td><td>:</td>
                        <td>
                            <select name="answer" id="answer">
                                <option  value="${listUpdate.answer}"> ${listUpdate.question}</option>
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
</f:view>
