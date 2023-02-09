package com.general.ihm;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.general.dao.*;
import com.general.objet.Achats;
import com.general.objet.ListeArticles;
import com.general.objet.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns="/login", loadOnStartup=1)
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = -4319076288258537575L;


	@Override
	public void init() throws ServletException {
		DAOContext.init( this.getServletContext() );
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession( true );
		if ( session.getAttribute( "Utilisateur" ) != null ) {
			response.sendRedirect( "touslesarticles" );
			return;
		}
		request.setAttribute( "login", "" );
		request.setAttribute( "password", "" );
		request.setAttribute( "prenom", "" );
		request.setAttribute( "nom", "" );
		request.setAttribute( "message", "" );
		request.getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter( "txtLogin" );
		String password = request.getParameter( "txtPassword" );
		
		request.setAttribute( "login", login );
		request.setAttribute( "password", password );
		
		User Utilisateur = UserDAO.isLoginValid( login, hashPassword(password) );
		if ( Utilisateur == null ) {
			request.setAttribute( "message", "Mauvais mail ou mot de passe" );			
			request.getRequestDispatcher( "WEB-INF/login.jsp" ).forward( request, response );
			return;
		}
		HttpSession session = request.getSession( true );
		session.setAttribute( "Utilisateur", Utilisateur );
		session.setAttribute( "ListeArticles", new ListeArticles());
		session.setAttribute( "achats", new Achats(Utilisateur) );
		request.setAttribute( "listArticle", ArticleDAO.getallArticle() );
		response.sendRedirect( "touslesarticles" );
		return;
		
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

