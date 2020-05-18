$(function() {
    $(".contactusdiyou").hover(function() {
        $(".hoverimg").attr("src","images/hoverbtnbg1.gif");
        $('.contactusdiyou').stop().animate({right:'0'},300);
        $('.diyoumask').stop().fadeIn();
    }, function() {
        $(".hoverimg").attr("src","images/hoverbtnbg.gif");
        $('.contactusdiyou').stop().animate({right:'-230px'},300,function(){});
        $('.diyoumask').stop().fadeOut();
    });
});