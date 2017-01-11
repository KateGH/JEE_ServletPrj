package com.kate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet som registrerar en ny användare i databasen
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String errorMsg = null;
		
		//here to control carefully if email is the correct e-mail address
		if(email == null || email.equals("")){
			errorMsg = "Email id cannot be null or empty.";
		}
		if(password == null || password.equals("")){
			errorMsg = "Password cannot be null or empty.";
		}
		if(name == null || name.equals("")){
			errorMsg = "Name cannot be null or empty.";
		}
		
		if(errorMsg != null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>" + errorMsg + "</font>");
			rd.include(request, response);
		
		}else{
			Connection con = (Connection) getServletContext().getAttribute("DBConnection");
			PreparedStatement ps = null;
				
			try{
				ps = con.prepareStatement("INSERT INTO Userminimart(name, email, password) VALUES (?, ?, ?)");
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, password);
				
				ps.execute();
				
				//forward to log-in page to log-in
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
				PrintWriter out = response.getWriter();
				out.println("<font color=green> Registration successful, please log-in below.</font>");
				
				rd.include(request, response);
				
			}catch(SQLException e){
				e.printStackTrace();
				throw new ServletException("DB Connection problem");
			}finally{
				try{
					ps.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}	
		}
	}
}

