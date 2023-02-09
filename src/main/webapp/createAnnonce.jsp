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
<form action="createannonce" method ="post">
<div>
<div>
<h1>Creer une Annonce :</h1>
<label for="user_id">UserId ${user.id}</label><br>
<input name="user_id" type="number" value='<%= session.getAttribute("id") %>'><br><br>
<label for="type">Type d'annonce </label><br>
<!--<input name="type" type="text"><br><br>-->
 <select id="type" name="type">
                <option value="vente">Vente</option>
                <option value="annonce">Annonce</option>
</select><br><br>
<span> ${usernameError} </span> <br>
<label for="type_produit">Type du produit</label><br>
<input name="type_produit" type="text"><br><br>
<span> ${emailError} </span> <br>
<label for="nom">Nom du produit</label><br>
<input name="nom" type="text"><br><br>
<label for="description">Description de produit</label><br>
<input name="description" type="text"><br><br>
<label for="prix">Prix</label><br>
<input name="prix" type="number"><br><br>
<label for="url_photos">Photo URL</label><br>
<input name="url_photos" type="text"><br><br>
<input name="btnConnect" type="submit"><br><br />
</div>
</div>
</form>
</body>
</html>