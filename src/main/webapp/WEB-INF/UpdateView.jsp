<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method ="post">
<div>
<div>
<h1>Update :</h1>

<label for="email">Email</label><br>
<input name="email" type="email" value='${user.email}'><br><br>

<label for="username">Username</label><br>
<input name="username" type="text" value='${user.username}'><br><br>

<label for="password">Password</label><br>
<input name="password" type="password" value='${character.password}'><br><br>

<label for="age">Age</label><br>
<input name="age" type="number" value='${user.age}'><br><br>

<label for="url_photo">Photo URL</label><br>
<input name="url_photo" type="text" value='${user.url_photo}'><br><br>



<input name="btnConnect" type="submit"><br><br />
</div>
</div>
</form>
</body>
</html>