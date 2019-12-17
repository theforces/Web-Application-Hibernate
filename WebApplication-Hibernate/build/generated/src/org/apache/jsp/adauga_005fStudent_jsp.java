package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adauga_005fStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("        <title>Studenti</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: black; color: white\">\n");
      out.write("\n");
      out.write("        <div id=\"add\">\n");
      out.write("            <h1 class=\"w3-panel w3-border-left w3-pale-red w3-border-red\"> Adauga student </h1>\n");
      out.write("            <form action=\"StudentiController\" method=\"GET\">\n");
      out.write("                <table>\n");
      out.write("                    <tr class=\"w3-panel w3-border w3-border-red w3-hover-border-green\">\n");
      out.write("                        <td class=\"w3-panel w3-leftbar w3-border-blue w3-pale-blue\"> Nume Student: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"nume\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr class=\"w3-panel w3-border w3-border-red w3-hover-border-green\">\n");
      out.write("                        <td class=\"w3-panel w3-leftbar w3-border-blue w3-pale-blue\"> Prenume Student: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"prenume\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr class=\"w3-panel w3-border w3-border-red w3-hover-border-green\">\n");
      out.write("                        <td class=\"w3-panel w3-leftbar w3-border-blue w3-pale-blue\"> Grupa Student: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"grupa\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"submit\" name=\"adaugaStudent\" value=\"Adauga\"></td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <form action=\"StudentiController\" method=\"POST\">\n");
      out.write("            <input type=\"submit\" name=\"afiseazaStudenti\" value=\"Afiseaza\"> &nbsp; &nbsp;<br>\n");
      out.write("        </form>\n");
      out.write("        <br>\n");
      out.write("        <a class=\"w3-button w3-border w3-hover-teal w3-button w3-round-xlarge\" href=\"index.html\"><b>Home</b></a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
