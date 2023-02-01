package com.general.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




import com.general.objet.Article;

@SuppressWarnings("unused")
public class ArticleDAO extends DAOContext {

	public static int getArticleCount() {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			String strSql = "SELECT count(id) FROM article";
			try ( Statement statement  = connection.createStatement() ) {
				try ( ResultSet resultSet = statement.executeQuery( strSql ) ) {
					resultSet.next();
					return resultSet.getInt( 1 );
				}
			}
			
		} catch ( Exception exception ) {
			
			throw new RuntimeException( exception );
			
		}
	}
	
	public static Article getArticleById( int idArticle ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			String strSql = "SELECT * FROM article WHERE id=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, idArticle );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					resultSet.next();
					return new Article(
							resultSet.getInt( "id" ),
							resultSet.getString( "type" ),
							resultSet.getString( "nom" ),
							resultSet.getDouble( "prix" ),
							resultSet.getString( "description" ),
							resultSet.getString( "reference" ),
							resultSet.getString( "link" ),
							resultSet.getInt( "stock" )
					);
				}
			}
			
		} catch ( Exception exception ) {
			
			throw new RuntimeException( exception );
			
		}
	}
	
	public static List<Article> getallArticle( ) {
		List<Article> listArticle = new ArrayList<Article>();
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			String strSql = "SELECT * FROM article";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				try ( ResultSet resultSet = statement.executeQuery() ) {
					while(resultSet.next()) {
					listArticle.add(new Article(
							resultSet.getInt( "id" ),
							resultSet.getString( "type" ),
							resultSet.getString( "nom" ),
							resultSet.getDouble( "prix" ),
							resultSet.getString( "description" ),
							resultSet.getString( "reference" ),
							resultSet.getString( "link" ),
							resultSet.getInt( "stock" )
					));
					
					}
					return(listArticle);
				}
			}
			
		} catch ( Exception exception ) {
			
			throw new RuntimeException( exception );
			
		}
	}

	public static boolean hasEnought(String id, String qts) {
		// TODO Auto-generated method stub
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			String strSql = "SELECT * FROM article WHERE id=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, id );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					if (resultSet.next()) {
							return(resultSet.getInt( "stock" ) >= Integer.parseInt(qts));}					
					}
				}
			
		} catch ( Exception exception ) {
			
			throw new RuntimeException( exception );
			
		}
		return false;
	}
	
	 public static void updateStock(String id, String newqts) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			
			String strSql = "SELECT * FROM article WHERE id=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, id );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					if (resultSet.next()) {
							int stork = resultSet.getInt( "stock" );
							strSql = "UPDATE `Article` SET `stock`=? WHERE id=?";
							try ( PreparedStatement statement2  = connection.prepareStatement( strSql ) ) {
								statement2.setInt( 1, stork-Integer.parseInt(newqts) );
								statement2.setString( 2, id );
								statement2.executeUpdate();	
							}					
					}
				}	
			}
		} catch ( Exception exception ) 
			{
			throw new RuntimeException( exception );
			}
		
	}
	
	 /*public static void updateStock(String id, String newqts) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("general_ressort");
			entityManager = entityManagerFactory.createEntityManager();
			
			Article article = entityManager.find(Article.class, id);
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin();
			
			article.setStock(article.getStock()-Integer.parseInt(newqts));
			entityManager.persist(article);
			
			trans.commit();
		} finally {
			if (entityManager != null) entityManager.close();
			if (entityManagerFactory != null ) entityManagerFactory.close();
			}
			
			
		}*/
	
}
	
	
	
	
	
	

	

