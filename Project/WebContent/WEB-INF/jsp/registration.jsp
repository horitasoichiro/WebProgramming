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
<title>ユーザ登録</title>
<style>
.logoutBtn {
	margin-left: auto;
}

h2 {
	text-align: center;
	letter-spacing: 4px;
	background: linear-gradient(transparent 0%, #FFDAB9 200%);
}

.registBtn {
	text-align: center;
}

.coment {
	color: red;
	font-size: 0.8em;
}

.under {
	visibility: hidden;
}

.container {
	max-width: 800px;
}

body {
	background: linear-gradient(transparent 0%, #FFFACD 200%);
	font-family: "ヒラギノ丸ゴ ProN", "Hiragino Maru Gothic ProN"
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand">ユーザ名 さん</a>

		<div class="logoutBtn">
			<input class="btn btn-outline-success my-2 my-sm-0" type="button"
				value="ログアウト"
				onClick="location.href='file:///Users/likeit_student/Documents/git/WebProgramming/Mock/login.html'">
		</div>
	</nav>
	<br>
	<h2>ユーザ新規登録</h2>
	<br>

	<div class=container>
		<form action="UserInsertServlet" method="post">
			<div class="form-group row">
				<label for="inputLoginID" class="col-sm-2 col-form-label offset-2">ログインID</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="inputID" name = "loginId"
						placeholder="ログインID">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-sm-2 col-form-label offset-2">パスワード</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="inputPassword" name = "password"
						placeholder="パスワード">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputRePassword"
					class="col-sm-2 col-form-label offset-2">パスワード(確認)</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="inputRePassword" name = "passwordRe"
						placeholder="パスワード(確認)">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputUserName" class="col-sm-2 col-form-label offset-2">ユーザ名</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="inputUserName" name = "name"
						placeholder="ユーザ名">
				</div>
			</div>
			<div class="form-group row">
				<label for="date" class="col-sm-2 col-form-label offset-2">生年月日</label>
				<div class="col-sm-6">
					<input type="date" class="form-control" id="inputdate" name = "birthDate"
						placeholder="年/月/日">
					<div class="col-sm-10">
						<!-- <p class=coment> ※スラッシュで区切って入力 </p> -->
						<br>
					</div>
				</div>
			</div>
			<div class="registBtn">
				<input class="btn btn-primary" type="submit" value="登録">
			</div>
		</form>
	</div>
	<br>
	<div class="returnBtn">
		<button class="btn btn-outline-info " type="button"
			onclick="history.back()">戻る</button>
	</div>

	<div class="under">a</div>
</body>

</html>
