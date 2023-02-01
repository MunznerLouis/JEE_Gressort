<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<%@ include file="header.jsp" %>

<html>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <head>
        <meta charset="UTF-8">
        <title>Tous mes achats</title>
    </head>
    <body>
        <h1 style="text-align: center;">Tous mes achats - ${Utilisateur.nom}</h1>
        <br />
        <table class="table table-striped" style="width: 60%; margin: auto;">
            <thead>
                <tr>
                    <th>ID commande</th>
                    <th>Nom de l'article</th>
                    <th>Quantité de l'article</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${achats.len ge 1}" var="variable">
                    <c:forEach var="i" begin="0" end="${achats.len-1}" step="1">
                        <tr>
                            <td><c:out value="${achats.commandeArticles[i]}" /> </td>
                            <td><c:out value="${achats.nomArticles[i]}" /> </td>
                            <td><c:out value="${achats.qtsArticles[i]}" /> </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </body>
  <%@ include file="footer.jsp" %> 
</html>