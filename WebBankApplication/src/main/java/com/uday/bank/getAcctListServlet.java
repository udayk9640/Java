package com.uday.bank;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.uday.bank.Dao.BankAccountDAO;
import com.uday.bank.Dto.BankAccount;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class getAcctListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public getAcctListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cookieName = "userId";
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			
		}
		
		 HttpSession session = request.getSession();
		 int userId = (int) session.getAttribute("userId");
		 try {
			BankAccountDAO bankDao = new BankAccountDAO();
			List<BankAccount> list = bankDao.getBankAcctList(userId);
			session.setAttribute("bankList", list);
//			RequestDispatcher rd = request.getRequestDispatcher("/dashboard.jsp");
//			rd.forward(request, response);
			RequestDispatcher rdacct = request.getRequestDispatcher("/dashboard.jsp");
			rdacct.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
     }
}