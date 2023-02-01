package com.general.objet;

public class Charriot {

		private Article article;
		private int quantity = 0;
		private int stock;
		
		public Charriot( Article article, int quantity ) {
			setArticle( article );
			setQuantity( quantity );
		}
		
		
		public Article getArticle() {
			return article;
		}
		
		public void setArticle(Article article) {
			if ( article == null ) throw new NullPointerException();
			this.article = article;
		}
		
		public int getQuantity() {
			return quantity;
		}
		
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		
		public void increaseQuantity() {
			this.quantity++;
		}
		
		public void decreaseQuantity() {
			this.quantity--;
		}


		public int getStock() {
			return stock;
		}


		public void setStock(int stock) {
			this.stock = stock;
		}


		
		
		
		
		
	
}
