package com.kate.listeners;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.kate.util.DBConnectionManager;

/*AppContextListener är en ServletContextListener som har två 
metoder. Den ena körs innan uppstart och den andra precis innan 
nedstängning av appen. Här skapar och stänger vi vår databasanslutning
*/
@WebListener
public class AppContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext ctx = servletContextEvent.getServletContext();
		
		/*
		data to initialise database connection
		dbURL, dbUser and dbpassword are all parameter 
		that has been defined in web.xml
		*/
		String dbURL = ctx.getInitParameter("dbURL");
		String user = ctx.getInitParameter("dbUser");
		String pwd = ctx.getInitParameter("dbPassword");
		
		try{
			// get database connection
			DBConnectionManager connectionManager = new DBConnectionManager(dbURL, user, pwd);
			ctx.setAttribute("DBConnection", connectionManager.getConnection());
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		Connection con = (Connection) servletContextEvent.getServletContext().getAttribute("DBConnection");
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}	
}
