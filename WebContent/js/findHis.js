
$(function (){
	var mdiv=$(".mydiv");//����Ҫ���õ� ��div����
	//��ʾdiv
	$("#mInp").click(function (){
		mdiv.show(500);
	});
	$("#sp1").click(function (){
		//���div��Ԫ�� �ָ�ԭ״
		//����div
		mdiv.hide();
	});
	
	var tinp=$("input[name='inp1']");
	/*Ϊ�ı���� �����¼� ===============*/
	tinp.keyup(function (){
		$.post("user",{name:$(this).val(),flag:"getUserNameByLike"},function (data){
			//������������ؽ��
			var json=eval(data);//���صĽ�� �Ǹ�json����
			var tdiv=mdiv.children("div:first");//ѡ��Ҫ�������ݵ�div
			var forinnerHtml="";
			//�������ص�������Ϣ
			$(json).each(function (){
				forinnerHtml+="<li  class='li1'>"+this+"</li>";
			});
			tdiv.html(forinnerHtml);
    		
		});
	});
	/*Ϊ�ı���� �����¼� ===============*/
	
	
	/*�󶨲�ѯ��ť�ĵ���¼�=========*/
	$("#submitSp").click(function(){
	   $.post("message",{flag:"ajaxMess",value:tinp.val()},function (data){
	   	mdiv.children().last().html(data);
	   });
	});
   /*�󶨲�ѯ��ť�ĵ���¼�=========*/
	
	
	
	
	
});
