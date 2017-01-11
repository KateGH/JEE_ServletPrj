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


@WebServlet("/EditCustServlet")
public class EditCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditCustServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Customer</h1>");
		
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		Customer theCust = CustomerDAO.getCustomerById(id);
		
		out.print("<form action='EditCustServlet2' method='post'>");  
        out.print("<table>");   
        out.print("<tr><td></td><td><input type='hidden' name='CustID' value='"+theCust.getCustID()+"'/></td></tr>");  
        out.print("<tr><td>Customer Name:</td><td><input type='text' name='custName' value='"+theCust.getCustName()+"'/></td></tr>");  
        out.print("<tr><td>Contact person:</td><td><input type='text' name='contactName' value='"+theCust.getContactName()+"'/></td></tr>");  
        out.print("<tr><td>Address:</td><td><input type='text' name='address' value='"+theCust.getAddress()+"'/></td></tr>");  
        out.print("<tr><td>City:</td><td><input type='text' name='city' value='"+theCust.getCity()+"'/></td></tr>");  
        out.print("<tr><td>PostalCode:</td><td><input type='text' name='postcode' value='"+theCust.getPostalCode()+"'/></td></tr>");  
        
        out.print("<tr><td>Country:</td><td>");  
        out.print("<select name='country' style='width:150px'>");  
        out.print("<option>Germany</option>");  
        out.print("<option>Italy</option>");  
        out.print("<option>Sweden</option>");  
        out.print("<option>UK</option>");  
        out.print("<option>Other</option>");  
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        
        out.print("</table>");  
      
        out.print("</form>");  
          
        out.print("<a href='CustomerServlet'><input type='submit' value='Cancel'/></a>"); 
       
        
        out.close(); 
	
	}

}
