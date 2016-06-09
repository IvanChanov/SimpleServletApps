package ServletCodeExamples01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "InitParameterServletConfigDemo", 
urlPatterns = { "/ExtendingGenericServletClass" }, initParams = {
		@WebInitParam(name = "FirstName", value = "Ivan"), 
		@WebInitParam(name = "LastName", value = "Ivanov") })

public class ExtendingGenericServletClass extends GenericServlet{


	// Extending  GenericServlet does not require all methods to be overridden
	
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	
		
		ServletConfig servletConfig = getServletConfig();
		String adminName = servletConfig.getInitParameter("admin");
		String emailAddress = servletConfig.getInitParameter("email");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html> <body> Admin name is :  " + adminName + " and his/her email address is : " + emailAddress
				+ "</body> </html>");
		
		
	}

}
