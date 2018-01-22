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
				value="ログアウト"
				onClick="location.href='file:///Users/likeit_student/Documents/git/WebProgramming/Mock/login.html'">
		</div>
	</nav>



	<br>
	<h2>ユーザ ー覧</h2>
	<br>

	<p style="color: green">${Message}</p>

	<div class="row">
		<div class="col-9"></div>
		<form action="TransitionInsertServlet" method="post">
			<div class="col-3">
				<button type="submit" class="btn btn-outline-primary"
					value="newUser">新規登録</button>
			</div>
			<br>
		</form>
	</div>

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
		<tbody>
			<c:if test="${User.id == '1' } " var="flg" />
			<c:if test="${flg}">
				<c:forEach var="item" items="${userList}">
					<tr>
						<th scope="row">${item.id}</th>
						<td>${item.name}</td>
						<td>${item.birth_date}</td>
						<td>
							<form method="post" action="UserListServlet">
								<button class="btn btn-primary" name='action' value='detail'>詳細</button>
								<button class="btn btn-success" name='action' value='update'>更新</button>
								<button class="btn btn-danger" name='action' value='delete'>削除</button>
								<input type="hidden" name="actionId" value="${item.id}">
							</form>

						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${!flg} ">
				<c:forEach var="item" items="${userList}">
					<tr>
						<th scope="row">${item.id}</th>
						<td>${item.name}</td>
						<td>${item.birth_date}</td>
						<td>
							<form method="post" action="UserListServlet">
								<button class="btn btn-primary" name='action' value='detail'>詳細</button>
								<c:if test="${item.id} == ${User.id} ">
									<button class="btn btn-success" name='action' value='update'>更新</button>
								</c:if>
								<input type="hidden" name="actionId" value="${item.id}">
							</form>

						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>



</body>
</html>
