<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scriptlet</title>
</head>
<body>
<h1>스크립트릿</h1>
<ol>
 <li>자바 코드의 조각을 삽입할때 사용</li>  
 <li>그냥 작성하는 텍스트이다.</li> 
</ol>
<%
String name ="홍길동";
%>

<%
 int i = 0;
 if (i==0) {
   out.print("okok");
 }
 
 out.print(name);
%>
</body>
</html>