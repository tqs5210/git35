<%@ page language="java" pageEncoding="gbk"%>
<%@ page contentType="application/msword" %>  
<%-- 
Word只需要把contentType="application/msexcel"改为contentType="application/msword" 
--%>
<%   
  //独立打开excel软件   
  //response.setHeader("Content-disposition","attachment; filename=MyExcel.xls");   
  
//嵌套在ie里打开excel   
  
//response.setHeader("Content-disposition","inline; filename=MyExcel.xls");   
  
response.setHeader("Content-disposition","inline; filename=MyExcel.doc");   
%>  
<html>  
<head>  
<title>测试导出Excel和Word</title>  
</head>  
<body>  
<table width="500" border="1" align="center">  
  <tr>  
    <td colspan="4" align="center">电子产品测试统计</td>  
  </tr>  
  <tr>  
    <td width="7%">条形码</td>  
    <td width="7%">电压</td>  
    <td width="18%">电流</td>  
    <td width="68%">功率</td>  
  </tr>  
  <tr>  
    <td>20061006</td>  
    <td>xxx</td>  
    <td>xxx</td>  
    <td>xxxxx</td>  
  </tr>  
  <tr>  
    <td>20061007</td>  
    <td>xx</td>  
    <td>xxx</td>  
    <td>xxxxx</td>  
  </tr>  
  <tr>  
    <td>20061008</td>  
    <td>xx</td>  
    <td>xxx</td>  
    <td>xxxxx</td>  
  </tr>  
</table>  
</body>  
</html>  
