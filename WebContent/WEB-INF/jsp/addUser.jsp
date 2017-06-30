<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>添加用户</title>  
      
    <script type="text/javascript">  
    function addUser(){  
        var form = document.forms[0];  
        form.action = "<%=basePath%>user/addUser";  
        form.method="post";  
        form.submit();  
    }  
</script>  
  
  </head>  
    
  <body>  
    <h1>添加用户</h1>  
    <form action="" name="userForm">
        学号：<input type="text" name="id">
        <br/>   
        姓名：<input type="text" name="userName">
        <br/>   
        年龄：<input type="text" name="age">
        <br/>   
        <input type="button" value="添加" onclick="addUser()">  
    </form>  
  </body>  
</html> 