$(function () {
    // document.getElementById('zhezhao').style.display="none";
    // document.getElementById("beijingzhezhao").style.display="none";
    $("#zturn").css('display','none');

    updateLoad();
    loadTourguideInfo();
    $(".box").delay(3000).hide(0);
    $("#zturn").delay(3000).show(0);
});

function loadTourguideInfo(){
    $.getJSON("tourguide/findAll",{},function (data) {
        var lis = "";
        for (var i = 0; i < data.length; i++) {

            //年龄
            var tbirYear = data[i].birthday.split("-");
            var date = new Date();
            date.setFullYear(tbirYear[0]);

            var nowDate = new Date();
            var age = nowDate.getFullYear() - date.getFullYear();


            var workdate = data[i].worktime.split("-");
            var wdate = new Date();
            wdate.setFullYear(workdate[0]);
            var workt = nowDate.getFullYear() - wdate.getFullYear();

            var s = "";
            if(data[i].status == 'y'){
                s = "工作中~";
            }else{
                s = "空闲~";
            }

            var li = "";
            li = '<li class="poster-item  zturn-item" >\n' +
                '                                <p class="xxgy">寄语</p>\n' +
                '                                <p class="say">'+ data[i].title +'</p>\n' +
                '                                <div class="for_btn">\n' +
                '                                    <a href="javascript:void(0)" onclick="dianwo('+data[i].tid+')"><img src=" '+data[i].timage+' " width="100%"></a> \n' +
                '                                </div>\n' +
                '                                <div class="students_star">\n' +
                '                                    <p class="cell_list"><span class="lf">姓名：<span class="darks">'+data[i].tname+'</span></span> <span class="rt">年龄：<span class="darks">'+age+'</span></span>\n' +
                '                                    </p>\n' +
                '                                    <p class="cell_list"><span class="lf">职龄：<span class="darks">'+workt+'年</span></span> <span class="rt">状态：<span class="darks">'+s+'</span></span>\n' +
                '                                    </p>\n' +
                '                                    <div class="zwjs">'+data[i].tinfo+'</div>\n' +
                '                                </div>\n' +
                '                            </li>';
            lis += li;
        }
        $("#zturn").html(lis);
    });
}
function updateLoad(){
    var aa=new zturn({
        id:"zturn",
        opacity:0.9,
        width:382,
        Awidth:1024,
        scale:0.9,
        auto:true,//是否轮播 默认5000
        turning:3000//轮播时长
    })
}
//点击咨询按钮，查询用户是否登录
function isLogin() {
    window.location.href="ChatMain.html";
    //location.href="http://localhost:8080/travel/ChatMain.html";
    /*$.getJSON("user/findSingleUser",{},function (user) {
        //如果有user，返回1
        if(user){
            window.location.href="ChatMain.html";
        }else{
            alert("请先登录");
            window.location.href="login.html";
        }
    });*/
}


function dianwo(tid){
    // document.getElementById('zhezhao').style.display="";
    // document.getElementById('beijingzhezhao').style.display="";
    if($(".zhezhao").css("display") == 'none' && $(".beijingzhezhao").css("display") == 'none'){
        $(".zhezhao").css("display","block");
        $(".beijingzhezhao").css("display","block");
    }

    $.getJSON("tourguide/findTourguideByid",{
        tid:tid
    },function (data) {
        var info = eval(data);
        css('.card-profile_visual:after {\n' +
            '            display: block;\n' +
            '            content: \'\';\n' +
            '            width: 100%;\n' +
            '            height: 100%;\n' +
            '            position: absolute;\n' +
            '            z-index: 0;\n' +
            '            background: url('+info.timage+') no-repeat center center/cover;\n' +
            '            opacity: 0.5;\n' +
            '            mix-blend-mode: lighten;\n' +
            '        }');
        var s = "";
        if(info.status == 'y'){
            s = "工作中~";
        }else{
            s = "空闲~";
        }
        var div = '<div class="header-right" id="header-right" onclick="hidder()">x</div>\n' +
            '                <div id="half_bg">\n' +
            '                    <div class="card-profile_visual"></div>\n' +
            '                    <div class="card-profile_user-infos">\n' +
            '                        <span class="infos_name">【'+info.tname+'】</span>\n' +
            '                        <span class="infos_nick">'+info.tinfo+'</span>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '                <div id="half_info">\n' +
            '                    <dl>\n' +
            '                        <dt>电话：<span>'+info.telephone+'</span></dt>\n' +
            '                        <dt>邮箱：<span>'+info.email+'</span></dt>\n' +
            '                        <dt>状态：<span>'+s+'</span></dt>\n' +
            '                    </dl>\n' +
            '                </div>';
        $("#header2").html(div);
    });
}
function hidder(){
    // document.getElementById('zhezhao').style.display="none";
    // document.getElementById('beijingzhezhao').style.display="none";
    if($(".zhezhao").css("display") == 'block' && $(".beijingzhezhao").css("display") == 'block'){
        $(".zhezhao").css("display","none");
        $(".beijingzhezhao").css("display","none");
    }
}

//给css添加样式,替换图片作用
var css=function(t,s){
    s=document.createElement('style');
    s.innerText=t;
    document.body.appendChild(s);
};