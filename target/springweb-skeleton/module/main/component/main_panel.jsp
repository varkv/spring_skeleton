<%@ page import="ru.kvk.skeleton.module.system_user.entity.enums.SystemRole" %>
<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 16.12.2015
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Панель навигации</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>


        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li id="main"><a href="<c:url value="/"/>">Главная</a></li>

                <% request.setAttribute("checkedRole",SystemRole.ROLE_SYSTEM_USER_ADMIN.name());%>
                <sec:authorize access="hasAuthority('${checkedRole}')">
                    <li id="system_user_admin"><a href="<c:url value="/module/system_user/admin/" />">Управление пользователями</a></li>
                </sec:authorize>


                <sec:authorize access="isAuthenticated()">
                    <li id="system_user"><a href="<c:url value="/module/system_user/" />">Личный кабинет</a></li>
                </sec:authorize>
            </ul>

            <div class="navbar-right">
                <sec:authorize access="isAnonymous()">
                    <p class="navbar-text">Привет, гость!</p>
                    <p class="navbar-text">
                        <a href="<c:url value="/sign_in" />" class="glyphicon glyphicon-log-in" aria-hidden="true" title="Вход"></a>
                    </p>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <p class="navbar-text">Привет, ${login}</p>
                    <p class="navbar-text">
                        <a href="<c:url value="/sign_out" />" class="glyphicon glyphicon-log-out" aria-hidden="true" title="Выход"></a>
                    </p>
                </sec:authorize>
            </div>
        </div>
    </div>
</nav>
<script type="text/javascript">
    $(document).ready(function(){
        $(".nav li").removeClass("active");
        $('.nav #${active_navbar_item}').addClass('active');
    });
</script>