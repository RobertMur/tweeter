<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>

<h1>Warsztat6</h1>
<h1>Welcome to the Twitter application</h1>
<p>Please make a selection:</p>

<p>USERS:</p>
<ul>
<li><a href="<c:url value="/user/register"/>">Register a new user</a></li>

<li><a href="<c:url value="/user/login"/>">Login user</a></li>

</ul>

<a href="<c:url value="/user/all"/>">Show tweets by user</a>

<h4>All tweets:</h4>

    <ul>

    <c:forEach items="${tweets}" var = "tweet">
        <li>
            Autor: <a href="/user/${tweet.user.id}/aboutUser">${tweet.user.username}</a>Utworzono: ${tweet.created}
                <br>
                ${tweet.text}
                <br>
                <a href="/tweet/${tweet.id}/comment">comment</a>
        </li>
        <br>

    </c:forEach>

</ul>

</body>
</html>