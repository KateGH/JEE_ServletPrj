package com.kate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kate.util.Customer;
import com.kate.util.CustomerDAO;


@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CustomerServlet() {
        super();    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
		request.getRequestDispatcher("link.html").include(request, response);
        
        out.println("<h1>Customer List</h1>");  
           
        List<Customer> list = CustomerDAO.getAllCustomers();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>CustomerID</th><th>CustomerName</th><th>ContactName</th><th>Address</th><th>City</th><th>PostalCode</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");  
        for(Customer cust:list){  
         out.print("<tr><td>"+cust.getCustID()+"</td><td>"+cust.getCustName()+"</td><td>"+cust.getContactName()+"</td>"
         		+ "<td>"+cust.getAddress()+"</td><td>"+cust.getCity()+"</td>"
         				+ "<td>"+cust.getPostalCode()+"</td><td>"+cust.getCountry()+"</td>"
         					+ "<td><a href='EditCustServlet?id="+cust.getCustID()+" '>edit</a></td>"
         						+ "<td><a href='DeleteCustServlet?id="+cust.getCustID()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.println("<a href='customer.html'><input type='submit' value='Add New Customer'/></a>");
        out.close();  
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
