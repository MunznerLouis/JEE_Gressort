package com.general.objet;

import java.sql.Array;
import java.util.List;

import com.general.dao.AchatDAO;

public class Achats {

		
		private Array commande;
		private List<String> nomArticles;
		private List<String> qtsArticles;
		private List<String> commandeArticles;
		private int len;
		private Array qts;
		
		
		
		public Achats(User connectedUser) {
			
			this.setCommandeArticles(AchatDAO.getCommandeByMail(connectedUser.getMail()));
			this.nomArticles = AchatDAO.getNomArticleByMail(connectedUser.getMail());
			this.setQtsArticles(AchatDAO.getQtsByMail(connectedUser.getMail()));
			this.setLen(this.nomArticles.size());
			//this.qts = AchatDAO.getQtsByMail(connectedUser.getMail());
		}

		public List<String> getNomArticles() {
			return nomArticles;
		}

		public void setNomArticles(List<String> nomArticles) {
			this.nomArticles = nomArticles;
		}

		public Array getQts() {
			return qts;
		}

		public void setQts(Array qts) {
			this.qts = qts;
		}

		public Array getCommande() {
			return commande;
		}

		public void setCommande(Array commande) {
			this.commande = commande;
		}

		public int getLen() {
			return len;
		}

		public void setLen(int len) {
			this.len = len;
		}

		public List<String> getCommandeArticles() {
			return commandeArticles;
		}

		public void setCommandeArticles(List<String> commandeArticles) {
			this.commandeArticles = commandeArticles;
		}

		public List<String> getQtsArticles() {
			return qtsArticles;
		}

		public void setQtsArticles(List<String> qtsArticles) {
			this.qtsArticles = qtsArticles;
		}
		
		

		
	
		
	
}
