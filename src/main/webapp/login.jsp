<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page    import ="java.util.Date"%> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method ="post">
<div>
<div>
<h1>Login Page</h1>
<label for="email">Email</label><br>
<input name="email" type="text"><br><br>
<label for="password">Password</label><br>
<input name="password" type="password"><br><br>
<input name="btnConnect" type="submit"><br><br />
</div>
</div>
</form>
</body>
</html>