<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Recherche de Restaurants</title>
</head>
<body>
    <form action="controleur" method="post">
        <label for="motCle">Mot Clé:</label>
        <input type="text" name="motCle" value="${modele.motCle != null ? modele.motCle : ''}">
        <input type="submit" value="OK">
    </form>

    <table border="1" width="80%">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom du Restaurant</th>
                <th>Type de Cuisine</th>
                <th>Adresse</th>
                <th>Note</th> <!-- Nouvelle colonne pour la note -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${modele.restaurants}" var="r">
                <tr>
                    <td>${r.idRestaurant}</td>
                    <td>${r.nomRestaurant}</td>
                    <td>${r.typeCuisine}</td>
                    <td>${r.adresse}</td>
                    <td>${r.note != null ? r.note : 'Non attribuée'}</td> <!-- Affichage de la note -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
