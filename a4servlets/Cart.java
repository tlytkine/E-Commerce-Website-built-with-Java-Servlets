import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Cart extends HttpServlet {

    static final boolean debug = false;

    public void doGet (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
    {
	resp.setContentType ("text/html");
	PrintWriter out = resp.getWriter ();
	out.println ("<html><head><title>View your cart</title></head><body>");

	if (debug) {
	    printParams (out, req);
	}

	out.println ("<form action=\"http://unix.seas.gwu.edu:40223/servlets/a4servlets/Cart\" method=\"post\">");
	
	int numBio = 0; int numChem = 0; int numPhys = 0;
	int numCS = 0; int numPS = 0; int numStat = 0;
	int numCalc = 0;int numEcon = 0;

	String current = "current"; String lv = "loginval";
	File logval = new File(lv);
	FileReader fr2 = new FileReader(logval);	
	LineNumberReader lnr2 = new LineNumberReader(fr2);
	String loginVal = lnr2.readLine();
	fr2.close(); lnr2.close();
	String cart = "cart"; String str = "";

	LineNumberReader lnr3 = null;
	FileReader fr3 = null;
	out.println("<h1>Shopping Cart</h1><br>");

	if(loginVal.equals("true")) {
		File cartfile = new File(cart);
		fr3 = new FileReader(cartfile);
		lnr3 = new LineNumberReader(fr3);
	}
	
	while((str=lnr3.readLine())!=null) {
		if(str.equals("biology")){ 
			numBio++;
		}
		if(str.equals("physics")){
			numPhys++;
		}
		if(str.equals("chemistry")){
			numChem++;
		}
		if(str.equals("economics")){
			numEcon++;
		}
		if(str.equals("computerscience")){
			numCS++;
		}
		if(str.equals("politicalscience")){
			numPS++;
		}
		if(str.equals("statistics")){
			numStat++;
		}
		if(str.equals("calculus")){
			numCalc++;
		}
	}
	fr3.close();
	lnr3.close();
	int bioTotal = numBio * 10; int physTotal = numPhys * 10; int csTotal = numCS * 10;
	int statTotal = numStat * 10; int calcTotal = numCalc * 10; int psTotal = numPS * 10;
	int chemTotal = numChem * 10; int econTotal = numEcon * 10;
	int total = bioTotal + statTotal + chemTotal + physTotal + calcTotal + econTotal + csTotal + psTotal;	

	out.println("<table>");
	out.println("<tr>");
	out.println("<th><b>Product Name</b></th>");
	out.println("<th><b>Product Image</b></th>");
	out.println("<th><b>Quantity</b></th>");
	out.println("<th><b>Price</b></th>");
	out.println("</tr>");
	if(numBio>0){
		out.println("<tr>");
		out.println("<td>Biology Textbook</td>");
		out.println("<td><img src=\"http://unix.seas.gwu.edu:40223/a4html/img/biology.jpg\" height=\"200\" width=\"200\"></td>");
		out.println("<td>"); out.println(numBio); out.println("</td>");
		out.println("<td>"); out.println("$"); out.println(bioTotal); out.println("</td>");
		out.println("</tr>");
	}
	if(numPhys>0){
		out.println("<tr>");
		out.println("<td>Physics Textbook</td>");
		out.println("<td><img src=\"http://unix.seas.gwu.edu:40223/a4html/img/physics.png\" height =\"200\" width=\"200\"></td>");
		out.println("<td>"); out.println(numPhys); out.println("</td>");
		out.println("<td>"); out.println("$"); out.println(physTotal); out.println("</td>");
		out.println("</tr>");
	}
	if(numChem>0){
		out.println("<tr>");
		out.println("<td>Chemistry Textbook</td>");
		out.println("<td><img src=\"http://unix.seas.gwu.edu:40223/a4html/img/chemistry.jpg\" height =\"200\" width=\"200\"></td>");
		out.println("<td>"); out.println(numChem); out.println("</td>");
		out.println("<td>"); out.println("$"); out.println(chemTotal); out.println("</td>");
		out.println("</tr>");
	}
	if(numEcon>0){
		out.println("<tr>");
		out.println("<td>Economics Textbook</td>");
		out.println("<td><img src=\"http://unix.seas.gwu.edu:40223/a4html/img/economics.jpg\" height =\"200\" width=\"200\"></td>");
		out.println("<td>"); out.println(numEcon); out.println("</td>");
		out.println("<td>"); out.println("$"); out.println(econTotal); out.println("</td>");
		out.println("</tr>");
	}
	if(numCS>0){
		out.println("<tr>");
		out.println("<td>Computer Science Textbook</td>");
		out.println("<td><img src=\"http://unix.seas.gwu.edu:40223/a4html/img/computerscience.jpg\" height =\"200\" width=\"200\"></td>");
		out.println("<td>"); out.println(numCS); out.println("</td>");
		out.println("<td>"); out.println("$"); out.println(csTotal); out.println("</td>");
		out.println("</tr>");
	}
	if(numPS>0){
		out.println("<tr>");
		out.println("<td>Political Science Textbook</td>");
		out.println("<td><img src=\"http://unix.seas.gwu.edu:40223/a4html/img/politicalscience.jpg\" height =\"200\" width=\"200\"></td>");
		out.println("<td>"); out.println(numPS); out.println("</td>");
		out.println("<td>"); out.println("$"); out.println(psTotal); out.println("</td>");
		out.println("</tr>");
	}
	if(numStat>0){
		out.println("<tr>");
		out.println("<td>Statistics Textbook</td>");
		out.println("<td><img src=\"http://unix.seas.gwu.edu:40223/a4html/img/statistics.jpg\" height =\"200\" width=\"200\"></td>");
		out.println("<td>"); out.println(numStat); out.println("</td>");
		out.println("<td>"); out.println("$"); out.println(statTotal); out.println("</td>");
		out.println("</tr>");
	}
	if(numCalc>0){
		out.println("<tr>");
		out.println("<td>Calculus Textbook</td>");
		out.println("<td><img src=\"http://unix.seas.gwu.edu:40223/a4html/img/calculus.png\" height =\"200\" width=\"200\"></td>");
		out.println("<td>");out.println(numCalc); out.println("</td>");
		out.println("<td>"); out.println("$"); out.println(calcTotal); out.println("</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	out.println("Total: $");
	out.println(total);
	if(total==0){
		out.println("Please make sure you are logged in to add items to view and add items to your cart.");
	}
	else {
		out.println ("Make sure to review your order before checking out.<br>");
		out.println ("<a href=\"http://unix.seas.gwu.edu:40223/servlets/a4servlets/Checkout\">Check out.</a><br>");
	}
	out.println ("<br><a href=\"http://unix.seas.gwu.edu:40223/a4html/products.html\">Click here to return to the product page.</a><br>");
	out.println ("<br><a href=\"http://unix.seas.gwu.edu:40223/a4html/home.html\">Click here to return to the home page.</a><br>");
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
