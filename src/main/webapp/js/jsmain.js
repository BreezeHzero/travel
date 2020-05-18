$(function() {
    InitFace();
    FindAllQuestion()
    GetMessageList();
    /*GetOnLineList();*/

    $("#Button1").click(function() { //按钮点击事件
        if ($("#txtContent").val() != "") {
            SendContent($("#txtContent").val());
        }
        else {
            alert("发送不能为空!");
            $("#txtContent").focus();
            return false;
        }
    });


    //退出按钮
    $("#Button2").click(function() { //按钮点击事件
        $.getJSON("chat/logout",{},function(flag){
            console.log(flag);
            if(flag){
                window.location.href="tourguide.html";
            }
        });

    });

    $("table tr td img").click(function() { //表情图标单击事件
        var strContent = $("#txtContent").val() + "<:" + this.id + ":>";
        $("#txtContent").val(strContent);

    });
});
//******************************************
//自定义发送聊天内容函数
//参数 content 为聊天内容
//******************************************
function SendContent(content) {
    $.getJSON("chat/addSendContent",{
        content:content
    },function (flag) {
        if(flag){
            $("#txtContent").val("");
            GetMessageList();
        }else{
            alert("系统错误，请重新发送");
        }
    })
}
//******************************************
//自定义返回聊天内容函数
//界面上显示聊天内容
//参数 data 为返回的聊天内容数据
//******************************************
function GetMessageList() {
    $.ajax({
        type: "POST",
        url: "chat/allChatList",
        //data: "action=ChatList&d=" + new Date(),
        success: function(data) {
            $("#divContent").html(data);
        }
    });
    AutoUpdContent(); //执行定时获取函数
}
//******************************************
//自定义返回在线人员函数
//参数 data 为返回的在线人员数据
//******************************************
/*function GetOnLineList() {
    $.ajax({
        type: "POST",
        url: "chat",
        data: "action=OnLineList&d=" + new Date(),
        success: function(data) {
            $("#divOnLine").html(data);
        }
    });
}*/
//******************************************
//自定义设置表情图标函数
//无参数
//******************************************
function InitFace() {
    var strHTML = "";
    for (var i = 1; i <= 10; i++) {
        strHTML += "<img src='Face/" + i + ".gif ' id='" + i + "'/>";
    }
    $("#divFace").html(strHTML);
}
//******************************************
//自定义定时执行返回聊天内容与在线人员函数
//无参数
//******************************************
function AutoUpdContent() {
    setTimeout(GetMessageList, 3000);
    /*setTimeout(GetOnLineList, 6000);*/
}
function FindAllQuestion(){
    $.getJSON("service/findAll",{},function(data){
        var lis = "";
        for (var i = 0; i < data.length; i++) {
            var li = "";
            li = '<li><i class="fa fa-angle-right"></i><a href="javascript:void(0);"onclick="answerClick('+data[i].serid+')">'+data[i].question+'</a></li>';
            lis += li;
        }
        $(".footer_nav").html(lis);
    })
}
function answerClick(serid){
    $.getJSON("service/findAnswerBySerid",{
        serid:serid
    },function(data){
        //$(".divSystem").attr("style","display:block;");
        var answer = eval(data);
        $("#divAnswer").html("系统：" + answer.answer);
    })
}