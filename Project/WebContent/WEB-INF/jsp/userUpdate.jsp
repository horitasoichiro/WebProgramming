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

<style>
.logoutBtn {
	margin-left: auto;
}

h2 {
	text-align: center;
	letter-spacing: 4px;
	background: linear-gradient(transparent 0%, #FFDAB9 200%);
}

.under {
	visibility: hidden;
}

thead {
	visibility: hidden;
}

.updateBtn {
	text-align: center;
}

.table td, .table th {
	vertical-align: middle;
}

hr {
	border-width: medium;
}

.container {
	background: linear-gradient(transparent 0%, #FFFACD 200%);
}

body {
	font-family: "ヒラギノ丸ゴ ProN", "Hiragino Maru Gothic ProN"
}
</style>

<title>ユーザ情報更新</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand">${sessionScope.User.name} さん</a>

		<div class="logoutBtn">
			<input class="btn btn-outline-success my-2 my-sm-0" type="button"
				value="ログアウト"
				onClick="location.href='file:///Users/likeit_student/Documents/git/WebProgramming/Mock/login.html'">
		</div>
	</nav>
	<br>
	<br>
	<div class=container>
		<h2>ユーザ情報更新</h2>
		<form action="UserUpdateServlet" method="post">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">1</th>
						<th scope="col">2</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">ログインID</th>
						<td>${oneUser.loginID}</td>
					</tr>
					<tr>

						<th scope="row">パスワード</th>
						<!-- 入力欄 -->

						<td><input type="text" class="form-control" id="password"
							name="password" placeholder="パスワード"></td>
					</tr>

					<tr>
						<th scope="row">パスワード(確認)</th>
						<td><input type="text" class="form-control" id="passwordRe"
							name="passwordRe" placeholder="パスワード(確認)"></td>
					</tr>
					<tr>
						<th scope="row">ユーザ名</th>
						<td><input type="text" class="form-control" id="userName"
							name="userName" value="${oneUser.name}"></td>
					</tr>
					<tr>
						<th scope="row">生年月日</th>
						<td><input type="date" class="form-control" id="userBirthday"
							name="userBirthday" value="${oneUser.birth_date}"></td>
					</tr>
				</tbody>

			</table>
			<input type=hidden name=truePassword value="${oneUser.password}">

			<div class="updateBtn">
				<button type="submit" class="btn btn-primary">更新</button>
			</div>
		</form>
		<hr>
		<button class="btn btn-outline-info " type="button"
			onclick="history.back()">戻る</button>
		<br>
		<div class="under">a</div>
	</div>
</body>
</html>
