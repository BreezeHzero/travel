$(function () {
    findCountOfEveryRoute();
    findAllComments();
});
function findAllComments(){
    $.getJSON("order/findAll",{},function(data){
        var lis = "";
        for (var i = 0; i < data.length; i++) {
            var rnameStr = data[i].rname.substr(0,45) + "···";
            var commentsStr =  data[i].comments.substr(0,200) + "···";
            var usernameStr = data[i].username.substr(0,1) + "****：";
            var li = "";
            li = '<li>\n' +
                '                    <div class="in_title">\n' +
                '                        <div class="in_title_line">\n' +
                '                            <h3><a href="route_detail.html?rid='+data[i].rid+'">'+rnameStr+'</a></h3>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                    <div class="in_main">\n' +
                '                        <span>'+usernameStr+'</span>\n' +
                '                        <p>'+commentsStr+'</p>\n' +
                '                    </div>\n' +
                '                </li>';
            lis += li;
        }
        $("#allComm").html(lis);
    });
}
function findCountOfEveryRoute(){
    $.getJSON("order/findCountOfEveryRoute",{},function (data) {
        // var lis = "";
        // var j = 1;
        var i = data.length-1;
        var j = 4;
        var x = 4;
        //总共遍历4次
        for (j; j > 0; j--) {
            // 每次遍历12次
            var lis = "";
            var arr = new Array();
            for (i; i >= 0; i--) {
                var rnameStr = data[i].rname.substr(0,45) + "···";
                var li = "";
                li = '                    <li>\n' +
                    '                        <div class="route_img_left"><img src="'+data[i].rimage+'"></div>\n' +
                    '                        <div class="route_info_right">\n' +
                    '                            <div class="info_title">\n' +
                    '                                <a href="route_detail.html?rid='+data[i].rid+'">'+rnameStr+'</a>\n' +
                    '                            </div>\n' +
                    '                            <div class="info_tip">\n' +
                    '                                <p>报名时间：提前1天报名</p>\n' +
                    '                            </div>\n' +
                    '                            <div class="priceNumebr">\n' +
                    '                                <span>&yen;'+data[i].price+'起/人</span>\n' +
                    '                                <p>'+data[i].ordernum+'位游客已报名</p>\n' +
                    '                            </div>\n' +
                    '                        </div>\n' +
                    '                    </li>\n';

                //让li倒序
                arr.push(li);
                /*lis += li;*/
                //如果可以被3整除，把lis加入item，退出当前循环进入下一次循环
                if(i%3 == 0){
                    for (var y = arr.length-1; y >= 0; y--){
                        lis += arr[y];
                    }
                    $(".slick-slide:nth-of-type("+ x +")").html(lis);
                    x--;
                    i = --i;
                    break;
                }
                // $(".slider").html();
            }

        }
    });
}