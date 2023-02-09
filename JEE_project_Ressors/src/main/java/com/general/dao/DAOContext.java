package com.general.dao;


public class DAOContext {
	
	static String dbURL = "jdbc:mysql://localhost:3306/general_ressort";
	static String dbLogin = "root";
	static String dbPassword = "";
	
	
	public static void init( javax.servlet.ServletContext servletContext ) {
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			dbURL = "jdbc:mysql://localhost:3306/general_ressort";// context.getInitParameter( "JDBC_URL" );
			dbLogin = "root";//context.getInitParameter( "JDBC_LOGIN" );
			dbPassword = "";// context.getInitParameter( "JDBC_PASSWORD" );
		} catch( Exception exception ) {
			exception.printStackTrace();
		}
	}
	
	
	
}