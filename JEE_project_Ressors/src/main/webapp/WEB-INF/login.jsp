<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gressort | Login</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
		<style>
			body {
				background-color: #f2f2f2;
			}

			.container {
				background-color: #ffffff;
				
				border-radius: 10px;
				box-shadow: 0px 0px 10px 0px #bbbbbb;
				margin-top: 50px;
				
				overflow: auto;
			}

			.form-group label {
				font-weight: bold;
				margin-top: 20px;
			}

			.message,.message2 {
  				color: red;
  				font-size: 12px;
  				margin-top: 5px;
			}

			.logo {
				text-align: center;
				margin-bottom: 50px;
			}

			.logo h2 {
				font-weight: bold;
				color: #444444;
			}
		</style>
	</head>
	<body>
		<div class="logo">
			<h2>Gressort</h2>
		</div>
		<div class="container col-md-8 col-md-offset-3">
			<h1 class="text-center">Se connecter</h1>
			<br>
			<form method="post" action="login">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Mail :</label>
					<div class="col-sm-10">
						<input name="txtLogin" class="form-control" value="${login}" autofocus />
					</div>
					<br><br><br>

					<label class="col-sm-2 col-form-label">Mot de passe :</label>
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
	    
	    <h1 class="text-center">Creer un compte</h1>
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
	        
            <div class="message2">${message2}</div>
            </div>
	    </form>
	    	
	    	</div>
	</body>
</html>