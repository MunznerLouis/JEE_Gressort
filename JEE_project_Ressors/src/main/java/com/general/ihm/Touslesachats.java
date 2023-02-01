package com.general.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet( urlPatterns="/touslesachats") 
public class Touslesachats extends HttpServlet {

	private static final long serialVersionUID = -1204635336479052777L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession( true );
		if ( session.getAttribute( "Utilisateur" ) == null ) {
			response.sendRedirect( "login" );
			return;
		}
		
		
		request.getRequestDispatcher( "WEB-INF/touslesachats.jsp" ).forward( request, response );
	}
	
}