$(function (){
    $("#topBtn").click(setTop);
    $("#untopBtn").click(setUnTop);
    $("#wonderfulBtn").click(setWonderful);
    $("#unwonderfulBtn").click(setUnWonderful);
    $("#deleteBtn").click(setDelete);
});// 页面加载完会调用

function like(btn, entityType, entityId, entityUserId, postId){
    $.post(
        CONTEXT_PATH + "/like",
        {"entityType":entityType, "entityId":entityId, "entityUserId":entityUserId, "postId":postId},
        function (data){
            data = $.parseJSON(data);
            if(data.code == 0){
                $(btn).children("i").text(data.likeCount);
                $(btn).children("b").text(data.likeStatus==1?'已赞':'赞');
            }else {
                alert(data.msg);
            }
        }
    );
}

// 置顶
function setTop(){
    $.post(
        CONTEXT_PATH + "/discuss/top",
        {"id":$("#postId").val()},
        function (data){
            data = $.parseJSON(data);
            if(data.code == 0){
                // $("#topBtn").attr("disabled", "disabled");
                $("#topBtn").text(data.type==1?'取消置顶':'置顶');
                location.reload();
            }else {
                alert(data.msg);
            }
        }
    );
}

// 取消置顶
function setUnTop(){
    $.post(
        CONTEXT_PATH + "/discuss/untop",
        {"id":$("#postId").val()},
        function (data){
            data = $.parseJSON(data);
            if(data.code == 0){
                $("#untopBtn").text(data.type==1?'取消置顶':'置顶');
                location.reload();
            }else {
                alert(data.msg);
            }
        }
    );
}

// 加精
function setWonderful(){
    $.post(
        CONTEXT_PATH + "/discuss/wonderful",
        {"id":$("#postId").val()},
        function (data){
            data = $.parseJSON(data);
            if(data.code == 0){
                // $("#wonderfulBtn").attr("disabled", "disabled");
                $("#wonderfulBtn").text(data.status==1?'取消加精':'加精');
                location.reload();
            }else {
                alert(data.msg);
            }
        }
    );
}

// 加精
function setUnWonderful(){
    $.post(
        CONTEXT_PATH + "/discuss/unwonderful",
        {"id":$("#postId").val()},
        function (data){
            data = $.parseJSON(data);
            if(data.code == 0){
                // $("#wonderfulBtn").attr("disabled", "disabled");
                $("#unwonderfulBtn").text(data.status==1?'取消加精':'加精');
                location.reload();
            }else {
                alert(data.msg);
            }
        }
    );
}

// 删除
function setDelete(){
    $.post(
        CONTEXT_PATH + "/discuss/delete",
        {"id":$("#postId").val()},
        function (data){
            data = $.parseJSON(data);
            if(data.code == 0){
                location.href = CONTEXT_PATH + "/index";
            }else {
                alert(data.msg);
            }
        }
    );
}