import javax.servlet.*;
import java.io.*;
public class WelcomeServelet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse resp) throws IOException
	{
		String name=req.getParameter("user");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html><body>");
		out.println("<h2>Welcome"+name+"</h2>");
		out.println("</body></html>");
		out.close();
	}
		
}