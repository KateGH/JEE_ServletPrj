package com.kate.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//LogoutServlet som loggar ut oss genom att invalidera användarens session
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LogoutServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		//false bcoz we will not create new seesion if there is none
		HttpSession session = request.getSession(false);
		if(session == null){
			//there is no session for this user (not yet log-in)
			out.println("You are not yet logged-in");
		}else{
			// take away this session
			session.invalidate();
			out.print("You are now log-out");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}

}
