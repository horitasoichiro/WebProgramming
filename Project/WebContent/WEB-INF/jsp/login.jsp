<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!doctype html>
<html lang="ja">

  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <style>
    .container{
      max-width: 300px;
      background: linear-gradient(transparent 0%, #FFFACD 200%);
    }
    h3{
      text-align:center;
      letter-spacing: 4px;
      background: linear-gradient(transparent 0%, #FFDAB9 200%);
    }
    .loginBtn{
      text-align: center;
    }
    p{
    text-align: center;
    font-size : small;
    }
    body{
      font-family: "ヒラギノ丸ゴ ProN","Hiragino Maru Gothic ProN"



    }





    </style>


    <title>ログイン</title>

  </head>
  <body>

<div class="container">
    <br>
<form action="LoginServlet" method="post">
  
  <h3>ログイン画面</h3>
<br>
    <p style="color: red">
        ${errorMessage}
    </p>







          <div class="row">
            <div class="col align-self-center">
          <input type="text" class="form-control" id="inputID" placeholder="ログインID" name="loginID">
        <br>
          <input type="password" class="form-control" id="inputPassword" placeholder="パスワード" name="password">
          <br>
        </div>
      </div>
          <div class=loginBtn>
            <input class="btn btn-primary" type="submit" value="ログイン">
          </div>
          </form>
          <br>
  </div>



</body>
</html>
