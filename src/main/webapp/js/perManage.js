function dianwo3(rid){
    if($("#zhezhao2").css("display") == 'none' && $("#beijingzhezhao2").css("display") == 'none'){
        $("#zhezhao2").css("display","block");
        $("#beijingzhezhao2").css("display","block");
    }
    // commentContent(rid);
    var uid = getParameter("uid");
    $.getJSON("order/findHaveBuyByUid",{uid:uid},function (data) {
        var lis = "";
        for (var i = 0; i < data.length; i++) {
            /*if(data[i].rid != rid){
                document.getElementsByClassName("form")[i].style.display='none';
            }*/
            var li = "";
            li = '<span>我的评价</span>' +
                '<form class="form" id="form">\n' +
                '<textarea class="text_main" id="text_main" name="comments" value="">'+data[i].comments+'</textarea>\n' +
                ' <a class="btn btn_a" id="btn_mycomm" href="javascript:void(0)" onclick="commLoad2('+data[i].rid+')">确定</a>\n' +
                ' <a class="btn btn_quxiao" style="background-color: #eee;color: black" onclick="hidder3()">取消</a>' +
                '</form>\n';
            // lis += li;
            if(data[i].rid == rid){
                $("#text_comments").html(li);
                return;
            }
        }

    });
}
function hidder3(){
    if($("#zhezhao2").css("display") == 'block' && $("#beijingzhezhao2").css("display") == 'block'){
        $("#zhezhao2").css("display","none");
        $("#beijingzhezhao2").css("display","none");
    }
}
/*//查出评论，把评论显示在text中
function commentContent(rid){
    $.getJSON("order/findCommentByUidAndRid",{rid:rid},function(data){
        document.getElementById("text_main").value=data[0].comments;
    });
}*/
function commLoad2(rid){
    var comments = $("#text_main").val();
    $.getJSON("order/addComments",{
        rid:rid,
        comments:comments
    },function(flag){
        if(flag){
            hidder3();
            findMyComments();
        }else{
            alert("提交失败");
        }
    });
}

//监听回车
$("#btn_mycomm").bind("keyup", function (e) {
    if (e.keyCode == 13) {
        $('#btn_mycomm').click();
    }
});