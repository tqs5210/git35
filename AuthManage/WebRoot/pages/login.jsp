<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>登录页面</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">
   <style type="text/css">
   	.red{color:red}
   	.red01{color:pink}
   </style>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.cookie.js"></script>
   
   <script type="text/javascript">	
   
  $(document).ready(function(){
	// $("h3").css("color","red");
	  // $("h3").removeClass("red").addClass("red01");
	//$("button").width(100);
	
	/* $("#inputEmail").blur(function (){
		alert("blur");
	}).focus(function (){
	    alert("focus");
	}); */
	
	/* 
	$("#inputEmail").change(function (){
		alert($(this).val());
	}) */
	
	/*  $("#inputEmail").click(function (){
		alert("click.....");
	}); 
	 */
	/*  $("#inputEmail").bind("click",function (){
		alert("bind click.....");
	}); 
	 $("#input Email").unbind("change");*/
	
	 /* $("#inputEmail").mouseover(function (){
		alert("mouseover.....");
	}).mouseout(function(){
	   alert("mouseout.....");
	}); */
	//$("#inputEmail").val("admin123");
	//alert($("#inputEmail").val());
	//alert($("#checkboxid").text());
	//alert($.trim($("#checkboxid").text()));
	//console.log("11111111111");
	
	//$("#checkboxid").attr("title","你好");
	$("#inputEmail").click(function (){
	    $("#checkboxid").show();
	});
	
	$("#inputPassword").click(function (){
		$("#checkboxid").hide();
	});
	
	});
  
    var flag=false;	
	$(document).ready(function(){
		$("#inputCode").blur(function (){	
		var vCode=$("#inputCode").val();
	 	 if(!!vCode){
	 	 	$.ajax({  
	                type:"POST", //请求方式 
	                url:"${pageContext.request.contextPath}/user/validCode.action",
	                dataType:"json", //返回数据类型
	                 data:{//请求参数
	               		vCode:vCode
	                },
	                success:function(data){ //请求成功后 200
	                	if(data.msg=='1'){
	                      	flag=true;
                      	 	//alert("验证码正确！");
                      	 	$("#error_html").removeClass("red").html("");
                       }else{
                        	//alert("验证码不正确！");
                        	$("#error_html").addClass("red").html("验证码不正确!");
                        	flag=false;
                       }
	                },
	                error:function (){//500 400
	                	alert("系统出现异常！");
	                }    
	         }); 
	         
         }else{
           flag=false;
           alert("验证码不能为空")
         }
         
	} );
	
	});
		
	function login(){
		var userName=$("#inputEmail").val();//获取用户名
		var psw=$("#inputPassword").val();
		var vCode=$("#inputCode").val();
			if(!/^\w{4,16}$/.test(userName)){
				//alert("用户名不合法! 4-16位，字母，数字，下划线");
				$("#userNameError").addClass("red").html("用户名不合法! 4-16位，字母，数字，下划线");
				return false;
			}else if(psw.length>20 || psw.length<6){
			    alert("密码不合法! 6-20位，字母，数字");
				return false;
			}else if(!flag){
				alert("验证码不正确！");
				return false;
			}else{
			
				$.ajax({  
	                type:"POST",  
	                url:"${pageContext.request.contextPath}/user/login.action",
	                dataType:"json",  
	                data:{
	                	vCode:vCode,
	               		userPwd:psw,
	                	userCode:userName
	                },  
	                success:function(data){ 
	                  if( data.res=="1"){
		                  /*  //登录成功
		                 var chc=$("input[name='rememberMe']:checked"); 
		                  //判断checkbox是否被选中
		                  if(!!chc){
		                    $.cookie("userName", userName,{expires:7});
		                   // $.cookie("token", token);
		                  }else{
		                  	//清空
		                  	$.cookie("userName", null);
		                   } */
	                 	  window.location.href="${pageContext.request.contextPath}/index.action";
	                  }else if(data.res=="0"){
	                  	alert("验证码错误！");
	                  	return false;
	                  }else{
	                  	alert("登录失败");
	                  	return false;
	                  }
	                },
	                error:function (){
	                   alert("系统错误！");
	                }   
         });
	}

	}
</script>
  </head>
  
  <body>
    	<form class="form-signin" method="post" action="##">
        <h3 class="form-signin-heading">请登录</h3>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" id="inputEmail" class="form-control class123456" placeholder="用户名"  name="username" maxlength="20" value="admin" >
         <label id="userNameError"></label>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password"  id="inputPassword" class="form-control" placeholder="密码" name="password" maxlength="10">
       <label id="pswerror"></label><br/>
        <label for="inputEmail" class="sr-only" >验证码</label>
        <input type="text" id="inputCode" placeholder="验证码" name="code" tabindex="6" style="width:80px;text-transform:uppercase;ime-mode:disabled" maxlength="4">
        <img id="vdimgck"  src="${pageContext.request.contextPath}/pages/image.jsp?d="+new Date()+"" alt="看不清？点击更换" align="absmiddle" width="75" style="cursor:pointer" onclick="this.src=this.src+'?'" />
      	<label id="error_html" style="font-size:18px;"></label>
       <div class="checkbox" id="checkboxid" style="display:none">
          <label>
            <input type="checkbox" name="rememberMe"> 记住我&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           </label>
        </div>
        <p class="bg-warning">${error}</p>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="return login()" >登录</button>
     <br/>
	     <!-- <div class="container">
	       <select name="select123" id="select123" style="width:100px">
		    <option value="1" >1</option>
		    <option value="2" >2</option>
		    <option value="3" >3</option>
	    </select> 
	    </div> -->
      </form>
    
  
     
    
    </div> <!-- /container -->
    
    
    
</body>
</html>
