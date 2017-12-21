import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Submit extends HttpServlet {

    static final boolean debug = false;

    public void doGet (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
    {
	resp.setContentType ("text/html");
	PrintWriter out = resp.getWriter ();
	out.println ("<html><head><title>Checkout</title></head><body>");

	if (debug) {
	    printParams (out, req);
	}

	out.println ("<form action=\"http://unix.seas.gwu.edu:40223/servlets/a4servlets/Submit\" method=\"post\">");
	out.println("<br><h1><b>Thank you for submitting your order!</b></h1><br>");
	out.println("<a href=\"http://unix.seas.gwu.edu:40223/a4html/home.html\">Click here to return back to the home page.</a>");
	out.println("</form></body></html>");
	out.flush();	
    }
  

    public void doPost (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
    {
	doGet (req, resp);
    }
  

    // For debugging:

    void printParams (PrintWriter out, HttpServletRequest req)
    {
	out.println ("<p><hr><p> Request parameters: <ul>");
	Enumeration e = req.getParameterNames();
	while (e.hasMoreElements()) {
	    String name = (String) e.nextElement();
	    String value = req.getParameter (name);
	    if (value != null)
		out.println ("<li> name=[" + name + "] value=[" + value + "]");
	    else
		out.println ("<li> name=[" + name + "] did not have a value");
	}
	out.println ("</ul><hr>");
    }

}
