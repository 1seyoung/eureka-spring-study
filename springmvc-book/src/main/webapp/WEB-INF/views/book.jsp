<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>북스토어 관리자 홈</title>
    <style>
      body {
        background-color: #f5f5f5;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        font-family: 'Noto Sans KR', sans-serif;
      }

      .container {
        background-color: white;
        border-radius: 10px;
        padding: 40px;
        box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        text-align: center;
        max-width: 500px;
        width: 100%;
      }

      .logo {
        font-size: 40px;
        margin-bottom: 10px;
        color: #d35400;
      }

      h1 {
        font-size: 24px;
        color: #333;
        margin-bottom: 20px;
      }

      p {
        font-size: 16px;
        color: #555;
        margin-bottom: 20px;
      }

      a {
        text-decoration: none;
        color: #d35400;
        font-size: 14px;
      }

      a:hover {
        text-decoration: underline;
      }
    </style>
</head>
<body>
<div class="container">
    <div class="logo">📚</div>
    <h1>환영합니다, <c:out value="${sessionScope.username}"/>님!</h1>
    <p>북스토어 관리자 시스템에 오신 것을 환영합니다.</p>

    <a href="/logout">로그아웃</a>
</div>
</body>
</html>