<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.Utilisateur" %>
<%
    Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
    if (u == null || !"admin".equals(u.getRole())) {
        response.sendRedirect("login.jsp?msg=Accès non autorisé");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Tableau de bord - Admin</title>
</head>
<body>
    <h2>Bienvenue Admin <%= u.getNom() %> !</h2>
    <p>Voici votre tableau de bord administratif.</p>
    <a href="deconnexion.jsp">Se déconnecter</a>
    <a href="ajouterDepense.jsp" class="btn btn-primary mt-4">Ajouter une dépense</a>
</body>
</html>
