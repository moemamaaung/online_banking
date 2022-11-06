package com.bank.model;

import java.security.NoSuchAlgorithmException;

import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.crypto.PasswordValidator;



public class AccountDAO {
	
private DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	
	public AccountDAO(DataSource dataSource) {
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
	
	
	public List<Account> getAccountList(){
		List<Account> accountList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from account;");
			
			while (rs.next()) {
				accountList.add(new Account(
						rs.getInt("id"),
						rs.getString("accountno"), 
						rs.getString("name"),  
						rs.getDouble("amount"), 
						rs.getString("address"),
						rs.getString("phno")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return accountList;
	}
	
	public Account getAccount(int id){
		Account account = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from account where id='"+id+"';");
			
			while (rs.next()) {
				account = new Account(
						rs.getInt("id"),
						rs.getString("accountno"), 
						rs.getString("name"),  
						rs.getDouble("amount"), 
						rs.getString("address"),
						rs.getString("phno"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return account;
		
	}
	
	public Account getAccountByAccountNo(String accountno) {
		Account account = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from account where accountno='"+accountno+"';");
			
			while (rs.next()) {
				account = new Account(
						rs.getInt("id"),
						rs.getString("accountno"), 
						rs.getString("name"),  
						rs.getDouble("amount"), 
						rs.getString("address"),
						rs.getString("phno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return account;
	}

	public int createAccount(Account account) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement(
					"INSERT INTO `account` "
					+ "(`accountno`, `name`, `amount`, `address`, `phno`) "
					+ "VALUES (?, ?, ?, ?,?);"
					);
			pStmt.setString(1, account.getAccountno());
			pStmt.setString(2,account.getName());
			pStmt.setDouble(3,account.getAmount());
			pStmt.setString(4,account.getAddress());
			pStmt.setString(5,account.getPhno());
			
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowEffected;
	}
	
	
	public int deposit(Account account) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			
			pStmt = connection.prepareStatement("UPDATE `account` SET "
					+ "`accountno` = '?',"
					+ " `name` = '?',"
					+ " `amount` = amount+?,"
					+ " `address` = '?',"
					+ " `phno` = '?' WHERE (`id` = '?');"
					);
			pStmt.setString(1, account.getAccountno());
			pStmt.setString(2,account.getName());
			pStmt.setDouble(3,account.getAmount());
			pStmt.setString(4,account.getAddress());
			pStmt.setString(5,account.getPhno());
			pStmt.setInt(6, account.getId());
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}

	
	
	public int withdrawn(Account account) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			
			pStmt = connection.prepareStatement("UPDATE `account` SET "
					+ "`accountno` = ?,"
					+ " `name` = ?,"
					+ " `amount` = amount-?,"
					+ " `address` = ?,"
					+ " `phno` = ? WHERE (`id` = ?);"
					);
			pStmt.setString(1, account.getAccountno());
			pStmt.setString(2,account.getName());
			pStmt.setDouble(3,account.getAmount());
			pStmt.setString(4,account.getAddress());
			pStmt.setString(5,account.getPhno());
			pStmt.setInt(6, account.getId());
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
}


