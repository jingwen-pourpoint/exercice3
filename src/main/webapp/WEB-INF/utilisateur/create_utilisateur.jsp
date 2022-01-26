<%@page import="BlogDemoFormation.beans.Utilisateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creation utilisateur</title>
</head>
<body>
	<h1>Ajouter un utilisateur</h1>
	<br>
	<% 
		if (request.getAttribute("message") != null) {
			String message = request.getAttribute("message").toString();
			if (message != null) {
				out.println(message);
				out.println("<br>");
				out.println("<br>");
			}
		}
	%>
	<form action="" method="post">
		<label for="nom">Nom : </label>
		<br>
		<input type="text" id="nom" name="nom">
		<br>
		<br>
		<label for="prenom">Prenom : </label>
		<br>
		<input type="text" id="prenom" name="prenom">
		<br>
		<br>
		<label for="email">Email : </label>
		<br>
		<input type="text" id="email" name="email">
		<br>
		<br>
		<input type="submit" value="Ajouter l'utilisateur">
	</form>
	
	<br>
	<br>
	<br>
	<h2>Voici la liste de vos utilisateurs : </h2>
	<ul>
	<%
		List<Utilisateur> utilisateurs = (List<Utilisateur>) request.getAttribute("utilisateurs");
		for (Utilisateur utilisateur : utilisateurs) {
			out.println("<li>");
			out.println(utilisateur.getNom() + " " + utilisateur.getPrenom() + " | " + utilisateur.getEmail());
			out.println("</li>");
		}
	%>
	</ul>
</body>
</html>