package com.general.ihm;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.general.dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/register", loadOnStartup=1)
public class Register extends HttpServlet {
	
	private static final long serialVersionUID = -4319076288258537575L;


	@Override
	public void init() throws ServletException {
		DAOContext.init( this.getServletContext() );
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession( true );
		if ( session.getAttribute( "Utilisateur" ) != null ) {
			response.sendRedirect( "Touslesarticles" );
			return;
		}
		request.setAttribute( "login", "" );
		request.setAttribute( "password", "" );
		request.setAttribute( "prenom", "" );
		request.setAttribute( "nom", "" );
		request.setAttribute( "message2", "" );
		request.getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
		//request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter( "txtLogin" );
		String password = request.getParameter( "txtPassword" );
		String rePassword = request.getParameter( "txtRePassword" );
		String nom = request.getParameter( "txtNom");
		String prenom = request.getParameter( "txtPrenom");

		request.setAttribute( "login", login );
		request.setAttribute( "nom", nom);
		request.setAttribute( "prenom", prenom);
		
		
		//Mail valid check
	    if (!login.contains("@") || !login.contains(".") || login.indexOf("@") >= login.lastIndexOf(".") || login.lastIndexOf(".")==login.length()-1) {
	        request.setAttribute("message2", "Email non valide");
	        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	        return;
	    }
	    
	    //empty fields
	    if (login == null || login.isEmpty() || 
	    	password == null || password.isEmpty() || 
	    	rePassword == null || rePassword.isEmpty() ||
			nom == null || nom.isEmpty() || 
			prenom == null || prenom.isEmpty()) {
				request.setAttribute("message2", "Tous les champs sont requis");
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
				return;
	    }
	    
	    //mail already used
		if (!UserDAO.isMailNotUsed(login)) {
			request.setAttribute( "message2", "Mail deja utilise" );			
			request.getRequestDispatcher( "WEB-INF/login.jsp" ).forward( request, response );
			return;
		}
		
		//password twice check
		if (!password.equals(rePassword)) {
			request.setAttribute( "message2", "Mauvais mot de passe" );			
			request.getRequestDispatcher( "WEB-INF/login.jsp" ).forward( request, response );
		}
		
			UserDAO.createAccount(login, hashPassword(password), nom, prenom);
			request.setAttribute( "message2", "Compte cree avec succes" );			
			request.getRequestDispatcher( "WEB-INF/login.jsp" ).forward( request, response );
		}

	
	
	
	private static String hashPassword(String password) {
	    String hashedPassword = null;
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashInBytes) {
	            sb.append(String.format("%02x", b));
	        }
	        hashedPassword = sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	        System.err.println("Error while hashing the password: " + e.getMessage());
	    }
	    return hashedPassword;
	}

}

