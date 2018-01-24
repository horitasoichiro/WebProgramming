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
<title>ユーザ一覧</title>
<style>
h2 {
	text-align: center;
	letter-spacing: 4px;
	background: linear-gradient(transparent 0%, #FFDAB9 200%);
}

hr {
	border-width: medium;
}

.logout {
	color: red
}

.coment {
	color: red;
	font-size: 0.8em;
}

.logoutBtn {
	margin-left: auto;
}

body {
	background: linear-gradient(transparent 0%, #FFFACD 200%);
	font-family: "ヒラギノ丸ゴ ProN", "Hiragino Maru Gothic ProN"
}

p {
	text-align: center;
	font-size: small;
}
</style>


</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand">${sessionScope.User.name} さん</a>

		<div class="logoutBtn">
			<input class="btn btn-outline-success my-2 my-sm-0" type="button"
				value="ログアウト" onClick="location.href='LogoutServlet'">
		</div>
	</nav>



	<br>
	<h2>ユーザ ー覧</h2>
	<br>

	<p style="color: green">${message}</p>

	<div class="row">
		<div class="col-9"></div>
		<div class="col-3">
			<a class="btn btn-outline-primary" href="./UserInsertServlet"
				role="button">新規登録</a>
		</div>

	</div>
	<br>

	<form action="UserListServlet" method="post">
		<div class="container">

			<div class="form-group row">
				<label for="inputID" class="col-sm-2 col-form-label">ログインID</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputID"
						placeholder="ログインID" name="loginId">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-sm-2 col-form-label">ユーザ名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputUserName"
						placeholder="ユーザ名" name="userName">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputdate" class="col-sm-2 col-form-label">生年月日</label>
				<div class="col-sm-4">
					<input type="date" class="form-control" id="inputdate"
						placeholder="年/月/日" name="dateStart">
					<div class="col-sm-10">
						<p class=coment>※スラッシュで区切って入力</p>
					</div>
				</div>
				<label for="date" class="col-1 col-form-label">〜</label>
				<div class="col-sm-4">
					<input type="date" class="form-control" id="inputdate2"
						placeholder="年/月/日" name="dateLast">

				</div>
			</div>
			<div class="row">
				<div class="col-auto mr-auto"></div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary">検索</button>
				</div>
			</div>
		</div>
	</form>
	<hr>
	<table class="table table-bordered">
		<thead class="thead-light">
			<tr>
				<th scope="col">ログインID</th>
				<th scope="col">ユーザ名</th>
				<th scope="col">生年月日</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<c:forEach var="item" items="${userList}">
			<tr>
				<th scope="row">${item.loginID}</th>
				<td>${item.name}</td>
				<td>${item.birth_date}</td>
				<td><a class="btn btn-primary"
					href="./UserDetailsServlet?id=${item.id}" role="button">詳細</a> <c:choose>
						<c:when
							test="${item.id == sessionScope.User.id || rootCheck.equals('root')}">
							<a class="btn btn-success"
								href="./UserUpdateServlet?id=${item.id}" role="button">更新</a>
						</c:when>
					</c:choose> <c:if test="${rootCheck.equals('root')}">
						<a class="btn btn-danger" href="./UserDeleteServlet?id=${item.id}"
							role="button">削除</a>
					</c:if></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
