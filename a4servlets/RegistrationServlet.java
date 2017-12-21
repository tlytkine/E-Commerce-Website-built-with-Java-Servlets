import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class RegistrationServlet extends HttpServlet
{
  static final boolean debug = false;
  
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("<html><head><title>Registration</title></head><body>");
    
    out.println("<form action=\"http://unix.seas.gwu.edu:40223/servlets/a4servlets/RegistrationServlet\" method=\"post\">");
    
    String usr = req.getParameter("userName");
    String pass = req.getParameter("userPass");
    String fn = req.getParameter("fullName");
    String addr = req.getParameter("address");
    
    File f = new File(usr);
    if (!f.exists())
    {
      f.createNewFile();
      FileWriter fw = new FileWriter(f);
      fw.write(usr);
      fw.write("\n");
      fw.write(pass);
      fw.write("\n");
      fw.write(fn);
      fw.write("\n");
      fw.write(addr);
      fw.write("\n");
      fw.close();
      out.println("Registration successful!<br>");
    }
    else
    {
      out.println("<br> <font color=\"#FF0000\">You are already registered. Please login.</font><br>");
    }
    out.println("<a href=\"http://unix.seas.gwu.edu:40223/a4html/home.html\">Click here to go back to homepage.</a> <br>");
    out.flush();
  }
  
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    doGet(req, resp);
  }
  
  void printParams(PrintWriter out, HttpServletRequest req)
  {
    out.println("<p><hr><p> Request parameters: <ul>");
    Enumeration e = req.getParameterNames();
    while (e.hasMoreElements())
    {
      String str1 = (String)e.nextElement();
      String str2 = req.getParameter(str1);
      if (str2 != null) {
        out.println("<li> name=[" + str1 + "] value=[" + str2 + "]");
      } else {
        out.println("<li> name=[" + str1 + "] did not have a value");
      }
    }
    out.println("</ul><hr>");
  }
}
