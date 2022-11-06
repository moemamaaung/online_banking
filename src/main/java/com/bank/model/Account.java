package com.bank.model;

public class Account {
	private int id;
	private String accountno;
	private String name;
	private double amount;
	private String address;
	private String phno;
	
	
	
	
	public Account(int id, String accountno, String name) {
		super();
		this.id = id;
		this.accountno = accountno;
		this.name = name;
	}

	public Account(int id,String accountno, String name, double amount, String address, String phno) {
		super();
		this.id = id;
		this.accountno = accountno;
		this.name = name;
		this.amount = amount;
		this.address = address;
		this.phno = phno;
	}
	
	public Account(String accountno,String name, double amount, String address, String phno) {
		super();
		this.accountno = accountno;
		this.name = name;
		this.amount = amount;
		this.address = address;
		this.phno = phno;
	}

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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ",accountno=" + accountno + ", name=" + name + ", amount=" + amount + ", address=" + address
				+ ", phno=" + phno + "]";
	}
	
	
}
