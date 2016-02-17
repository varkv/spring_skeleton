var usersListBuilder = function(_options){
    var options = {
        getUserUrl: null,
        $container: null
    };
    $.extend(options,_options);
    if(options.getUserUrl == null
        || options.$container == null){
        return;
    }

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    var aSystemUser = [];

    var refresh = function(){
        aSystemUser = [];
        options.$container.empty();

        sendRequest();
    };

    var sendRequest = function(){
        $.ajax({
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            type: 'POST',
            contentType : "application/json",
            dataType : 'json',
            url: options.getUserUrl,
            success: function(data){
                renderUsers(data);
            }
        });
    };

    var renderUsers = function(_aUsers){
        for(var i=0;i<_aUsers.length;i++){
            var tmp = new SystemUser(_aUsers[i],i+1);
            tmp.render();
            aSystemUser.push(tmp);
        }
    };

    var SystemUser = function(_aData,index){
        var that = this;
        that.aData = {
            enabled: false,
            id: null,
            login: null,
            recDate: null
        };
        $.extend(that.aData,_aData);

        var $tr = null;

        that.render = function(){
            if($tr == null){
                $tr = $("<tr/>").appendTo(options.$container).click(function(){
                    that.doEdit();
                });
            }else{
                $tr.empty();
            }
            $("<td/>").text(index).appendTo($tr);
            $("<td/>").append(
                $("<span/>")
                    .addClass("glyphicon "+(that.aData.enabled?"glyphicon-ok":"glyphicon-remove"))
                    .attr("aria-hidden",true)
            ).appendTo($tr);
            var dateStr = "";
            if(that.aData['recDate'] != null) {
                var date = new Date(that.aData['recDate']);
                dateStr = date.format("dd.mm.yyyy HH:MM:ss")
            }
            $("<td/>").text(dateStr).appendTo($tr);
            $("<td/>").text(that.aData['login']).appendTo($tr);
        };

        that.doEdit = function(){
            systemUserEditModal.open(that);
        };

        return that;
    };

    var systemUserEditModal = (function(){
        var $modal = null;
        var active = false;
        var systemUser = null;

        var init = function(){
            $modal = $($.trim($("#systemUserEditFormTemplate").html())).modal({
                "show":false
            });
            $("._btn_save",$modal).click(function(){save();})
            $("._btn_dismiss",$modal).click(function(){dismiss();})
        };
        var show = function(){
            $modal.modal('show');
        };
        var hide = function(){
            $modal.modal('hide');
        };

        var open = function(_systemUser){
            if(active) return;
            active = true;
            systemUser = _systemUser;
            if(systemUser.aData.id != null){
                getSystemUserFullData();
            }else {
                show();
            }
        };
        var close = function(){
            active = false;
            systemUser = null;
            hide();
        }

        var getSystemUserFullData = function(){
            $.ajax({
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(header, token);
                },
                type: 'GET',
                contentType : "application/json",
                dataType : 'json',
                url: options.getUserUrl+systemUser.aData.id,
                success: function(data){
                    systemUser.aData = data;
                    renderUserData();
                }
            });
        }
        var renderUserData = function(){
            $("#systemUserLogin",$modal).val(systemUser.aData.login);
            $("#systemUserActive",$modal).prop("checked",systemUser.aData.enabled);

            var dateStr = "";
            if(systemUser.aData['recDate'] != null) {
                var date = new Date(systemUser.aData['recDate']);
                dateStr = date.format("dd.mm.yyyy HH:MM:ss")
            }
            $("#systemUserRecDate",$modal).text(dateStr);

            var aRoles = [];
            if(systemUser.aData.systemRolesCollection != null){
                for(var i=0;i< systemUser.aData.systemRolesCollection.length;i++){
                    var tmp = systemUser.aData.systemRolesCollection[i];
                    aRoles.push(tmp['systemRole']);
                }
            }
            $("#systemUserGroups",$modal).val(aRoles);

            show();
        }
        var save = function(){

        }
        var dismiss = function(){
            close();
        }


        init();
        return{
            "open":open
        }
    }());

    return{
        refresh: refresh
    }
};