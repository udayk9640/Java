package com.uday.bank;

import java.io.IOException;
import java.sql.SQLException;

import com.uday.bank.Dao.BankAccountDAO;
import com.uday.bank.Dto.BankAccount;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class addBankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public addBankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String acctNo = request.getParameter("accountnumber");
		 String bankName = request.getParameter("bankname");
		 String ifsc = request.getParameter("ifsccode");
		 String pin =  request.getParameter("pin");
		 HttpSession session = request.getSession();
		 int userId =  (int)session.getAttribute("userId");
		 BankAccount b = new BankAccount();
		 b.setAcctBalance(500);
		 b.setAcctNumber(acctNo);
		 b.setBankName(bankName);
		 b.setIfsc(ifsc);
		 b.setAccTypeId(1);
		 b.setPin(Integer.parseInt(pin));
		 b.setUserId(userId);
		 try {
			BankAccountDAO bdao = new BankAccountDAO();
			if(bdao.addAcct(b)>0) {
				RequestDispatcher rd = request.getRequestDispatcher("/dashboard.jsp");
				rd.forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}