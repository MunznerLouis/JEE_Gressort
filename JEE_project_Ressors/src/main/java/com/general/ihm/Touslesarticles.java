package com.general.ihm;

import java.io.IOException;


import com.general.dao.ArticleDAO;
import com.general.dao.UserDAO;
import com.general.objet.ListeArticles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/touslesarticles" )
public class Touslesarticles extends HttpServlet {

	private static final long serialVersionUID = 550038282401302959L;


	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		System.out.println("doget");
		HttpSession session = request.getSession( true );
		if ( session.getAttribute( "Utilisateur" ) == null ) {
			response.sendRedirect( "login" );
			return;
		}	
		request.setAttribute( "listArticle", ArticleDAO.getallArticle() );
		request.getRequestDispatcher( "WEB-INF/touslesarticles.jsp" ).forward( request, response );
	}
	
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		System.out.println("dopost");
		HttpSession session = request.getSession( true );
		if ( session.getAttribute( "Utilisateur" ) == null ) {
			response.sendRedirect( "login" );
			return;
		}
		ListeArticles ListeArticles = (ListeArticles) session.getAttribute( "ListeArticles" );
		request.setAttribute( "listArticle", ArticleDAO.getallArticle() );
		System.out.println("ver1");
		if ( request.getParameter( "btnDisconect") != null ){
			session.invalidate();
			request.getRequestDispatcher( "WEB-INF/login.jsp" ).forward( request, response );
			return;
		} 
		if ( request.getParameter( "btnAdd" ) != null ) {
			System.out.println("ver2");
			String valueIdArticle = request.getParameter("btnAdd"); //
			System.out.println(valueIdArticle);
			ListeArticles.addCurrentArticle(valueIdArticle);
			request.getRequestDispatcher( "WEB-INF/touslesarticles.jsp" ).forward( request, response );
			return;
		}
		if ( request.getParameter( "btnSub" ) != null ) {
			System.out.println("ver3");
			String valueIdArticle = request.getParameter("btnSub"); //
			System.out.println(valueIdArticle);
			ListeArticles.subCurrentArticle(valueIdArticle);
			request.getRequestDispatcher( "WEB-INF/touslesarticles.jsp" ).forward( request, response );
			return;
		}
		 
		request.getRequestDispatcher( "WEB-INF/touslesarticles.jsp" ).forward( request, response );
	}
	
}
