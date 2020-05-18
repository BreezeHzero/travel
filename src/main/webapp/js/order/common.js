$(function(){
	init_area();
	getTotal();
	$('.iDo-main').iDoform();
	$("#p1").Spinner({name:"p1-nums"});
	$("#p2").Spinner({name:"p2-nums"});
	$("#p3").Spinner({name:"p3-nums"});
	$("#p4").Spinner({name:"p4-nums"});
	$('.iDo-list-li-d1 [type="checkbox"]').each(function(){$(this).change(function(){getTotal()})});
	$('.Spinner a').each(function(){$(this).click(function(){getTotal()})});
});





function getTotal() {
	var lirow = $('.iDo-list-li');
	var total = 0;

	$('.iDo-list-li').each(function(index, element) {
		if($(this).find('.iDo-list-li-d1 [type="checkbox"]').is(':checked')){
			nums = parseInt($(this).find('.Amount').val());
			price = parseFloat($(this).find('.iDoformHidden').attr('price'));
			subtotal = nums * price;
			$(this).find('.subtotal').html("¥"+subtotal.toFixed(2)+"元");
			total += subtotal;
		}
	});

	$('.iDo-list-li-count span').html("¥"+total.toFixed(2));
}