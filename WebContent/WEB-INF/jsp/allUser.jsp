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
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>  
    <title>用户列表</title>  
      
    <script type="text/javascript">  
    function del(id){  
        $.get("<%=basePath%>user/delUser?id=" + id,function(data){  
            if("success" == data.result){  
                alert("删除成功");  
                window.location.reload();  
            }else{  
                alert("删除失败");  
            }  
        });  
    } 
   </script>
    <script type="text/javascript">  
    function serchUser(){  
        var form = document.forms[0];
        form.action = "<%=basePath%>user/getUser?id="+document.getElementById('serchid').value;  
        form.method="post";  
        form.submit();  
    }  
	</script> 
  </head>  
    
  <body>  
    <h4><a href="<%=basePath%>user/toAddUser">添加用户</a></h4>
    <form action="" name="userForm">
        	请输入学号：<input type="text" name="id" id="serchid">  
        <input type="button" value="查询" onclick="serchUser()">  
    </form>
    <table border="1" width="40%">  
        <tbody>  
            <tr> 
            	<th>学号</th>  
                <th>姓名</th>  
                <th>年龄</th>  
                <th>操作</th>  
            </tr>  
            <c:if test="${!empty userList }">  
                <c:forEach items="${userList}" var="user">  
                    <tr> 
                    	<td>${user.id }</td>  
                        <td>${user.userName }</td>  
                        <td>${user.age }</td>  
                        <td>  
                            <a href="<%=basePath%>user/getUser?id=${user.id}">编辑</a>  
                            <a href="<%=basePath%>user/delUser?id=${user.id}">删除</a>  
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
        </tbody>  
    </table>  
  </body>  
</html> 