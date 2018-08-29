<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User form</title>
</head>
<body>

<style>
    .error {
        color: darkred;
    }
</style>
<h1>Register a new user</h1>
<form:form method="POST" modelAttribute="user"> <!-- pobieramy dane wiec POST, wyswietlanie to GET + przechowuje dane o uzytkowku w "user"-->

    Login: <br><form:input path="username"/><br> <!-- // nazwy zmiennych w klasie -->
    <form:errors path="username" cssClass="error" /><br><br>

    User name: <br><form:input path="name"/><br> <!-- // nazwy zmiennych w klasie -->
    <form:errors path="name" cssClass="error" /><br><br>

    User surname: <br><form:input path="surname"/><br> <!-- // nazwy zmiennych w klasie -->
    <form:errors path="surname" cssClass="error" /><br><br>

    Password: <br><form:password path="password"/><br>
    <form:errors path="password" cssClass="error" /><br><br>
    Repeat password: <br><%-- <br><form:password path="password"/><br>--%>
    <%--<form:errors path="password" cssClass="error" /><br><br>--%>

    E-mail <br><form:input path="email"/><br>
    <form:errors path="email" cssClass="error" /><br><br>

    About me: <br><form:textarea path="aboutme" rows="3" cols="20"/><br> <!-- // nazwy zmiennych w klasie -->
    <form:errors path="aboutme" cssClass="error" /><br><br>
    <br>
    <input type="submit" value="Register">

</form:form>


</body>
</html>