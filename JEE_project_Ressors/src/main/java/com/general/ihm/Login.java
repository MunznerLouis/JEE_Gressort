package com.general.ihm;

import java.io.IOException;





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
		System.out.println("salut");
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
		
		User Utilisateur = UserDAO.isLoginValid( login, password );
		if ( Utilisateur != null ) {
			HttpSession session = request.getSession( true );
			session.setAttribute( "Utilisateur", Utilisateur );
			session.setAttribute( "ListeArticles", new ListeArticles() );
			session.setAttribute( "achats", new Achats(Utilisateur) );
			request.setAttribute( "listArticle", ArticleDAO.getallArticle() );
			response.sendRedirect( "touslesarticles" );
			return;
		} else {
			request.setAttribute( "message", "Mauvais mail ou mot de passe" );			
			request.getRequestDispatcher( "WEB-INF/login.jsp" ).forward( request, response );
			return;
			
		}
		
	}

}