<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/fckeditor/fckeditor.js"></script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <form action="fileUpload.action" method="post" enctype="multipart/form-data">
    	<input type="file" name="file"/>
    	<input type="submit" value="上传"/>
    </form>
   
    <br/><br/><br/>
     <form  action="filesUploads.action" method="post" enctype="multipart/form-data">
        <input type="file" name="files" /><br/>
        <input type="file" name="files"/><br/>
        <input type="file" name="files" />
       <input type="submit" value="上传"/>
    </form>
    
    
    <a href="${pageContext.request.contextPath}/upload/省体校区8楼讲师刘广2019年2月第3周回访记录.xlsx">下载</a><br/>
    <a href="download.action">online下载</a>
    
    <div>
    <script type="text/javascript">
						var sBasePath = "${pageContext.request.contextPath}/fckeditor/" ;
						var oFCKeditor = new FCKeditor("contContent") ;
						oFCKeditor.BasePath	= sBasePath ;
						oFCKeditor.ToolbarSet = 'Forum' ;
						oFCKeditor.Height = "350";
						oFCKeditor.Width = "96%";
						oFCKeditor.Value	= "" ;
						oFCKeditor.Create() ;
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					</script>
	</div>
  </body>
</html>
