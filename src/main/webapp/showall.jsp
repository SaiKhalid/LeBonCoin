<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="services.AnnonceServices" %>
<%@ page import ="services.UserServices" %>
<%@ page import ="entity.Annonce" %>
<%@ page import ="entity.Utilisateur" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="divstyle.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="annonce-container">
  <% for (Annonce a : new AnnonceServices().getAll()) { %>
    <% for (Utilisateur u : new UserServices().getAll()) { %>
      <% if (u.getId() == a.getUser_id()) { %>
        <div class="annonce">
          <p> Poster : <%= u.getUsername() %></p>
          <p> Type d'annonce : <%=a.getType() %> </p>
          <p> Categorie : <%=a.getType_produit() %> </p>
          <p> Nom du Produit : <%=a.getNom() %> </p>
          <p> Description : <br><%=a.getDescription() %></p>
          <p> Prix : <%=a.getPrix() %> euros</p>
          <img src="<%=a.getUrl_photos() %>" width="128" height="128"> <br><br>
        </div>
      <% } %>
    <% } %>
  <% } %>
</div>
</body>
</html>