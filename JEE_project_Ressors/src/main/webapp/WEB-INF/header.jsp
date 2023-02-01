<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">GRessors</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <c:if test="${ Utilisateur.role eq 1}" var="variable">
        <li class="nav-item">
          <a class="nav-link" href="admin">Admin</a>
        </li>
      </c:if>
      <li class="nav-item">
        <a class="nav-link" href="touslesarticles">Voir les articles</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="touslesachats">Afficher les achats</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="caddie">Voir le caddie</a>
      </li>
    </ul>
  </div>
  <form action="touslesarticles" method="post">
    <input name="btnDisconect" class="btn btn-primary" type="submit" value="Se déconnecter" />
  </form>
</nav>
<br><br>