<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="services.AnnonceServices" %>
<%@ page import ="entity.Annonce" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="UTF-8">
<title>Annonce <%= session.getAttribute("user_id") %></title>
</head>
<body>
<form>
<div >
<div>
<p>Type d'annonce: <%= session.getAttribute("type") %></p><br><br>
<p>Nom: <%= session.getAttribute("nom") %></p><br><br>
<p>Type de Produit: <%= session.getAttribute("type_produit") %></p><br><br>
<p>Description: <%= session.getAttribute("description") %></p><br><br>
<p>Prix: <%= session.getAttribute("prix") %></p><br><br>
<img src="<%= session.getAttribute("url_photos") %>" alt="W3Schools.com" width="128" height="128"> <br><br>

<a href='/LeBonCoin/updateannonce?annonce_id=${annonce_id}'>Update Annonce</a><br><br>
<a href='/LeBonCoin/deleteannonce?annonce_id=<%= session.getAttribute("user_id") %>'>Delete Annonce</a>
<a href='/LeBonCoin/myitems?id=${email}'>Delete Profile</a>
</div>
</div>
</form>
</body>
</html>