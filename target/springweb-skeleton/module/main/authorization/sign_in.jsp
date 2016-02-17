<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 15.12.2015
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Login Page</title>

    <link href="<c:url value="/resources/libs/bootstrap-3.3.6-dist/css/bootstrap.min.css"/>" type="text/css" rel='stylesheet'/>
    <link href="<c:url value="/resources/libs/bootstrap-3.3.6-dist/css/bootstrap-theme.min.css"/>" type="text/css" rel='stylesheet'/>

    <script type="text/javascript" src="<c:url value="/resources/libs/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/libs/bootstrap-3.3.6-dist/js/bootstrap.min.js"/>"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
            <h2>Авторизация</h2>
            <c:if test="${not empty error}">
                <p class="text-danger">${error}</p>
            </c:if>
            <c:if test="${not empty msg}">
                <p class="text-primary">${msg}</p>
            </c:if>

            <form name='loginForm' action="<c:url value="/sign_in_check"/>" method='POST' role="form">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                    <label for="login">Логин:</label>
                    <input type='text' id='login' name='login' class="form-control">
                </div>
                <div class="form-group">
                    <label for="password">Пароль:</label>
                    <input type='password' id='password' name='password' class="form-control">
                </div>
                <button type="submit" class="btn btn-primary btn-lg btn-block">Вход</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
