package com.kate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kate.util.User;

import javax.servlet.RequestDispatcher;

//LoginServlet som kontrollerar mot databasen att vi angett rätt inloggningsuppgifter.
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LoginServlet(){
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			
			ps = con.prepareStatement("SELECT id, name, email FROM Userminimart WHERE email=? and password=? limit 1");
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs !=null && rs.next()){
				
				User user = new User(rs.getString("name"), rs.getString("email"), rs.getInt("id"));
				HttpSession session = request.getSession();
				session.setAttribute("User", user.getName());
				request.getRequestDispatcher("MainServlet").forward(request, response);
				
			}else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");			
				PrintWriter out = response.getWriter();
				out.println("<font color=red>No user found with given email id, please register first.</font>");
				rd.include(request, response);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new ServletException("DB Connection problem.");
			
		}finally{
			try{
				rs.close();
				ps.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
