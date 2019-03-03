
$(function (){
	var mdiv=$(".mydiv");//经常要是用的 主div对象
	//显示div
	$("#mInp").click(function (){
		mdiv.show(500);
	});
	$("#sp1").click(function (){
		//清空div中元素 恢复原状
		//隐藏div
		mdiv.hide();
	});
	
	var tinp=$("input[name='inp1']");
	/*为文本框绑定 键盘事件 ===============*/
	tinp.keyup(function (){
		$.post("user",{name:$(this).val(),flag:"getUserNameByLike"},function (data){
			//处理服务器返回结果
			var json=eval(data);//返回的结果 是个json对象
			var tdiv=mdiv.children("div:first");//选择要插入内容的div
			var forinnerHtml="";
			//遍历返回的人名信息
			$(json).each(function (){
				forinnerHtml+="<li  class='li1'>"+this+"</li>";
			});
			tdiv.html(forinnerHtml);
    		
		});
	});
	/*为文本框绑定 键盘事件 ===============*/
	
	
	/*绑定查询按钮的点击事件=========*/
	$("#submitSp").click(function(){
	   $.post("message",{flag:"ajaxMess",value:tinp.val()},function (data){
	   	mdiv.children().last().html(data);
	   });
	});
   /*绑定查询按钮的点击事件=========*/
	
	
	
	
	
});
