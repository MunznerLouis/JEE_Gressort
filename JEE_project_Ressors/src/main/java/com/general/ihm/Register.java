package com.general.ihm;


import java.io.IOException;





import com.general.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Login
 */
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
		request.setAttribute( "message", "" );
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
		
		
		
		if (UserDAO.isMailNotUsed(login)) {
			if (password.equals(rePassword)) {
				UserDAO.createAccount(login, password, nom, prenom);
			} else {
				request.setAttribute( "message", "Mauvais mot de passe" );			
				request.getRequestDispatcher( "WEB-INF/login.jsp" ).forward( request, response );
			}
			
			request.setAttribute( "message", "Compte cree avec succes" );			
			request.getRequestDispatcher( "WEB-INF/login.jsp" ).forward( request, response );
		
		} else {
		
			request.setAttribute( "message", "Mail deja utilise" );			
			request.getRequestDispatcher( "WEB-INF/login.jsp" ).forward( request, response );
			
		}
		
	}

}