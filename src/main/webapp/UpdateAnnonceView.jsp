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
<label for="user_id">UserId</label><br>
<input name="user_id" type="number" value='${annonce.user_id}'><br><br>
<label for="type">Type d'annonce (Vente/Service)</label><br>
<input name="type" type="text" value='${annonce.type}'><br><br>
<span> ${usernameError} </span> <br>
<label for="type_produit">Type du produit </label><br>
<input name="type_produit" type="text" value='${annonce.type_produit}'><br><br>
<span> ${emailError} </span> <br>
<label for="nom">Nom du produit</label><br>
<input name="nom" type="text" value='${annonce.nom}'><br><br>
<label for="description">Description de produit</label><br>
<input name="description" type="text" value='${annonce.description}'><br><br>
<label for="prix">Prix</label><br>
<input name="prix" type="number" value='${annonce.prix}'><br><br>
<label for="url_photos">Photo URL</label><br>
<input name="url_photos" type="text" value='${annonce.url_photos}'><br><br>
<input name="btnConnect" type="submit"><br><br />
</div>
</div>
</form>
</body>
</html>