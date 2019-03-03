/*改变字体颜色*/ 
 /*
 function changeColor(color){
 //获得下拉列表里的值 （颜色）
 // 找到对应的font标签 
   var fonts=document.getElementsByTagName

("font");
   for(var i=0;i<fonts.length;i++){
   	  fonts[i].attributes[0].value=color;
   }
  }
  */
 // 设置其属性为相应的颜色
 function changeColor(color){
 	$(".font1").attr("color",color);
 }
 /*改变字体颜色*/
 $(function (){
 	/*图片变大功能=============================*/
	$(".myImg").hover(function (p){
		//鼠标进入事件
		//获得小图的图片路径
		var imgSrc=$(this).attr("src");
		//创建一个图片节点 准备向页面中插入
		var imgObj=$("<div class='tagDiv'> <img src="+imgSrc+"></img> </div>");
		$("body").append(imgObj);
		//设置div的样式 （使用json格式）
		$(".tagDiv").css({
			top:p.pageY+"px",
			left:p.pageX+"px",
			position:"absolute",
			display:"none"
		}).show(500);
		console.log("y"+p.pageY);
	},function(){
		//鼠标离开事件
		$(".tagDiv").remove();
		console.log("heihei");
	});
	/*图片变大功能=============================*/
	
	
 	/*表格各行换色*/
	$(".mytr:odd").css("background-color","#c3f3c3");
	$(".mytr:even").css("background-color","#f3c3f3");
	/*表格各行换色*/
	
	/*鼠标经过换色          */
	//绑定鼠标事件
	$(".mytr").mouseover(function(){
		$(this).css("background-color","#f3f3f3");
	}).mouseout(function(){
		$(".mytr:odd").css("background-color","#c3f3c3");
	    $(".mytr:even").css("background-color","#f3c3f3");
	});
	/*鼠标经过换色         */
	
	
	/*隐藏一些与显示全部*/
	$("#shBtn").click(function (){
		//隐藏
		var  trs=$(".mytr:gt(4)");
		if(trs.is(":hidden")){//如果被选中的是隐藏状态
			trs.show(1000);
			$(this).val("隐藏一些");
		}else {//显示状态
			trs.hide(1000);
			$(this).val("显示全部");
		}
		//显示
	});
	/*隐藏一些与显示全部*/
	
	
	
 });
 