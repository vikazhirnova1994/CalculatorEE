<%--@elvariable id="value" type="com.example.demo"--%>
<%--@elvariable id="user" type="com.example.demo"--%>
<%--@elvariable id="left" type="com.example.demo"--%>
<%--@elvariable id="right" type="com.example.demo"--%>
<%--@elvariable id="messages" type="com.example.demo"--%>

<%--
  Created by IntelliJ IDEA.
  User: vikaz
  Date: 27.04.2022
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.example.demo.Calculator" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <jsp:include page="header.html"/>
    <br/>
    Hello, ${user.name}
    <style>.error {
        color: red;
    }</style>
</head>
<body>
<br/>
<br/>
<form name="myform" id="calculator" action="calculator" method="post">
    <input type="hidden" id="command" name="operator"/>
    <p>
        <input type="button" value="+"
               onclick="document.getElementById('command').value='add'; document.myform.submit(); "/>
        <input type="button" value="-"
               onclick="document.getElementById('command').value='substr'; document.myform.submit(); "/>
        <input type="button" value="*"
               onclick="document.getElementById('command').value='mul'; document.myform.submit(); "/>
        <input type="button" value="/"
               onclick="document.getElementById('command').value='div'; document.myform.submit(); "/>
        <input type="button" value="^"
               onclick="document.getElementById('command').value='pow'; document.myform.submit(); "/>
    </p>
    <span class="error">${messages}</span>
    <p><input type="text" name="left" value="${left}"></p>
    <p><input type="text" name="right" value="${right}"/></p>
    <h2><span id="result">${value}</span></h2>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>