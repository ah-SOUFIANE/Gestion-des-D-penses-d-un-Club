<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entities.Utilisateur" %>
<%
    Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
    if (u == null) {
        response.sendRedirect("login.jsp?msg=Veuillez vous connecter");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Tableau de bord - Utilisateur</title>
    </head>
    <body>
        <h2>Bienvenue <%= u.getPrenom() %> <%= u.getNom() %> !</h2>
        <p>Vous êtes connecté en tant qu'utilisateur.</p>
<a href="MesDepenses" class="btn btn-primary">Voir mes dépenses</a>
        <a href="deconnexion.jsp">Se déconnecter</a>
    </body>
</html>
