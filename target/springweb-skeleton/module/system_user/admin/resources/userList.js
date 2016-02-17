var usersListBuilder = function(options){
    if(typeof options.getUserListUrl == "undefined"){
        return;
    }
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    var sendRequest = function(){
        $.ajax({
            xhr: function(){
                var xhr=new window.XMLHttpRequest();

                xhr.upload.addEventListener("progress",function(evt){
                    if(evt.lengthComputable){
                        var percentComplete=evt.loaded/evt.total;
                        console.log("Upload " + percentComplete);
                    }
                },false);
                xhr.addEventListener("progress",function(evt){
                    if(evt.lengthComputable){
                        var percentComplete=evt.loaded/evt.total;
                        //Do something with download progress
                        console.log(percentComplete);
                    }
                },false);
                return xhr;
            },
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            type: 'POST',
            contentType : "application/json",
            dataType : 'json',
            url: options.getUserListUrl,
            success: function(data){
                console.log(data);
            }
        });
    };


    return{
        refresh: sendRequest
    }
};