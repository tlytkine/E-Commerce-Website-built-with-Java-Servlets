import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class TestLogin extends HttpServlet {

    static final boolean debug = false;


    public void doGet (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
    {
	resp.setContentType ("text/html");
	PrintWriter out = resp.getWriter ();
	out.println ("<html><head><title>Login Page</title></head><body>");

	if (debug) {
	    printParams (out, req);
	}

	out.println ("<form action=\"http://unix.seas.gwu.edu:40223/servlets/a4servlets/TestLogin\" method=\"post\">");

	String usr = req.getParameter ("userName");
	String pass = req.getParameter ("userPass");

	File f = new File(usr);
	if( ! f.exists()){
	out.println ("Username not found.<br>");
	}    
	LineNumberReader lnr = new LineNumberReader (new FileReader (f));
	if (lnr.readLine() != null){
	String str = lnr.readLine();
		if(str.equals(pass)){
			out.println("Login successful!<br>");
			String y1 = "loginval";
			File val = new File(y1);
			FileWriter x1 = new FileWriter(val, false);
			x1.write("true");
			x1.close();			
			String y = "current";
			File curr = new File(y);
			FileWriter x = new FileWriter(curr, false);
			x.write(usr);
			x.close();
			String c = "cart";
			File ca = new File(c);
			FileWriter car = new FileWriter(ca, false);
			car.write("");
			car.close();
		}	
		else {
			out.println("Password invalid.<br>");
			String y2 = "loginval";
			File val1 = new File(y2);
			FileWriter x2 = new FileWriter(val1,false);
			x2.write("false");
			x2.close();
		}
	}
	out.println ("<a href=\"http://unix.seas.gwu.edu:40223/a4html/home.html\">Click here to return to homepage.</a><br>");
	out.println ("</form></body></html>");
	out.flush();
    }
  

    public void doPost (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
    {
	// We need to implement POST because the forms are written as such.
	doGet (req, resp);
    }

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
