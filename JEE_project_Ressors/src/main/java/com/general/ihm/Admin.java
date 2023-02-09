package com.general.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.general.dao.ArticleDAO;
import com.general.dao.UserDAO;
import com.general.objet.Achats;
import com.general.objet.User;



@WebServlet( "/admin" )
public class Admin extends HttpServlet {

	private static final long serialVersionUID = 550038282401302959L;


	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		HttpSession session = request.getSession( true );
		if ( session.getAttribute( "Utilisateur" ) == null ) {
			response.sendRedirect( "login" );
			return;
		}
		request.setAttribute( "listArticle", ArticleDAO.getallArticle() );
		
		
		User utilisateur = (User) session.getAttribute("Utilisateur");
		
		if ( !UserDAO.isAdmin( utilisateur.getMail() )) {
			System.out.println("nous sommes ici");
			
			request.getRequestDispatcher( "WEB-INF/touslesarticles.jsp" ).forward( request, response );
			
		} else {
			request.setAttribute( "errorMessage", "" );
			request.setAttribute( "listUser", UserDAO.getAllUser() );
			//request.setAttribute( "idAchats", "Afficher tous les achats de l'utilisateur" );
			request.getRequestDispatcher( "WEB-INF/admin.jsp" ).forward( request, response );
		}

		
	}
	
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		HttpSession session = request.getSession( true );
		if ( session.getAttribute( "Utilisateur" ) == null ) {
			response.sendRedirect( "login" );
			return;
		}
		request.setAttribute( "listArticle", ArticleDAO.getallArticle() );
		
		User utilisateur = (User) session.getAttribute("Utilisateur");
		
		//trying to sneak in through url
	    if ( !UserDAO.isAdmin( utilisateur.getMail() )) {
	    	request.getRequestDispatcher( "WEB-INF/touslesarticles.jsp" ).forward( request, response );
	    	return;
	    }
	   	
        request.setAttribute( "listUser", UserDAO.getAllUser() );
        String id = request.getParameter( "id" );
        String newRole = request.getParameter("newRole");
		
		if (id != null && !id.isEmpty() && newRole != null && !newRole.isEmpty()) {
			UserDAO.changeRole( id, newRole );
		} else {
			request.setAttribute("errorMessage", "Les deux champs sont requis");
			request.getRequestDispatcher( "WEB-INF/admin.jsp" ).forward( request, response );
			return;
		}
		
		if ( request.getParameter( "buttonsbmit" ) != null ) {
            System.out.println(request.getParameter("txt"));
            session.setAttribute( "achatsAdmin", new Achats(UserDAO.createUser(request.getParameter("txt"))) );
            //request.setAttribute( "idAchats", "Afficher tous les achats de l'utilisateur" );
        }
        
        request.getRequestDispatcher( "WEB-INF/admin.jsp" ).forward( request, response );
	}
	
}
