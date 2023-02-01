<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	    
        <div class="container col-md-8 col-md-offset-3" style="overflow: auto">

        <h1>Se connecter</h1>
        <br/>
	    <form method="post" action="login" >
              <div class="form-group row">
            
	        <label class="col-sm-2 col-form-label">Mail :</label>
            <div class="col-sm-10">
	        <input name="txtLogin" class="form-control" value="${login}" autofocus />
            </div>
            <br/><br/><br/>
            
            <label class="col-sm-2 col-form-label">mot de passe:</label>
            <div class="col-sm-10">
            <input name="txtPassword" class="form-control" type="password" value="${password}" />
            </div>
            
            <br/><br/><br/>

	        <div class="col-sm-10">
	        <input type="submit" class="btn btn-primary" value="Connect" />
	        </div>
	        <br/>
	        
            <div class="message">${message}</div>
            </div>
	    </form>
	    
	    <h1>Creer un compte</h1>
	    <br/>
	    <form method="post" action="register">
	        <div class="form-group row">
	       
	        
	        <label class="col-sm-2 col-form-label">Mail :</label> 
	        <div class="col-sm-10">
	        <input name="txtLogin" class="form-control" value="" autofocus />
	        </div>
	        <br/><br/><br/>
	        
	        <label class="col-sm-2 col-form-label">nom :</label>
	        <div class="col-sm-10">
	        <input name="txtNom" class="form-control" value="${nom}" autofocus />
	        </div>
	        <br/><br/><br/>
	        
	        <label class="col-sm-2 col-form-label">prenom :</label>
	        <div class="col-sm-10">
	        <input name="txtPrenom" class="form-control" value="${prenom}" autofocus />
	        </div>
	        <br/><br/><br/>
	        
            <label class="col-sm-2 col-form-label">mot de passe:</label> 
            <div class="col-sm-10">
            <input name="txtPassword" class="form-control" type="password" value="" />
            </div>
            <br/> 
            <br/><br/>
	        
	        <label class="col-sm col-form-label">retaper le mot de passe </label> 
	        <div class="col-sm-10">
            <input name="txtRePassword" class="form-control" type="password" value="" />
            </div>
            <br/><br/><br/>
	        
	        <div class="col-sm-10">
	        <input type="submit" class="btn btn-primary" value="create account" />
	        </div>
	        <br/><br/>
	        
            <div class="message">${message}</div>
            </div>
	    </form>
	    	
	    	
	</body>
	<%@ include file="footer.jsp" %>
</html>