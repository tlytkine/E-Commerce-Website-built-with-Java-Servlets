import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AccountServlet extends HttpServlet {

    static final boolean debug = false;

    public void doGet (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
    {
	resp.setContentType ("text/html");
	PrintWriter out = resp.getWriter ();
	out.println ("<html><head><title>Account Page</title></head><body>");

	if (debug) {
	    printParams (out, req);
	}

	out.println ("<form action=\"http://unix.seas.gwu.edu:40223/servlets/a4servlets/AccountServlet\" method=\"post\">");
	
	String current = "current";
	File file = new File(current);
	FileReader fr = new FileReader(file);
	LineNumberReader lnr = new LineNumberReader(fr);
	String user = lnr.readLine();
	fr.close();
	lnr.close();

	String lv = "loginval";
	File logval = new File(lv);
	FileReader fr2 = new FileReader(logval);	
	LineNumberReader lnr2 = new LineNumberReader(fr2);
	String loginVal = lnr2.readLine();
	fr2.close();
	lnr2.close();
	
	if(loginVal.equals("true")) {
	File account = new File(user);
	FileReader fr1 = new FileReader(account);
	LineNumberReader lnr1 = new LineNumberReader(fr1);
	String username = lnr1.readLine();
	String password = lnr1.readLine();
	String fullName = lnr1.readLine();
	String address = lnr1.readLine();
	fr1.close();
	lnr1.close();
	out.println("<h1>Account Information</h1>");
	out.print("<br>Username: ");		
	out.println(username);		
	out.print("<br>Full name: ");
	out.println(fullName);
	out.print("<br>Address: ");
	out.println(address);
	}
	else {
	out.println("Please login to view the account page.");
	}
	out.println ("<br><a href=\"http://unix.seas.gwu.edu:40223/a4html/home.html\">Click here to return to homepage.</a><br>");
	out.println ("</form></body></html>");
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
