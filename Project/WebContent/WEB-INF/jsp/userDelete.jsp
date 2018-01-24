<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="./css/bootstrap.min.css">

<title>ユーザ削除確認</title>

<style>
.col-4-center {
	margin: 10px;
}

.logoutBtn {
	margin-left: auto;
}

h2 {
	text-align: center;
	letter-spacing: 4px;
	background: linear-gradient(transparent 0%, #FFDAB9 200%);
}

.gaizinn {
	text-align: center;
}

body {
	background: linear-gradient(transparent 0%, #FFFACD 200%);
	font-family: "ヒラギノ丸ゴ ProN", "Hiragino Maru Gothic ProN"
}
</style>

</head>

<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand">${sessionScope.User.name} さん</a>


			<div class="logoutBtn">
				<input class="btn btn-outline-success my-2 my-sm-0" type="button"
					value="ログアウト"
					onClick="location.href='LogoutServlet'">
			</div>
		</nav>

	<br>
	<div class="container">

		<h2>ユーザ削除確認</h2>
		<br>
		<div class="row justify-content-center">
			<div class="col-6-start">
				<p>ログインID : ${oneUser.loginID}</p>
				<p>を本当に削除してよろしいですか？</p>
			</div>

		</div>
		<br>
		<div class="row justify-content-center">
			<div class="col-4-center">
				<input class="btn btn-info" type="button" value="キャンセル"
					onClick="history.back()">

			</div>

			<form action="UserDeleteServlet" method="post">
				<div class="col-4-center">
					<input class="btn btn-danger " type="submit" value=" &nbsp;&emsp;削除&emsp;&nbsp; ">
					<input type=hidden name=deleteId value="${oneUser.id}">
				</div>

			</form>
		</div>
	</div>
	<br>
	<br>
	<p class="gaizinn">
		<img src="http://kids.wanpug.com/illust3825thumb.gif" alt="外人"
			width="120" height="120" />
	</p>



</body>

</html>
