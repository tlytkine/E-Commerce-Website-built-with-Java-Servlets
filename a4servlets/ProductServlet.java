import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ProductServlet extends HttpServlet {

    static final boolean debug = false;

    public void doGet (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
    {
	resp.setContentType ("text/html");
	PrintWriter out = resp.getWriter ();
	out.println ("<html><head><title>Cart Page</title></head><body>");

	if (debug) {
	    printParams (out, req);
	}

	out.println ("<form action=\"http://unix.seas.gwu.edu:40223/servlets/a4servlets/ProductServlet\" method=\"post\">");
	
	String bio = req.getParameter("biology");
	String phys = req.getParameter("physics");
	String chem = req.getParameter("chemistry");
	String econ = req.getParameter("economics");
	String cs = req.getParameter("computerscience");
	String poli = req.getParameter("politicalscience");
	String stat = req.getParameter("statistics");
	String calc = req.getParameter("calculus");
	
 
	String current = "current";
	String lv = "loginval";
	File logval = new File(lv);
	FileReader fr2 = new FileReader(logval);	
	LineNumberReader lnr2 = new LineNumberReader(fr2);
	String loginVal = lnr2.readLine();
	fr2.close();
	lnr2.close();
	String cart = "cart";
	
	if(loginVal.equals("true")) {
	File cartfile = new File(cart);
	FileWriter x1 = new FileWriter(cartfile,true);
	
	if(bio!=null){
		x1.write("biology");
		x1.write("\n");
		out.println("Biology Textbook successfully added to cart!");
	}

	if(phys!=null){
		x1.write("physics");
		x1.write("\n");
		out.println("Physics Textbook successfully added to cart!");
	}

	if(chem!=null){
		x1.write("chemistry");
		x1.write("\n");
		out.println("Chemistry Textbook successfully added to cart!");
	}

	if(econ!=null){
		x1.write("economics");
		x1.write("\n");
		out.println("Economics Textbook successfully added to cart!");
	}

	if(cs!=null){
		x1.write("computerscience");
		x1.write("\n");
		out.println("Computer Science Textbook successfully added to cart!");
	}

	if(poli!=null){
		x1.write("politicalscience");
		x1.write("\n");
		out.println("Political Science Textbook successfully added to cart!");
	}
	if(stat!=null){
		x1.write("statistics");
		x1.write("\n");
		out.println("Statistics Textbook successfully added to cart!");
	}
	if(calc!=null){
		x1.write("calculus");
		x1.write("\n");
		out.println("Calculus Textbook successfully added to cart!");
	}
	x1.close();
	}
	else {
		out.println("Please login to add items to cart.");
		File wipe = new File(cart);
		FileWriter wiper = new FileWriter(wipe);
		PrintWriter pwVar = new PrintWriter(wiper);
		pwVar.write("");
		pwVar.close();
	}
	out.println ("<br><a href=\"http://unix.seas.gwu.edu:40223/a4html/products.html\">Click here to return to the product page.</a><br>");
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
