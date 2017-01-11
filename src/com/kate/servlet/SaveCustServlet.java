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


@WebServlet("/SaveCustServlet")
public class SaveCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SaveCustServlet() {
        super();      
    }

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String custName = request.getParameter("custName");
		String contactName = request.getParameter("contactName");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String postcode = request.getParameter("postcode");
		String country = request.getParameter("country");
		
		Customer cust = new Customer();
		cust.setCustName(custName);
		cust.setContactName(contactName);
		cust.setAddress(address);
		cust.setCity(city);
		cust.setPostalCode(postcode);
		cust.setCountry(country);
		
		int status = CustomerDAO.save(cust);
		if(status>0){
			out.print("<font color=green>New customer saved successfully!</font>");
			request.getRequestDispatcher("customer.html").include(request, response);
		}
		else{
			out.println("Unable to save record!!");
		}
		out.close();
	}

}
