<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="services.UserServices" %>
<%@ page import ="entity.Utilisateur" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<div >
<div>
<h1>WELCOME <%= session.getAttribute("username") %></h1><br><br>
<a href='/LeBonCoin/showall'>Voir toutes les Annonces</a>
<p>Username: <%= session.getAttribute("username") %></p><br><br>
<p>Email: <%= session.getAttribute("email") %></p><br><br>
<p>Age: <%= session.getAttribute("age") %></p><br><br>
<img src="<%= session.getAttribute("url_photo") %>"> <br><br>
<a href='/LeBonCoin/update?id=${email}'>Update Profile</a>
<a href='/LeBonCoin/delete?id=${email}'>Delete Profile</a>
<a href='/LeBonCoin/createannonce?user_id= <%= session.getAttribute("user_id") %>'>Creer Annonce</a>
<a href='/LeBonCoin/myitems?user_id=${user_id}'>Voir mes Annonces</a>
</div>
</div>
</form>
</body>
</html>