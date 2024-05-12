package com.uday.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.uday.bank.Dao.UserDAO;
import com.uday.bank.Dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

 
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RegisterServlet() {
        super();
     }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phno = request.getParameter("phno");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String pattern =  "yyyy-MM-dd";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDate birthDate = LocalDate.parse(dob, formatter);
 
		
		 if(password.equals(confirmPassword)) {
			 try {
				 User u = new User();
//				 u.setUserId();
				 u.setPhNo(phno);
				 u.setPassword(confirmPassword);
				 u.setFirstName(firstName);
				 u.setLastName(lastName);
				 u.setAddress(address);
				 u.setDob(birthDate);
				 
				  
				UserDAO dao = new UserDAO();
				if( dao.addUserInfo(u) >0){
					HttpSession session = request.getSession();
					session.setAttribute("regmsg","registered successfully");
					RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}
				  
				 
				 
				 
			} catch (ClassNotFoundException e) {
 				e.printStackTrace();
			} catch (SQLException e) {
 				e.printStackTrace();
			}  
		 }
		 else {
			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			 out.print("password mismatch");
			 RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
			 rd.include(request, response);
		 }
//		 
	}
}