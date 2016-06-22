package serlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CheckSessionAttributes", urlPatterns = {"/CheckSessionAttributes"})
public class CheckSessionAttributes extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset = UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>\n" +
                "<head>\n" +
                "<title> Test Servlet </title>\n" +
                "<link rel=\"stylesheet\" href=\"css\\global.css\">" +
                "</head>\n" +
                "<body>\n" +
                "<h1> Session Attributes</h1>"
        );

        HttpSession session = request.getSession(true);
        Object attribute = session.getAttribute("formulas");

        if(attribute instanceof ArrayList) {
           ArrayList list = (ArrayList)attribute;

            for(Object x : list)
                out.println("<p>" + x + "</p> \n");
        } else {
            out.println("Operations not found");
        }

//        Enumeration en = session.getAttributeNames();
//        while(en.hasMoreElements())
//            out.println(en.nextElement() + "\n");
        out.println("</body>\n" +
                "</html>"
        );
    }
}
