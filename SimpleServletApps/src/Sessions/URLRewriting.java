package Sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "URLRewriting", urlPatterns = { "/URLRewriting" })
public class URLRewriting extends HttpServlet {
	private static final long serialVersionUID = 987654321L;

	private List<String> londonAttractions;
	private List<String> parisAttractions;

	@Override
	public void init() throws ServletException {
		londonAttractions = new ArrayList<String>(10);
		londonAttractions.add("Attraction 1");
		londonAttractions.add("Attraction 2");
		londonAttractions.add("Attraction 3");
		londonAttractions.add("Attraction 4");
		londonAttractions.add("Attraction 5");
		londonAttractions.add("Attraction 6");
		londonAttractions.add("Attraction 7");
		londonAttractions.add("Attraction 8");
		londonAttractions.add("Attraction 9");
		londonAttractions.add("Attraction 10");

		parisAttractions = new ArrayList<String>(10);
		parisAttractions.add("Attraction 1");
		parisAttractions.add("Attraction 2");
		parisAttractions.add("Attraction 3");
		parisAttractions.add("Attraction 4");
		parisAttractions.add("Attraction 5");
		parisAttractions.add("Attraction 6");
		parisAttractions.add("Attraction 7");
		parisAttractions.add("Attraction 8");
		parisAttractions.add("Attraction 9");
		parisAttractions.add("Attraction 10");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String city = request.getParameter("city");
		if (city != null && (city.equals("london") || city.equals("paris"))) {
			
			showAttractions(request, response, city);
		} else {
			// show main page
			showMainPage(request, response);
		}
	}

	private void showMainPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head>" + "<title>Top 10 Tourist Attractions</title>" + "</head><body>"
				+ "Please select a city:" + "<br/><a href='?city=london'>London</a>"
				+ "<br/><a href='?city=paris'>Paris</a>" + "</body></html>");
	}

	private void showAttractions(HttpServletRequest request, HttpServletResponse response, String city)
			throws ServletException, IOException {

		int page = 1;
		String pageParameter = request.getParameter("page");
		if (pageParameter != null) {
			try {
				page = Integer.parseInt(pageParameter);
			} catch (NumberFormatException e) {
			
				
			}
			if (page > 2) {
				page = 1;
			}
		}
		List<String> attractions = null;
		if (city.equals("london")) {
			attractions = londonAttractions;
		} else if (city.equals("paris")) {
			attractions = parisAttractions;
		}
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head>" + "<title>Top 10 Tourist Attractions</title>" + "</head><body>");
		writer.println("<a href='top10'>Select City</a> ");
		writer.println("<hr/>Page " + page + "<hr/>");

		int start = page * 5 - 5;
		for (int i = start; i < start + 5; i++) {
			writer.println(attractions.get(i) + "<br/>");
		}
		writer.print("<hr style='color:blue'/>" + "<a href='?city=" + city + "&page=1'>Page 1</a>");
		writer.println("&nbsp; <a href='?city=" + city + "&page=2'>Page 2</a>");
		writer.println("</body></html>");
	}
}