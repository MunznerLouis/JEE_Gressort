package com.general.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AchatDAO extends DAOContext {
	
	public static List<String> getCommandeByMail( String mail ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			String strSql = "SELECT * FROM achat where mail=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, mail);
				try ( ResultSet resultSet = statement.executeQuery() ) {
					List<String> liststring = new ArrayList<String>();
					while (resultSet.next())
					{
						liststring.add(resultSet.getString(1));
					}
					return (liststring);
				}
			}
			
		} catch ( Exception exception ) 
			{
			throw new RuntimeException( exception );
			}
		}
	
	public static List<String> getNomArticleByMail( String mail ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			String strSql = "SELECT * FROM achat where mail=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, mail);
				try ( ResultSet resultSet = statement.executeQuery() ) {
					List<String> liststring = new ArrayList<String>();
					while (resultSet.next())
					{
						liststring.add(resultSet.getString("NomArticle"));
					}
					return (liststring);
				}
			}
			
		} catch ( Exception exception ) 
			{
			throw new RuntimeException( exception );
			}
		}
	
	public static List<String> getQtsByMail( String mail ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			String strSql = "SELECT * FROM achat where mail=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, mail);
				try ( ResultSet resultSet = statement.executeQuery() ) {
					List<String> liststring = new ArrayList<String>();
					while (resultSet.next())
					{
						liststring.add(resultSet.getString(4));
					}
					return (liststring);
				}
			}
			
		} catch ( Exception exception ) 
			{
			throw new RuntimeException( exception );
			}
		}

	public static int getMaxid() {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			String strSql = "SELECT MAX(commande) FROM achat";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				try ( ResultSet resultSet = statement.executeQuery() ) {
					if (resultSet.next()) {
						return (resultSet.getInt("Max(commande)"));
					}
					
				}
			}
			
		} catch ( Exception exception ) 
			{
			throw new RuntimeException( exception );
			}
		return 0;
		
	}
	
	public static void addCommande(String id, String mail, String nomArticle, String qts) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){

			String strSql = "INSERT INTO `achat`(`commande`, `mail`, `nomArticle`, `qts`) VALUES (?,?,?,?)";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, id );
				statement.setString( 2, mail );
				statement.setString( 3, nomArticle );
				statement.setString( 4, qts );
				statement.executeUpdate();		
			}
		} catch ( Exception exception ) 
			{
			throw new RuntimeException( exception );
			}
		
	}

	
	
}