var perDiv=null;
var perDiv2=null;
var perDiv3=null;
var tid_Quanju = 0;
function dianwo(){
    var rid = getParameter("rid");
    // var tid = getParameter("tid");
    //判断用户是否登录
    $.getJSON("user/findSingleUser",{},function(user){
        if(user){
            if($("#zhezhao").css("display") == 'none' && $("#beijingzhezhao").css("display") == 'none'){
                $("#zhezhao").css("display","block");
                $("#beijingzhezhao").css("display","block");
            }

            $.getJSON("route/findOne",{
                rid:rid
            },function(data){
                $("#main_image").html("<img src='"+data.rimage+"'>");
            });

            $.getJSON("tourguide/findAll",{},function(data){
                var divs="";
                for (var i = 0; i < data.length; i++) {
                    var div = "";
                    div = '<div class="tourguides_image"><img src="'+data[i].timage+'" onclick="chgColor3(this,'+data[i].tid+')"></div>';
                    divs += div;
                }
                $("#tourguides").html(divs);
            });
        }else{
            //用户未登录
            alert("您还未登录，请前往登录");
            location.href="login.html";
        }
    });

}

function hidder(){
    if($("#zhezhao").css("display") == 'block' && $("#beijingzhezhao").css("display") == 'block') {
        $("#zhezhao").css("display", "none");
        $("#beijingzhezhao").css("display", "none");

        tid_Quanju = 0;
        perDiv.style.background = '';
        perDiv2.style.background = '';
        perDiv3.style.filter = '';
    }
}
//写评论弹窗
function dianwo2(){
    //先登录，然后判断是否购买过，购买过可以写，没有请购买
    var rid = getParameter("rid");
    //判断用户是否登录
    $.getJSON("user/findSingleUser",{},function(user){
        if(user){
            //用户已登录，判断用户是否购买过该路线
            var flag = havebuy(rid);
            if(flag){
                //买过，再判断用户是否第一次评论该路线
                var flag2 = isSingleComment(rid);
                console.log(flag);
                if(flag2){
                    if(confirm("您已经评论过了，如要修改，请前往个人管理处修改评论。是否前往修改？")){
                        location.href="perManage.html?uid=" + user.uid;
                    }else{
                        return;
                    }
                }else{
                    if($("#zhezhao2").css("display") == 'none' && $("#beijingzhezhao2").css("display") == 'none'){
                        $("#zhezhao2").css("display","block");
                        $("#beijingzhezhao2").css("display","block");
                    }
                }
            }else{
                //没买过
                alert("必须购买过才能评论~");
            }
        }else{
            //用户未登录
            alert("您还未登录，请前往登录");
            location.href="login.html";
        }
    });
}
function hidder2(){
    if($("#zhezhao2").css("display") == 'block' && $("#beijingzhezhao2").css("display") == 'block'){
        $("#zhezhao2").css("display","none");
        $("#beijingzhezhao2").css("display","none");
    }
    $("#text_main").val('');
}
function chgColor(_this)
{
    if(perDiv) perDiv.style.background='';
    _this.style.background='#eee';
    perDiv=_this;
}
function chgColor2(_this)
{
    if(perDiv2) perDiv2.style.background='';
    _this.style.background='#eee';
    perDiv2=_this;
}
function chgColor3(_this,this_tid)
{
    if(perDiv3) perDiv3.style.filter='';
    _this.style.filter='grayscale(80%)';
    perDiv3=_this;
    tid_Quanju = this_tid;
}
//提交订单
function submitTable(){
    var rid = getParameter("rid");

    if(tid_Quanju == 0){
        alert("请选择您心仪的导游~");
        return;
    }

    //获取该线路的rid，以及发送请求到服务器
    $.getJSON("order/submitOrder",{
        rid:rid,
        tid:tid_Quanju
    },function(data){
        if(data){
            // alert("提交成功！");
            location.href="order.html?rid="+rid;
            havebuy(rid);
            countComments(rid);
            allComments(rid);
            hidder();
        }else{
            alert("提交失败~");
            hidder();
        }
    });
}
//是否已经买过
//这里定义flag，用原生ajax写是因为，会产生同步异步问题，如果用getJSON，会导致flag在回调函数中赋不上值
//问题：返回的data不是boolean型，是String（已解决）
function havebuy(rid){
    var flag = false;
    $.ajax({
        type:"GET",
        async:false,
        url:"order/haveBuy",
        data:{rid:rid},
        success:function(data){
            // console.log(typeof(data));
            if(data == "true"){
                $("#haveBuy").html("已购买");
                flag = true;
            }else{
                $("#haveBuy").html('');
                flag = false;
            }
        }
    });
    return flag;
}
//评论提交
function commLoad(){
    var rid = getParameter("rid");
    var comments = $("#text_main").val();
    $.getJSON("order/addComments",{
        rid:rid,
        comments:comments
    },function(flag){
        if(flag){
            hidder2();
            allComments(rid);
            countComments(rid);
        }else{
            alert("提交失败");
        }
    });
}
//显示该线路所有评论
function allComments(rid){
    // var rid = getParameter("rid");
    $.getJSON("order/allComments", {
        rid:rid
    }, function(data){
        var lis = "";
        for (var i = 0; i < data.length; i++) {
            var li = "";
            var username = data[i].username.substr(0,3) + "******";
            if(data[i].comments == ""){
                li='<li>' +
                    '   <span>'+username+'</span>' +
                    '   <p>'+ '该用户还未评论'+'~'+'</p>' +
                    '</li>';
                lis += li;
            }else{
                li = '<li>\n' +
                    '                        <span>'+username+'</span>\n' +
                    '                        <p>'+data[i].comments+'</p>\n' +
                    '                    </li>';
                lis += li;
            }

        }
        $("#comments_li").html(lis);
    });
}
//判断用户是否对该条线路评论过,评论过返回true，没有false
function isSingleComment(rid){
    var flag = false;
    $.ajax({
        type:"GET",
        async:false,
        url:"order/findCommentByUidAndRid",
        data:{rid:rid},
        success:function(data){
            var data2 = eval(data);
            if(data2[0].comments == "" || data2[0].comments == null || data2[0].comments == ''){
                flag = false;
            }else{
                flag = true;
            }
        }
    });
    return flag;
}
//评论数
function countComments(rid){
    $.getJSON("order/countComments",{
        rid:rid
    },function(data){
        $("#comment_num").html(data+'条评论');
    });
}