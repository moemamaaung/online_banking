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
 * Servlet implementation class DepositController
 */
public class DepositController extends HttpServlet {
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
    public DepositController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		if(mode == null) {
			loadDeposit(request, response);
		}
		if(mode == "DEPOSIT") {
			deposit(request, response);
		}
		
	}
	
	
	private void loadDeposit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		
		
		String accno = user.getAccountno();
		Account account = this.accountDAO.getAccountByAccountNo(accno);
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
		
		Account account = this.accountDAO.getAccount(id);
		int rowEffected = this.accountDAO.deposit(account,amount);
		if(rowEffected >0) {
			response.sendRedirect("balance");
		}
		
		
	}
	
	
	
//	private void showDeposit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
//		request.setAttribute("user",user);
//		String accountno = user.getAccountno();
//		Account personalAcc = this.accountDAO.getAccountByAccountNo(accountno);
//		request.setAttribute("personalAcc", personalAcc);
//		RequestDispatcher rd = request.getRequestDispatcher("deposit1.jsp");
//		rd.forward(request, response);
//		
//	}
//	


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
