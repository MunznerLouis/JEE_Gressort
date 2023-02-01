package com.general.objet;

import java.util.ArrayList;
import java.util.List;

import com.general.dao.ArticleDAO;
import com.general.dao.UserDAO;

public class ListeArticles {


	private double fullPrice = 0;
	
	private List<Charriot> charriot = new ArrayList<>();
	
	
	public void resetcharriot() {
		this.charriot = new ArrayList<> ();
	}
	
	public ListeArticles() {
	}
	

	public List<Charriot> getCharriot() {
		return charriot;
	}
	
	public int getCharriotSize() {
		int fullQuantity = 0;
		for (Charriot Charriot : charriot) {
			fullQuantity += Charriot.getQuantity();
		}
		return fullQuantity;
	}
	
	public int getCharriotlength() {
		int fullQuantity = 0;
		for (Charriot Charriot : charriot) {
			fullQuantity += 1;
		}
		return fullQuantity;
	}
	
	public void setFullPrice() {
			this.fullPrice = 0;
			for (Charriot s : charriot) {
				this.fullPrice += s.getQuantity() * s.getArticle().getPrix();
			}
			
		}

	public void setFullPrice(String Userid) {
		this.fullPrice = 0;
		for (Charriot s : charriot) {
			this.fullPrice += s.getQuantity() * s.getArticle().getPrix();
		}
		
		this.fullPrice = this.fullPrice * UserDAO.getReduction(Userid);
		
	}
	
	public double getFullPrice() {
		return this.fullPrice;
	}
	
	
	public void addCurrentArticle(String id) {
		for (Charriot Charriot : charriot) {
			if ( id.equals("" + Charriot.getArticle().getId()) ) {
				Charriot.increaseQuantity();
				return;
			}
		}
		charriot.add( new Charriot( ArticleDAO.getArticleById(Integer.parseInt(id)), 1 ) );
	}
	
	public void subCurrentArticle(String id) {
		System.out.println("i am here");
		boolean bool = false;
		Charriot temp = null;
		for (Charriot Charriot : charriot) {
			if ( id.equals("" + Charriot.getArticle().getId()) ) {
				if (Charriot.getQuantity()>1) {
					Charriot.decreaseQuantity();
					System.out.println("ici2");
					return;
				} else {
					bool = true;
					temp = Charriot;
					System.out.println("ici1");
				}
			}
		}
		if (bool) {
			charriot.remove(temp);
		}
	}
	
}
