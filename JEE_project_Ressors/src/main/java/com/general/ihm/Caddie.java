package com.general.ihm;

import java.io.IOException;
import com.general.dao.AchatDAO;
import com.general.dao.ArticleDAO;
import com.general.objet.ListeArticles;
import com.general.objet.Mail;
import com.general.objet.Charriot;
import com.general.objet.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( urlPatterns="/caddie") 
public class Caddie extends HttpServlet {

	private static final long serialVersionUID = -1204635336479052777L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession( true );
		
		if ( session.getAttribute( "Utilisateur" ) == null ) {
			response.sendRedirect( "login" );
			return;
		}
		User Utilisateur = (User) session.getAttribute("Utilisateur");
		
		ListeArticles ListeArticles = (ListeArticles) session.getAttribute( "ListeArticles" );
		ListeArticles.setFullPrice(""+Utilisateur.getId());
		session.setAttribute("ListeArticles", ListeArticles);
		session.setAttribute("message", "");
		
		System.out.println("dnas le caddie");
		
		request.getRequestDispatcher( "WEB-INF/caddie.jsp" ).forward( request, response );
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession( true );
		User Utilisateur = (User) session.getAttribute("Utilisateur");
		
		 session.setAttribute("message", "");
		
		ListeArticles ListeArticles = (ListeArticles) session.getAttribute( "ListeArticles" );
		ListeArticles.setFullPrice(""+Utilisateur.getId());
		session.setAttribute("ListeArticles", ListeArticles);
		
		
		if ( request.getParameter( "btnDisconect") != null ){
			session.invalidate();
			request.getRequestDispatcher( "WEB-INF/login.jsp" ).forward( request, response );
		}
		
		
		boolean bool = true;
		for (Charriot s : ListeArticles.getCharriot()) {
			if (!ArticleDAO.hasEnought(""+s.getArticle().getId(),""+s.getQuantity())) {
				session.setAttribute("message", "Nous sommes d�sol� l'article "+s.getArticle().getNom()+" n'est plus disponible dans les quantit�s souhait�s.");
				bool = false;
				request.getRequestDispatcher( "WEB-INF/caddie.jsp" ).forward( request, response );
			}
			
		}	
		
		if (bool) {

			int maxid = AchatDAO.getMaxid() +1 ;
			
			for (Charriot s : ListeArticles.getCharriot()) {
				ArticleDAO.updateStock(""+s.getArticle().getId(),""+s.getQuantity());
				AchatDAO.addCommande(""+maxid,""+Utilisateur.getMail(),""+s.getArticle().getNom(),""+s.getQuantity());
			}
			
			//envoyer un mail
			Mail mail = new Mail();
			mail.sendMail(Utilisateur, ListeArticles);
			
			
			//avant de reset 
			ListeArticles.resetcharriot();
			session.setAttribute("ListeArticles", ListeArticles);
			session.setAttribute("message", "Achat bien enregistre");
			request.getRequestDispatcher( "WEB-INF/caddie.jsp" ).forward( request, response );
		}


		request.getRequestDispatcher( "WEB-INF/caddie.jsp" ).forward( request, response );
		
	}
}
