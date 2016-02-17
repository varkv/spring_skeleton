<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 16.12.2015
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Hi</title>

  <link href="<c:url value="/resources/libs/bootstrap-3.3.6-dist/css/bootstrap.min.css"/>" type="text/css" rel='stylesheet'/>
  <link href="<c:url value="/resources/libs/bootstrap-3.3.6-dist/css/bootstrap-theme.min.css"/>" type="text/css" rel='stylesheet'/>
  <link href="<c:url value="/resources/default.css"/>" type="text/css" rel='stylesheet'/>

  <script type="text/javascript" src="<c:url value="/resources/libs/jquery-2.1.4.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/libs/bootstrap-3.3.6-dist/js/bootstrap.min.js"/>"></script>

  <style type="text/css">
    body{ background-color: gray;}
  </style>
</head>
<body>
<c:set var="active_navbar_item" scope="session" value="system_user"/>
<c:import url="/component/main_panel"/>

личная страница
</body>
</html>