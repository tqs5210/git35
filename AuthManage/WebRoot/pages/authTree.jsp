<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>权限管理 - 权限列表</title>
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/static/css/layout.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/zTree/css/demo.css"
	type="text/css">
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/zTree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript">

       var setting = {    
        
        	/*    check:{
               enable:true,
               chkStyle: "radio",  //单选框
               radioType: "all"   //对所有节点设置单选
            },   */
            
               check:{//使用复选框
                enable:true
            },  
            data: {
                simpleData:{//是否使用简单数据模式
                    enable:true
                }
            },
            callback:{
                onCheck:onCheck
            }           
        };
         //id 标识 ，pId 父id，name 名称，open 是否展开节点， checked  是否选中        
        var zNodes = [
            { id:1, pId:0, name:"随意勾选 1", open:false},
            { id:11, pId:1, name:"随意勾选 1-1", open:true},
            { id:111, pId:11, name:"随意勾选 1-1-1"},
            { id:112, pId:11, name:"随意勾选 1-1-2",checked:true},
            { id:12, pId:1, name:"随意勾选 1-2", open:true},
            { id:121, pId:12, name:"随意勾选 1-2-1"},
            { id:122, pId:12, name:"随意勾选 1-2-2"},
            { id:2, pId:0, name:"随意勾选 2",  open:false},
            { id:21, pId:2, name:"随意勾选 2-1"},
            { id:22, pId:2, name:"随意勾选 2-2", open:true},
            { id:221, pId:22, name:"随意勾选 2-2-1"},
            { id:222, pId:22, name:"随意勾选 2-2-2"},
            { id:23, pId:2, name:"随意勾选 2-13"}
        ];

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });
            //选中复选框后触发事件
            function onCheck(e,treeId,treeNode){
            	var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
            	nodes=treeObj.getCheckedNodes(true),
            	v="";
            	//获取选中的复选框的值
            	for(var i=0;i<nodes.length;i++){
            		v+=nodes[i].id;
            		//alert(nodes[i].id); //获取选中节点的值
            		/* $("#authIdInput").val(v); */
            	}
           	 	alert(v);
            }
            
//请求添加权限        
	 function addAuth1(){ 
	 		var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
            	nodes=treeObj.getCheckedNodes(true),
            	v="";       
 			for(var i=0;i<nodes.length;i++){
            		v+=nodes[i].id;
            		//alert(nodes[i].id); //获取选中节点的值
            		/* $("#authIdInput").val(v); */
            	}
			var an=$("#authNameInput1").val();
      		var ac=$("#codeInput1").val();
      		var ad=$("#descInput1").val();
      		var au=$("#authUrlInput").val();	
      		var af=v;
      		if(!af){ 
      			af="0";
      		}
      		alert(an+ac+ad+af);
      		
      		if(!!an&&!!ac&&!!ad&&!!af){
				$.ajax({
					url:"${pageContext.request.contextPath}/auth/insertAuth.action",
					dataType:"json",
					type:"POST",
					data:{
					authName:an,
					authCode:ac,
					authDesc:ad,
					authFaId:af,
					},
					success:function(data){
						if(data.isexist=='1'){
						alert("添加成功！");
					   window.location.href="${pageContext.request.contextPath}/auth/authtree.action";						
						}
					    if(data.isexist=='0'){
						alert("此类权限已经存在");
						window.location.href="${pageContext.request.contextPath}/auth/authtree.action";
						}
					},
					error:function(){ 
					alert("执行异常");
						window.location.href="${pageContext.request.contextPath}/auth/authtree.action"; 
                		},
					});
				}else{ 
				alert("请正确填写");
				}
			}
			
			 
		function updateAuth(){
      		var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
            	nodes=treeObj.getCheckedNodes(true),
            	v="";       
 			for(var i=0;i<nodes.length;i++){
            		v+=nodes[i].id;
            		//alert(nodes[i].id); //获取选中节点的值
            		/* $("#authIdInput").val(v); */
            	}
            var an=$("#authNameInput").val();
      		var ad=$("#descInput").val();		
      		var authId =v;
      		if(!!authId){
				$.ajax({
					url:"${pageContext.request.contextPath}/auth/updateAuth.action",
					type:"POST",
					data:{
					authName:an,
					authDesc:ad,
					authId:authId,
					},					
					success:function(){
						alert("修改成功！");
					   window.location.href="${pageContext.request.contextPath}/auth/authtree.action";						
						
					},
					error:function(){ 
					alert("执行异常");
						window.location.href="${pageContext.request.contextPath}/auth/authtree.action"; 
                		},
					});
		    }else{
		    	alert("请选择要修改的权限");
		    } 
		    }
		/* $(".delete-auth-submit").click(function(){ */
		 function deleteAuth(){
      		var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
            	nodes=treeObj.getCheckedNodes(true),
            	v="";       
 			for(var i=0;i<nodes.length;i++){
            		v+=nodes[i].id;
            		//alert(nodes[i].id); //获取选中节点的值
            		/* $("#authIdInput").val(v); */
            	}	
      		var authId =v;
      		if(!!authId){
				$.ajax({
					url:"${pageContext.request.contextPath}/auth/deleteAuth.action",
					type:"POST",
					data:{
					authId:authId,
					},
					success:function(){
						alert("删除成功！");
					    window.location.href="${pageContext.request.contextPath}/auth/authtree.action";						
						
					},
					error:function(){ 
					alert("执行异常");
					window.location.href="${pageContext.request.contextPath}/auth/authtree.action"; 
                		},
					});
		    }else{
		    	alert("请选择要删除的权限");
		    }
  		}
  		/*恢复权限
  		 */
  	function reinAuth(){
      	var authId=document.getElementsByName("authId");
      	var authIds="";
			for(var i=0;i<authId.length;i++){
				if(authId[i].checked){
					if(i!=authId.length-1){
						authIds+=authId[i].value+",";
					}else if(i=authId.length-1){
						authIds+=authId[i].value;
					}
				}
			}
			alert(authIds);
      	if(!!authIds){
			$.ajax({
				url:"${pageContext.request.contextPath}/auth/reinAuth.action",
				type:"POST",
				data:{
				authIds:authIds,
				},
				success:function(){
					alert("恢复成功");
					window.location.href="${pageContext.request.contextPath}/auth/authtree.action";		
				},
					});
		    }else{
		    	alert("请选择要删除的权限");
		    }
  		}
  		
    </script>
