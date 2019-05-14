<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>iNube</title>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
</head>
<body>
<img alt="iNube" src="${pageContext.request.contextPath}/img/inube_logo.png">
<form action="LoginServlet" method="post" id="login_form">
    <p id="login">Login</p>
    <label for="username">Usuario:</label><br>
    <input name="username" type=text id="username" class="text-input" required><br>
    <label for="password">Contraseña:</label><br>
    <input name="password" type="password" id="password" class="text-input" required><br><br>
    <input type="submit" value="Enviar">
</form>
<h3 id="register">¿No eres usuario? <a style="color: white" href="${pageContext.request.contextPath}/CreateNegocioServlet">Click aquí­</a> para registrarte</h3>
</body>
</html>