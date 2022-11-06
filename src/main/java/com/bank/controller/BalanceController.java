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

import javax.sql.DataSource;

import com.bank.model.Account;
import com.bank.model.AccountDAO;
import com.bank.model.User;

/**
 * Servlet implementation class BalanceController
 */
public class BalanceController extends HttpServlet {
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
    public BalanceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showPersonalAccount(request, response);

	}
	
	private void showPersonalAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		String accountno = user.getAccountno();
		Account personalAcc = this.accountDAO.getAccountByAccountNo(accountno);
		request.setAttribute("personalAcc", personalAcc);
		RequestDispatcher rd = request.getRequestDispatcher("balance.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
