<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>북스토어 관리 시스템</title>
    <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Noto Sans KR', sans-serif;
      }

      body {
        background-color: #f5f5f5;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
      }

      .container {
        background-color: white;
        border-radius: 10px;
        box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 500px;
        padding: 40px;
        text-align: center;
      }

      .logo {
        font-size: 40px;
        margin-bottom: 10px;
        color: #d35400;
      }

      h1 {
        color: #333;
        margin-bottom: 20px;
        font-size: 24px;
      }

      p {
        color: #666;
        margin-bottom: 30px;
        font-size: 16px;
      }

      .error-message {
        color: #e74c3c;
        margin-bottom: 15px;
        font-size: 14px;
      }

      .login-form {
        display: flex;
        flex-direction: column;
        gap: 15px;
        margin-bottom: 20px;
      }

      input {
        padding: 12px 15px;
        border: 1px solid #ddd;
        border-radius: 5px;
        font-size: 16px;
        transition: border-color 0.3s;
      }

      input:focus {
        border-color: #4A90E2;
        outline: none;
      }

      button {
        background-color: #d35400;
        color: white;
        border: none;
        border-radius: 5px;
        padding: 12px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
      }

      button:hover {
        background-color: #e67e22;
      }

      .links {
        margin-top: 20px;
        font-size: 14px;
      }

      .links a {
        color: #4A90E2;
        text-decoration: none;
        margin: 0 10px;
      }

      .links a:hover {
        text-decoration: underline;
      }
    </style>
</head>
<body>
<div class="container">
    <div class="logo">📚</div>
    <h1>Book Manage System</h1>
    <p>환영합니다. 관리자 계정으로 로그인 해주세요</p>

    <c:if test="${not empty error}">
        <p style="color:red; font-size:14px; margin-bottom:15px;">
                ${error}
        </p>
    </c:if>

    <form class="login-form" action="/login" method="post">
        <input type="text" name="username" placeholder="사용자 아이디" required>
        <input type="password" name="password" placeholder="비밀번호" required>
        <button type="submit">로그인</button>
    </form>
</div>
</body>
</html>