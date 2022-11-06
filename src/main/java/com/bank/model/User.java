package com.bank.model;

public class User {
	
	private int id;
	private String accountno;
	private String name;
	private String password;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(int id, String accountno, String name, String password, String role) {
		super();
		this.id = id;
		this.accountno = accountno;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	public User(String accountno, String name, String password, String role) {
		super();
		this.accountno = accountno;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", accountno=" + accountno + ", name=" + name + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
}
