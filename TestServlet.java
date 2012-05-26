
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();

		sb.append("<html><body bgcolor=white text=black>");
		sb.append("<h1 align=center> Welcome to Jeff's Text Replacement</h1>");
		sb.append("<form method=\"POST\" action =\" /Test/TestServlet\" >");
		sb.append("ENTER REGEX: "
				+ "<input type=\"text\" name=\"regex\"/><br />");
		sb.append("ENTER REPLACEMENT: "
				+ "<input type=\"text\" name=\"replacement\"/><br />");
		sb.append(" ENTER DOCUMENT TEXT: "
				+ "<input TYPE=\"TEXTAREA\" rows=\"3\" cols=\"20\" name=\"docText\"/><br />");
		sb.append("<br /><input type=\"submit\" value=\"Submit\">");
		sb.append("</form></body></html>");

		out.println(sb);
		out.close();	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		SearchReplaceDocs srd = new SearchReplaceDocs(
				req.getParameter("regex"), req.getParameter("replacement"),
				req.getParameter("docText"));
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.println(srd.replaceAndPrint());

		out.println("<form method=\"GET\" action = \" /Test/TestServlet\" >");
		out.println("<input type=\"submit\" value = \"Go Back\">");
		out.close();
	}
}
