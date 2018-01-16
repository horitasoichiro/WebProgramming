<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <title>ユーザ一覧</title>
    <style>
    h2{
      text-align: center;
      letter-spacing: 4px;
            background: linear-gradient(transparent 0%, #FFDAB9 200%);
    }
    hr{
      border-width: medium;
    }

    .logout{

      color:red

    }
    .coment{
      color:red;
      font-size: 0.8em;
    }
    .logoutBtn{
      margin-left: auto;
    }
    body{
      background: linear-gradient(transparent 0%, #FFFACD 200%);

      font-family: "ヒラギノ丸ゴ ProN","Hiragino Maru Gothic ProN"
    }

    </style>


  </head>
  <body>


      <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand">${sessionScope.user.name} さん</a>

      <div class="logoutBtn">
        <input class="btn btn-outline-success my-2 my-sm-0" type="button" value="ログアウト" onClick="location.href='file:///Users/likeit_student/Documents/git/WebProgramming/Mock/login.html'">
      </div>
    </nav>



<br>
    <h2>ユーザ ー覧</h2><br>
    <div class="row">
      <div class="col-9"></div>
        <div class="col-3">  <h5><a href="file:///Users/likeit_student/Documents/git/WebProgramming/Mock/registration.html">新規登録</a></h5></div>
    </div>
<form action="#" method="post">
    <div class="container">

        <div class="form-group row">
          <label for="inputLoginID" class="col-sm-2 col-form-label">ログインID</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputID" placeholder="ログインID">
          </div>
        </div>
        <div class="form-group row">
          <label for="inputPassword3" class="col-sm-2 col-form-label">パスワード</label>
          <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword" placeholder="パスワード">
          </div>
        </div>
        <div class="form-group row">
          <label for="date" class="col-sm-2 col-form-label">生年月日</label>
          <div class="col-sm-4">
          <input type="date" class="form-control" id="inputdate" placeholder="年/月/日">
          <div class="col-sm-10">
            <p class=coment> ※スラッシュで区切って入力 </p>
          </div>
          </div>
          <label for="date" class="col-1 col-form-label">〜</label>
          <div class="col-sm-4">
          <input type="date" class="form-control" id="inputdate2" placeholder="年/月/日">

        </div>
        </div>
        <div class="row">
          <div class="col-auto mr-auto"></div>
          <div class="col-auto"><button type="button" class="btn btn-primary">検索</button></div>
        </div>
    </form>
      <hr>

    <table class="table table-bordered">
  <thead class="thead-light">
    <tr>
      <th scope="col">ログインID</th>
      <th scope="col">ユーザ名</th>
      <th scope="col">生年月日</th>
      <th scope="col">
      </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">id0001</th>
      <td>田中太郎</td>
      <td>1989年04月26日</td>
      <td>
        <a class="btn btn-primary" href="file:///Users/likeit_student/Documents/git/WebProgramming/Mock/userDetails.html" role="button">詳細</a>
        <a class="btn btn-success" href="file:///Users/likeit_student/Documents/git/WebProgramming/Mock/userUpdate.html" role="button">更新</a>
        <button type="button" class="btn btn-danger" onclick="location.href='file:///Users/likeit_student/Documents/git/WebProgramming/Mock/userDelete.html'">削除</button>
      </td>
    </tr>
    <tr>
      <th scope="row">id0002</th>
      <td>佐藤二朗</td>
      <td>2001年11月12日</td>
      <td>
        <button type="button" class="btn btn-primary">詳細</button>
        <button type="button" class="btn btn-success">更新</button>
        <button type="button" class="btn btn-danger">削除</button>
      </td>
    </tr>
    <tr>
      <th scope="row">id0003</th>
      <td>佐川真司</td>
      <td>2000年01月01日</td>
      <td>
        <button type="button" class="btn btn-primary">詳細</button>
        <button type="button" class="btn btn-success">更新</button>
        <button type="button" class="btn btn-danger">削除</button>
      </td>
    </tr>
  </tbody>
</table>
<hr>

</div>

  </body>
</html>
