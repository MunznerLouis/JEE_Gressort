<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
    <%@ include file="header.jsp" %>
    <head>
        <meta charset="UTF-8">
        <title>ADMIN</title>
    </head >
    <body class="bg-dark">
        <div class="container col-md-11 col-md-offset-3">
            <h1 class="text-white text-center">Bienvenue sur la page Admin ${Utilisateur.prenom}</h1>
            <br/>
            <h4 class="text-white">Liste des utilisateurs :</h4>
            <table class="table table-dark table-striped table-bordered " style="width: 60%; margin: auto;"> 
                <thead>
                    <tr>
                        <th class="text-white">id</th>
                        <th class="text-white">nom</th>
                        <th class="text-white">prenom</th>
                        <th class="text-white">mail</th>
                        <th class="text-white">role</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${ Utilisateur.role eq 1}" var="variable">
                    <c:forEach items="#{listUser}" var="user">
                        <tr>
                            <td class="text-white">${user.id}</td>
                            <td class="text-white">${user.nom}</td>
                            <td class="text-white">${user.prenom}</td>
                            <td class="text-white">${user.mail}</td>
                            <td class="text-white">${user.role}</td>
                        </tr>
                    </c:forEach>
                    </c:if>
                </tbody>
            </table>        
            <br/><br/>
            <h4 class="text-white">Pour changer le role d'un Utilisateur/Admin:</h4>
            <div class="container col-md-8 col-md-offset-3" style="overflow: auto">
                <form method="post" action="admin">
                    <div class="form-group row text-white">
                        <label class="col-sm col-form-label">id de l'utilisateur :</label>
                        <div class="col-sm-10">
	                <input name="id" class="form-control" value="" autofocus />
	            </div>
	        
	            <label class="col-sm col-form-label">Nouveau role :</label>
	        <div class="col-sm-10">
                <input name="newRole" class="form-control" value="" autofocus />
                <div class="errorMessage" style="color: red;font-size: 12px;margin-top: 5px;">${errorMessage}</div>
            </div>
        
            <br/><br/><br/>
        
            <input type="submit" class="btn btn-primary" value="Changer le role" />
            
	    </div>
	</form>
    <ul class="list-group mx-auto " style="width: 65%;">
        <li class="list-group-item list-group-item-secondary py-2">Role 1 : Admin (réduction de 50%)</li>
        <li class="list-group-item list-group-item-secondary py-2">Role 2 : Super Utilisateur (réduction de 25%)</li>
        <li class="list-group-item list-group-item-secondary py-2">Role 3 : Utilisateur (pas de réduction)</li>
    </ul>
 </div></div>  
</body>

<%@ include file="footer.jsp" %>
</html>