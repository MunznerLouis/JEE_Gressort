package com.general.objet;




//@Entity @Table( name="Article" )
public class Article {

	//@Id @GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
	private String type;
	private String nom;
	private double prix;
	private String description;
	private String reference;
	private String link;
	private int stock;

	
	
	public Article() {
		this( 0, "", "", 0 , "" , "" , "" , 0);
	}
	
	
	public Article( int id, String type, String nom, double prix, String description, String reference, String link, int stock) {
		this.setId( id );
	    this.setType( type );	
	    this.setNom( nom );
	    this.setPrix( prix );
		this.setDescription( description );
		this.setReference( reference );
		this.setLink( link );
		this.setStock( stock );
	}



	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}

	
	
}
