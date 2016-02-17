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

    <script type="text/javascript"  src="<c:url value="/resources/libs/date.format.js"/>"></script>
    <script type="text/javascript"  src="<c:url value="/module/system_user/admin/resources/userList.js"/>"></script>

    <style type="text/css">

    </style>
    <script type="text/javascript">
        $(function(){
            var systemUserRoles = ""
            window.users = new usersListBuilder({
                "getUserUrl":"<c:url value="/module/system_user/admin/"/>",
                "$container":$("#systemUserTable tbody")
            });
            users.refresh();
        });
    </script>
</head>
<body>
<c:set var="active_navbar_item" scope="session" value="system_user_admin"/>
<c:import url="/component/main_panel"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <h1>Пользователи системы</h1>
            <table id="systemUserTable" class="table table-striped table-hover table-condensed clickable">
                <colgroup>
                    <col width="60"/>
                    <col width="100"/>
                    <col width="150"/>
                    <col width="*"/>
                </colgroup>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Активен</th>
                        <th>Дата</th>
                        <th>Логин</th>
                    </tr>
                </thead>
                <tbody></tbody>
                <tfoot></tfoot>
            </table>
        </div>
    </div>
    <script type="text/template" id="systemUserEditFormTemplate">
        <div class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title"></h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="systemUserLogin">Логин</label>
                                <input type="text" class="form-control" id="systemUserLogin" placeholder="Email">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" id="systemUserActive"> Активен
                                </label>
                            </div>
                            <div class="form-group">
                                <label>Дата создания</label>
                                <p class="form-control-static" id="systemUserRecDate"></p>
                            </div>
                            <div class="form-group">
                                <label for="systemUserGroups">Состоит в группах</label>
                                <select multiple class="form-control" id="systemUserGroups">
                                    <c:forEach var="role" items="${roles}">
                                        <option value="${role.code_name}">${role.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger _btn_dismiss">Отмена</button>
                        <button type="button" class="btn btn-primary _btn_save">Сохранить</button>
                    </div>
                </div>
            </div>
        </div>
    </script>
</div>
</body>
</html>