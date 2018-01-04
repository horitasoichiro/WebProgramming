<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

String[] luckList = {"大吉","中吉","小吉","凶"};

int index = (int)(Math.random()*4);
String luck = luckList[index];

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おみくじプログラム</title>
</head>
<body>
<p>あなたの運勢は<%=luck %>です。</p>
<input type="text" name="名前"><br>
<input type="radio" name="名前" value="値">
ボタン




<input type="radio" name="名前" value="値"><br>
<input type="submit" value="送信">
</body>
</html>