<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
  <head>
  <%@ include file="header.jsp" %>
    <meta charset="UTF-8">
    <title>Catalogue</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
  </head>
  <body>
    <div class="container mt-5" style="max-width: 90%">
      <h1>Catalogue d'articles - ${Utilisateur.prenom} ${Utilisateur.nom}</h1>
      <c:forEach items="#{listArticle}" var="article" varStatus="status">
        <c:if test="${status.index % 2 == 0}">
          <div class="row">
        </c:if>
          <div class="col-6">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>ID Commande</th>
                  <th>Nom de l'article</th>
                  <th>Reference</th>
                  <th>Image</th>
                  <th>En Stock</th>
                  <th>Prix</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>${article.id}</td>
                  <td>${article.nom}</td>
                  <td>${article.reference}</td>
                  <td><img src="${article.link}" style="width:200px;height:150px;"></td>
                  <td>${article.stock}</td>
                  <td>${article.prix}</td>
                  <td>
                    <form action="touslesarticles" method="post">
                      <div class="btn-group" role="group" aria-label="Basic example">
                      <button type="submit" name="btnSub" class="btn btn-outline-secondary btn-sm" value="${article.id}">- </button>
                      <button type="submit" name="btnAdd" class="btn btn-outline-secondary btn-sm" value="${article.id}">+</button>
                      </div>
                    </form>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        <c:if test="${status.index % 2 == 1 || status.last}">
          </div>
        </c:if>
      </c:forEach>
    </div>
  </body>
  <%@ include file="footer.jsp" %>
</html>
