package com.kate.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kate.util.Customer;
import com.kate.util.CustomerDAO;


@WebServlet("/EditCustServlet2")
public class EditCustServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public EditCustServlet2() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String idStr = request.getParameter("CustID");
		int custId = Integer.parseInt(idStr);
		
		String custName = request.getParameter("custName");
		String contactName = request.getParameter("contactName");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String postcode = request.getParameter("postcode");
		String country = request.getParameter("country");
		
		Customer theCust = new Customer();
		theCust.setCustID(custId);
		theCust.setCustName(custName);
		theCust.setContactName(contactName);
		theCust.setAddress(address);
		theCust.setCity(city);
		theCust.setPostalCode(postcode);
		theCust.setCountry(country);
		
		int status = CustomerDAO.update(theCust);
		if(status>0){
			response.sendRedirect("CustomerServlet");
		}else{
			out.println("<font color=red>Unable to update record!</font>");
		}
		
		out.close();
	}

}
