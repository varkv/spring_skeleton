<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 16.12.2015
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hi</title>
    <meta charset="utf-8"/>
    <sec:csrfMetaTags />

    <link href="<c:url value="/resources/libs/bootstrap-3.3.6-dist/css/bootstrap.min.css"/>" type="text/css" rel='stylesheet'/>
    <link href="<c:url value="/resources/libs/bootstrap-3.3.6-dist/css/bootstrap-theme.min.css"/>" type="text/css" rel='stylesheet'/>
    <link href="<c:url value="/resources/default.css"/>" type="text/css" rel='stylesheet'/>
    <script type="text/javascript" src="<c:url value="/resources/libs/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript"  src="<c:url value="/resources/libs/bootstrap-3.3.6-dist/js/bootstrap.min.js"/>"></script>

    <script type="text/javascript"  src="<c:url value="/module/system_user/admin/resources/userList.js"/>"></script>

    <style type="text/css">

    </style>
    <script type="text/javascript">
        var users = new usersListBuilder({
            "getUserListUrl":"<c:url value="/module/system_user/admin/"/>"
        });
        users.refresh();
    </script>
</head>
<body>
<c:set var="active_navbar_item" scope="session" value="system_user_admin"/>
<c:import url="/component/main_panel"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <h1>Пользователи системы</h1>
            <table class="table table-striped table-hover table-condensed">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Логин</th>
                        <th>Активен</th>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>