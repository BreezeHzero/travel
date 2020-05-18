 (function(win,doc,undefined){
 	var zturn=function(turn){
 		this.turn=turn
 		this.zturn=$("#"+turn.id)
 		this.X=0
 		this.timer=""
 		this.zturnitem=this.zturn.children(".zturn-item")
 		this.num_li=this.zturnitem.length//轮播元素个数 zturnPy为每个的偏移量
 		this.zturnPy=turn.Awidth/(this.num_li-1)  
 		this.init()
 		this.turn_()
 		this.auto_play()
 		return this
 	}
 	zturn.prototype={
 		constructor:zturn,
 		 init:function(){
 		 		var _self = this;
				this.zturn.children(".zturn-item").each(function(index,element){	 		
								//index是第几个元素 X是选取的中间数 num_li是总数
							var rt=1//1:右侧：-1：左侧
							if((index-_self.X)>_self.num_li/2||(index-_self.X)<0&&(index-_self.X)>(-_self.num_li/2)){rt=-1}//判断元素左侧还是右侧
							var i=Math.abs(index-_self.X);//取绝对值
							if(i>_self.num_li/2){i=parseInt(_self.X)+parseInt(_self.num_li)-index;}//i:是左或者右的第几个
							if((index-_self.X)<(-_self.num_li/2)){i=_self.num_li+index-_self.X}
							$(this).css({
								'position':'absolute',
								'left': '50%',
								'margin-left':-_self.turn.width/2+_self.zturnPy*rt*i+"px",
								'z-index':_self.num_li-i, 
								'opacity': Math.pow(_self.turn.opacity,i),
								'transform':'scale('+Math.pow(_self.turn.scale,i)+')',
								'-webkit-transform':'scale('+Math.pow(_self.turn.scale,i)+')',
								'-webkit-transform':'scale('+Math.pow(_self.turn.scale,i)+')',
								'-moz-transform':'scale('+Math.pow(_self.turn.scale,i)+')',
								'-ms-transform':'scale('+Math.pow(_self.turn.scale,i)+')',
								'-o-transform':'scale('+Math.pow(_self.turn.scale,i)+')'
							})
							$(this).attr("data_n",index)
					})
 		 },
 		 turn_:function(){
 		 	var _self=this
 		 	this.zturnitem.click(function(){	 			
 		 		_self.X=$(this).attr("data_n")
 		 		_self.init()
 		 	})
 		 	this.zturnitem.hover(function(){
 		 		clearInterval(_self.timer)
 		 		_self.timer=""
 		 	})
 		 	this.zturnitem.mouseleave(function(){
 		 		_self.auto_play()
 		 	})
 		 },
 		 prev_:function(){
 		 		var _self=this
 		 		this.X--
				if(this.X<0){this.X=this.num_li-1}
 		 		this.init()
 		 },
 		next_:function(){
 		 		var _self=this
 		 		this.X++
				if(this.X>=this.num_li){this.X=0}
 		 		this.init()
 		},
 		auto_play:function(){
 			
 			var _self=this;
 			var turning=5000
 			if(this.turn.turning){turning=this.turn.turning}
 			if(_self.turn.auto){
 				_self.timer=setInterval(function(){
 				_self.next_()
 				},turning)
 			}
 		}
 	} 	
 		win.zturn = zturn;
 }(window,document))
 











