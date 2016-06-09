package ServletCodeExamples01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "InitParameterServletConfigDemo", 
urlPatterns = { "/servletConfigDemoServlet" }, initParams = {
		@WebInitParam(name = "email", value = "ex@example.com"), 
		@WebInitParam(name = "admin", value = "Ivan Ivanov") })

//By Implementing Servlet interface

public class InitParameterServlet implements Servlet {

	private transient ServletConfig servletConfig;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {

		return servletConfig;
	}

	@Override
	public String getServletInfo() {

		return "InitParameterServletConfigDemoServlet";
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

		this.servletConfig = servletConfig;

	}

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
