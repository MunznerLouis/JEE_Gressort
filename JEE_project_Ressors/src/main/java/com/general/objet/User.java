package com.general.objet;


public class User {

	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String pass;
	private int role;

	public User( int id, String nom, String prenom, String mail, String pass, int role ) {
		this.setId( id );
		this.setNom( nom );
		this.setPrenom( prenom );
		this.setMail(mail);
		this.setPass(pass);
		this.setRole(role);
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	
	
	
	



	
}
