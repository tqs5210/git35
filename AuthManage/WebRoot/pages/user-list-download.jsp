<%@ page language="java" pageEncoding="gbk"%>
<%@ page contentType="application/msword" %>  
<%-- 
Wordֻ��Ҫ��contentType="application/msexcel"��ΪcontentType="application/msword" 
--%>
<%   
  //������excel���   
  //response.setHeader("Content-disposition","attachment; filename=MyExcel.xls");   
  
//Ƕ����ie���excel   
  
//response.setHeader("Content-disposition","inline; filename=MyExcel.xls");   
  
response.setHeader("Content-disposition","inline; filename=MyExcel.doc");   
%>  
<html>  
<head>  
<title>���Ե���Excel��Word</title>  
</head>  
<body>  
<table width="500" border="1" align="center">  
  <tr>  
    <td colspan="4" align="center">���Ӳ�Ʒ����ͳ��</td>  
  </tr>  
  <tr>  
    <td width="7%">������</td>  
    <td width="7%">��ѹ</td>  
    <td width="18%">����</td>  
    <td width="68%">����</td>  
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
