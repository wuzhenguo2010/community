$(function (){
    $("#uploadForm").submit(upload);
});

function upload(){
    $.ajax({
        url: "http://upload.qiniup.com",
        method: "post",
        processData: false,//不让他转换成字符串提交
        contentType: false,//不让jQuery设置类型，让浏览器自动设置
        data: new FormData($("#uploadForm")[0]),
        success: function (data){
            if(data && data.code == 0){
                // 更新头像访问路径
                $.post(
                    CONTEXT_PATH + "/user/header/url",
                    {"fileName":$("input[name='key']").val()},
                    function (data){
                        data = $.parseJSON(data);
                        if(data.code == 0){
                            window.location.reload();
                        }else {
                            alert(data.msg);
                        }
                    }
                );
            }else {
                alert("上传失败！");
            }
        }
    });

    return false;
}