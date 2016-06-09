package ServletCodeExamples01;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "SimpleGreetingServlet", urlPatterns = {"/SimpleGreeetingServlet"})

// By Implementing Servlet interface

public class SimpleGreetingServlet implements Servlet{

	private transient ServletConfig servletConfig;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return servletConfig ;
	}

	@Override
	public String getServletInfo() {
		return "This is a simple servlet";
	}

	@Override
	public void init(ServletConfig serletConfig) throws ServletException {
		
		this.servletConfig = servletConfig;
	
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String servletName = servletConfig.getServletName();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html> <body> Hello from " + 
				  "" + servletName + 
				  "</body> </html>");

		

	}
	
	

}
