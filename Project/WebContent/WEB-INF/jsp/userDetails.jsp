<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
      background: linear-gradient(transparent 0%, #FFFACD 200%);
    }
      .logoutBtn{
        margin-left: auto;
      }
      h2{
        text-align: center;
        letter-spacing: 4px;
        background: linear-gradient(transparent 0%, #FFDAB9 200%);
      }

      thead,.under {
        visibility: hidden;
        }
        hr{
          border-width: medium;
        }
        body{

          font-family: "ヒラギノ丸ゴ ProN","Hiragino Maru Gothic ProN"
        }
    </style>

    <title>ユーザ情報詳細参照</title>
    </head>
    <body>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand">${sessionScope.User.name}　さん</a>

      <div class="logoutBtn">
        <input class="btn btn-outline-success my-2 my-sm-0" type="button" value="ログアウト" onClick="location.href='file:///Users/likeit_student/Documents/git/WebProgramming/Mock/login.html'">
      </div>
    </nav>
    <br>
    <br>
    <div class=container>
          <h2>ユーザ情報詳細参照</h2>
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
            <th scope="row">ユーザ名</th>
            <td>${oneUser.name}</td>
          </tr>
          <tr>
            <th scope="row">生年月日</th>
            <td>${oneUser.birth_date}</td>
          </tr>
          <tr>
            <th scope="row">登録日時</th>
            <td>${oneUser.create_date}</td>
          </tr>
          <tr>
            <th scope="row">更新日時</th>
            <td>${oneUser.update_date}</td>

          </tr>
        </tbody>
      </table>

      <br>
    <button class="btn btn-outline-info " type="button" onclick="history.back()">戻る</button>
      <br>
    <div class="under">a</div>
    </div>
    </body>
  </html>
