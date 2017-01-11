package com.kate.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResetPWServlet")
public class ResetPWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public ResetPWServlet() {
        super();      
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
//		if(){
//			
//		}
	}

}
