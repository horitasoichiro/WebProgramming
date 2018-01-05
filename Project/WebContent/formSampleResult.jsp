<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <% --%>

<!-- /* request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String gender = request.getParameter("gender"); */ -->

<%-- %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力内容表示</title>
</head>
<body>

<p>名前：<c:out value="${param.name}"/></p>

<p>性別：<c:out value="${param.gender}"/></p>




<%-- <p>名前：<%= name %></p>
<br>
<p>性別：<%= gender %></p> --%>

</body>
</html>

