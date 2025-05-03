<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une dépense</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center mb-4 text-primary">Ajouter une dépense</h2>

    <form action="ajouterDepense" method="post" class="card p-4 shadow-sm">

        <div class="mb-3">
            <label class="form-label">Libellé</label>
            <input type="text" class="form-control" name="libelle" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Montant</label>
            <input type="number" step="0.01" class="form-control" name="montant" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Date</label>
            <input type="date" class="form-control" name="date" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Catégorie</label>
            <select name="categorie" class="form-select" required>
                <c:forEach var="cat" items="${categories}">
                    <option value="${cat.id}">${cat.nom}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Club</label>
            <select name="club" class="form-select" required>
                <c:forEach var="club" items="${clubs}">
                    <option value="${club.id}">${club.nom}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Utilisateur</label>
            <select name="utilisateur" class="form-select" required>
                <c:forEach var="u" items="${utilisateurs}">
                    <option value="${u.id}">${u.nom} ${u.prenom}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-success w-100">Ajouter</button>
    </form>
</div>

</body>
</html>