</head>

<body>

	<!-- 头部 -->
	<jsp:include page="header.jsp" />

	<div class="container-fluid" style="margin-top: 30px;">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<jsp:include page="navibar.jsp" />
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">权限列表</h1>
				<div class="row placeholders">
					<!--添加权限表单 start-->
					<div>
						<button type="button" class="btn btn-default show-add-form" style="width:100px;"
							data-toggle="modal" data-target="#update-auth-form-div">修改权限</button>
						<button type="button" style="width:100px;" class="btn btn-primary" data-toggle="modal" data-target="#rein-auth-form-div">恢复权限</button>
						<div class="modal fade " id="update-auth-form-div" tabindex="-1"
							role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog modal-md" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="role-form-title"></h4>
									</div>
									<div class="modal-body">
										<form class="role-form">

											<!-- <input type="text" name="authId" class="form-control" id="authIdInput"> -->
											<div class="form-group">
												<label for="authNameInput">名称</label> <input type="text"
													name="authName" class="form-control" id="authNameInput"
													placeholder="要修改的权限名称">
											</div>
											<div class="form-group">
												<label for="descInput">权限描述</label> <input type="text"
													name="authGrade" class="form-control" id="descInput"
													placeholder="要修改的权限描述">
											</div>

										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-primary role-submit"
											id="checkon" onclick="updateAuth()">提交</button>
									</div>
								</div>
							</div>
						</div>
						<div class="modal fade " id="rein-auth-form-div" tabindex="-1"
							role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog modal-md" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="role-form-title">恢复权限</h4>
									</div>
									<div class="modal-body">
								<c:forEach items="${auth0}" var="auth0">
								<div><input type="checkbox" name="authId" value="${auth0.authId}"/>${auth0.authName}</div>
								</c:forEach>
							<button type="button" style="width:100px;" class="btn btn-primary" data-dismiss="modal" class="btn btn-default">取消</button>
							<button type="button" style="width:100px;" class="btn btn-primary" onclick="reinAuth()">提交</button>
						</div>
						</div>
					</div>
				</div>
				</div>
						<div class="modal fade " id="role-form-div" tabindex="-1"
							role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog modal-md" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="role-form-title"></h4>
									</div>
									<div class="modal-body">
										<form class="role-form">

											<!-- <input type="text" name="authId" class="form-control" id="authIdInput"> -->
											<div class="form-group">
												<label for="authNameInput1">名称</label> <input type="text"
													name="authName" class="form-control" id="authNameInput1"
													placeholder="权限名称">
											</div>
											<div class="form-group">
												<label for="codeInput1">权限code</label> <input type="text"
													name="authCode" class="form-control" id="codeInput1"
													placeholder="权限代码">
											</div>
											<div class="form-group">
												<label for="descInput1">权限描述</label> <input type="text"
													name="authDesc" class="form-control" id="descInput1"
													placeholder="权限描述">
											</div>
											<!-- <div class="form-group">
												<label for="descInput1">权限url</label> <input type="text"
													name="authurl" class="form-control" id="descInput1"
													placeholder="权限url">
											</div>
											<div class="form-group">
												<label for="descInput1">权限等级</label> <input type="text"
													name="authGrade" class="form-control" id="descInput1"
													placeholder="权限等级">
											</div> -->

										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-primary role-submit"
											id="checkon" onclick="addAuth1()">提交</button>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!--添加权限表单 end-->
					<div class="space-div"></div>

					<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree" style="width:1024px;"></ul>
					</div>
					<div class="space-div"></div>
					<div>
						<button type="button" class="btn btn-default show-add-form"
							data-toggle="modal" data-target="#role-form-div"
							style="width: 100px;">添加权限</button>
						<button type="button" style="width:100px;" class="btn btn-primary" onclick="deleteAuth()">删除权限</button>		
					</div>											
				</div>
			</div>
		</div>
	</div>

	<!-- 提示框 -->
	<div class="modal fade" id="op-tips-dialog" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">提示信息</h4>
				</div>
				<div class="modal-body" id="op-tips-content"></div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

</body>
</html>
