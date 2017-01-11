package com.kate.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kate.util.CustomerDAO;


@WebServlet("/DeleteCustServlet")
public class DeleteCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCustServlet() {
        super();      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idStr = request.getParameter("id");
		int custId = Integer.parseInt(idStr);
		
		CustomerDAO.delete(custId);
		
		response.sendRedirect("CustomerServlet");
	}

}
