package com.bank.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.bank.model.Account;
import com.bank.model.AccountDAO;
import com.bank.model.User;

/**
 * Servlet implementation class AccountController1
 */
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/onlineBanking")
	private DataSource dataSource;

	private AccountDAO accountDAO;
	
	@Override
	public void init() throws ServletException {
		accountDAO = new AccountDAO(dataSource);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		if (user != null) {
		String mode = request.getParameter("mode");
		if(mode == null) {
			
			if(user.getRole().contains("user")) {
				
				mode="ACC";
				
			}else
			{
				mode = "LIST";
			}
		}
		
		switch (mode) {
		case "LIST":
			showAccountList(request, response);
			break;
		case "CREATE":
			createAccount(request, response);
			break;
		case "ACC":
			showPersonal(request, response);
			break;
		case "LOAD_DEPOSIT":
			loadDeposit(request, response);
			break;
		case "DEPOSIT":
			deposit(request, response);
			break;
		case "LOAD_WITHDRAWN":
			loadWithdrawn(request, response);
			break;
		case "WITHDRAWN":
			withdrawn(request, response);
			break;
			


//		case "UPDATE":
//			updateResult(request, response);
//			break;
//		case "DELETE":
//			deleteResult(request, response);
//			break;
		case "LOGOUT":
			session.invalidate();
			response.sendRedirect("login");
			break;

		default:
			showAccountList(request, response);
			break;
		}
		
		}else {
			response.sendRedirect("login");
		}
		
		
	}
	
	private void showAccountList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		List<Account> accountList = this.accountDAO.getAccountList();
		request.setAttribute("accountList", accountList);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}
	
	private void showPersonal(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		String accountno = user.getAccountno();
		Account acc = this.accountDAO.getAccountByAccountNo(accountno);
		request.setAttribute("acc", acc);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}


	
	private void createAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		String accountno = request.getParameter("accountno");
		String name = request.getParameter("name");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String address = request.getParameter("address");
		String phno = request.getParameter("phno");
		
		
		Account account = new Account(accountno,name, amount, address, phno);
		
		int rowEffected = this.accountDAO.createAccount(account);
		
		if(rowEffected > 0)
			showAccountList(request, response);
		response.sendRedirect("accountLogin");
		
	}
	private void loadDeposit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		
		int id=Integer.parseInt(request.getParameter("id"));
		Account account = this.accountDAO.getAccount(id);
		request.setAttribute("account", account);
		RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
		rd.forward(request, response);

	}
	
	
	private void deposit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		
		int id = Integer.parseInt(request.getParameter("id"));
		String accountno = request.getParameter("accountno");
		String name = request.getParameter("name");
		double amount= Double.parseDouble(request.getParameter("amount"));
		String address = request.getParameter("address");
		String phno = request.getParameter("phno");
		
		Account account = new Account(id, accountno, name, amount, address, phno);
		int rowEffected = this.accountDAO.deposit(account);
		if(rowEffected > 0) {
			showPersonal(request, response);
		}
		
	}
	
	
	
	private void loadWithdrawn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		
		int id=Integer.parseInt(request.getParameter("id"));
		//String accno = user.getAccountno();
		Account account = this.accountDAO.getAccount(id);
		request.setAttribute("account", account);
		RequestDispatcher rd = request.getRequestDispatcher("withdrawn.jsp");
		rd.forward(request, response);

	}
	
	
	private void withdrawn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		
		int id = Integer.parseInt(request.getParameter("id"));
		String accountno = request.getParameter("accountno");
		String name = request.getParameter("name");
		double amount= Double.parseDouble(request.getParameter("amount"));
		String address = request.getParameter("address");
		String phno = request.getParameter("phno");
		
		Account account = new Account(id, accountno, name, amount, address, phno);
		int rowEffected = this.accountDAO.withdrawn(account);
		if(rowEffected >0) {
			showPersonal(request, response);
		}
		
		
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
