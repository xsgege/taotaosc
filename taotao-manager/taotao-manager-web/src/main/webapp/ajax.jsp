<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script type="text/javascript" src="/taotao-manager-web/js/jquery-easyui-1.4.1/jquery.min.js"></script>  
    <script type="text/javascript">  
    $(function(){
    $("#btn").click(function(){
    
     $.ajax({  
                type:'post',  
                url:'/taotao-manager-web/ajax',  
                contentType:'application/json;charset=utf-8',     
                //数据格式是json串,商品信息  
                data:'{"title":"手机","price":999}',  
                success:function(data){//返回json结果  
                    alert(data);  
                }   
            });  
    
    })    
    })
    
    </script>
</head>
<body>
<input type="button" id="btn" value="click"/>
</body>
</html>