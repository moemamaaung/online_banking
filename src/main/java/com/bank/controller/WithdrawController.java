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
 * Servlet implementation class WithdrawController
 */
public class WithdrawController extends HttpServlet {
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
    public WithdrawController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		if(mode == null) {
			loadWithdrawn(request, response);
		}
		if(mode == "WITHDRAWN") {
			withdrawn(request, response);
		}
	}
	
	
	private void loadWithdrawn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	request.setAttribute("user",user);
	
	String accno = user.getAccountno();
	Account account = this.accountDAO.getAccountByAccountNo(accno);
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
	
	Account account = this.accountDAO.getAccount(id);
	int rowEffected = this.accountDAO.withdrawn(account, amount);
	if(rowEffected >0) {
		response.sendRedirect("balance");
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
