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
<form action="create" method ="post">
<div>
<div>
<h1>Create an account :</h1>
<label for="username">Username</label><br>
<input name="username" type="text"><br><br>
<span> ${usernameError} </span> <br>
<label for="email">Email</label><br>
<input name="email" type="text"><br><br>
<span> ${emailError} </span> <br>
<label for="age">Age</label><br>
<input name="age" type="number"><br><br>
<label for="password">Password</label><br>
<input name="password" type="password"><br><br>
<span> ${passwordError} </span> <br>
<label for="url_photo">Photo URL</label><br>
<input name="url_photo" type="text"><br><br>
<input name="btnConnect" type="submit"><br><br />
</div>
</div>
</form>
</body>
</html>