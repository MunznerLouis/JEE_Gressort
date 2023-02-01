<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <%@ include file="header.jsp" %>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <head>
    <meta charset="UTF-8">
    <title>Mon Caddie</title>
    <link rel="stylesheet" type="text/css" href="styles.css" />
  </head>
  <body>
    <div class="text-center mt-4">
      <h1>Mon Caddie: ${Utilisateur.prenom} ${Utilisateur.nom}</h1>
    </div>

    <table class="table mt-4" style="width: 60%; margin: auto;"> 
        <tr>
          <th>Id de l'article</th>
          <th>Nom</th>
          <th>Référence</th>
          <th>Prix</th>
          <th>Quantité</th>
        </tr>
        <c:forEach items="#{ListeArticles.charriot}" var="row">
          <tr>
            <td>${row.article.id}</td>
            <td>${row.article.nom}</td>
            <td>${row.article.reference}</td>
            <td>${row.article.prix}</td>
            <td>${row.quantity}</td>
          </tr>
        </c:forEach>
    </table>    

    <div class="text-center mt-4">
      <p class="mb-0">Prix total (réduction comprise) : ${ListeArticles.fullPrice }</p>
      <br><br>

      <form method="post" action="caddie">
        <input type="submit" class="btn btn-primary" value="Valider achat" />
        <div class="message">${message}</div>
      </form>
    </div>
  </body>
  <br><br><br><br>
  <%@ include file="footer.jsp" %>
</html>
