package com.bank.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.hostmdy.crypto.PasswordEncoder;
import com.hostmdy.crypto.PasswordValidator;


public class UserDAO {
	
	private final DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;

	public UserDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	private void close() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public User getUserByAccountNo(String accountno) {
		User user = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from user where accountno='"+accountno+"';");
			
			while (rs.next()) {
				user = new User(
						rs.getInt("id"),
						rs.getString("accountno"),
						rs.getString("name"),
						rs.getString("password"), 
						rs.getString("role"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return user;
	}
	
	
//	public Account getAccountByAccountNo(String accountno) {
//		Account account = null;
//		try {
//			connection = dataSource.getConnection();
//			stmt = connection.createStatement();
//			rs = stmt.executeQuery("select * from account where accountno='"+accountno+"';");
//			
//			while (rs.next()) {
//				account = new Account(
//						rs.getInt("id"),
//						rs.getString("accountno"),
//						rs.getString("name"),
//						rs.getDouble("amount"),
//						rs.getString("address"),
//						rs.getString("phno"));
//						
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		return account;
//	}
//	
	public boolean isValidUser(String accountno,String originalPassword) {
		User user = getUserByAccountNo(accountno);
		boolean valid = false;
		
		if(user != null) {
			String storedPassword = user.getPassword();
			try {
				valid = PasswordValidator.validatePassword(originalPassword, storedPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return valid;
	}	
	public int createUser(User user) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			
			pStmt = connection.prepareStatement(
					"INSERT INTO `user` "
					+ "(`accountno`, `name`, `password`, `role`) "
					+ "VALUES (?,?,?,?);"
					

					);
			pStmt.setString(1,user.getAccountno());
			pStmt.setString(2, user.getName());
		
			String securedPassword = null;
			try {
				securedPassword = PasswordEncoder.encode(user.getPassword());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pStmt.setString(3,securedPassword);
			pStmt.setString(4,user.getRole());
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowEffected;
	}
	
	
}
