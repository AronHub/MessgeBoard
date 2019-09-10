$(document).ready(function(){
	$("#deploye").click(function(){
		$(".fubull").css("display","block");
		$(".addView").css("display","block");
	})
	
	$("#cancel").click(function(){
		$(".fubull").css("display","none");
		$(".addView").css("display","none");
	})
	
	$("#deploy").click(function(){
       var receve=$("#receve").val();
	   var sendContext=$("#sendContext").val();
	   
	   $.ajax({
		   async:true,
		   url:base.domain+"message/messageAdd" ,
		   data:{
			   receve:receve,
			   sendContext:sendContext
		   },
		   success:function(data){
			   if(data=="success"){
				   alert("保存成功!");
			   }else{
				   alert("保存失败!");
			   }
			 
		   },error:function(){
			   
		   }
		   
	   })
	   
	})
	
})