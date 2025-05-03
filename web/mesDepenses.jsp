<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, entities.Depense" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="entities.Utilisateur" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mes Dépenses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container py-5">
    <div class="text-center mb-4">
        <h2 class="text-primary">Mes Dépenses</h2>
    </div>

    <%
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        List<Depense> depenses = (List<Depense>) request.getAttribute("depenses");
    %>

    <% if (depenses != null && !depenses.isEmpty()) { %>
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>#</th>
                    <th>Libellé</th>
                    <th>Montant</th>
                    <th>Date</th>
                    <th>Catégorie</th>
                    <th>Club</th>
                </tr>
            </thead>
            <tbody>
                <% int i = 1;
                   for (Depense d : depenses) { %>
                    <tr>
                        <td><%= i++ %></td>
                        <td><%= d.getLibelle() %></td>
                        <td><%= d.getMontant() %> DH</td>
                        <td><%= d.getDate() %></td>
                        <td><%= d.getCategorie() != null ? d.getCategorie().getNom() : "N/A" %></td>
                        <td><%= d.getClub() != null ? d.getClub().getNom() : "N/A" %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <div class="alert alert-warning text-center">
            Aucune dépense trouvée pour cet utilisateur.
        </div>
    <% } %>

    <div class="text-center mt-4">
        <a href="userDashboard.jsp" class="btn btn-secondary">Retour au tableau de bord</a>
    </div>
</div>

</body>
</html>
