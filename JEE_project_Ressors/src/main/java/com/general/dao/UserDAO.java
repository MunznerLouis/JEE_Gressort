package com.general.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.general.objet.User;

public class UserDAO extends DAOContext {

	public static User isLoginValid( String mail, String pass ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
			String strSql = "SELECT * FROM user WHERE mail=? AND pass=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, mail );
				statement.setString( 2, pass );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					if ( resultSet.next() ) {
						return new User(
								resultSet.getInt( "id" ),
								resultSet.getString( "nom" ),
								resultSet.getString( "prenom" ),
								resultSet.getString("mail"),
								resultSet.getString( "pass" ),
								resultSet.getInt( "role" )
						);
					} else {
						return null;
					}
				}
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}
	
	public static User createUser( String id ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
			String strSql = "SELECT * FROM user WHERE id=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, id );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					if ( resultSet.next() ) {
						return new User(
								resultSet.getInt( "id" ),
								resultSet.getString( "nom" ),
								resultSet.getString( "prenom" ),
								resultSet.getString("mail"),
								resultSet.getString( "pass" ),
								resultSet.getInt( "role" )
						);
					} else {
						return null;
					}
				}
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}
	
	public static boolean isMailNotUsed( String mail ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
			String strSql = "SELECT * FROM user WHERE mail=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, mail );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					if ( resultSet.next() ) {
						return (false);
					} else {
						return (true);
					}
				}
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}
	
	public static void createAccount( String mail, String password, String nom, String prenom) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
			String strSql = "INSERT INTO user ( nom, prenom, mail, pass, role) VALUES (  ?, ?, ?, ?, 3)";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, nom );
				statement.setString( 2, prenom);
				statement.setString( 3, mail);
				statement.setString( 4, password);

				statement.executeUpdate();
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}
	
	public static boolean isAdmin( String mail) 
	{
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) 
		{
			String strSql = "SELECT * FROM user WHERE mail=? AND role=1";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, mail );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					if ( resultSet.next() ) {
						return (true);
					} else {
						return (false);
					}
				}
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}
	
	public static List<User> getAllUser() 
	{
		List<User> listUser = new ArrayList<User>();
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) 
		{
			String strSql = "SELECT * FROM user";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				try ( ResultSet resultSet = statement.executeQuery() ) {
					while ( resultSet.next() ) {
						listUser.add(new User(
								resultSet.getInt( "id" ),
								resultSet.getString( "nom" ),
								resultSet.getString( "prenom" ),
								resultSet.getString("mail"),
								resultSet.getString( "pass" ),
								resultSet.getInt( "role" )
						));
						
					} 
					return listUser;
				}
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}

	public static void changeRole(String id, String newRole) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){

			String strSql = "UPDATE user SET role=? WHERE id=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, newRole );
				statement.setString( 2, id);
				statement.executeUpdate();
			}
			
		} catch ( Exception exception ) {
			
			throw new RuntimeException( exception );
			
		}
		
	}
	
	public static double getReduction(String id) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){

			String strSql = "SELECT * from user  WHERE id=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, id );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					if (resultSet.next()) {
						int val = resultSet.getInt( "role" );
						if (val == 1){
							return(0.5);
						} else if ( val == 3) {
							return(1);
						} else {
							return(0.75);
						}
					}
					} 
				
				
			}
			
		} catch ( Exception exception ) {
			
			throw new RuntimeException( exception );
			
		}
		return 0;
		
	}
	
	
}