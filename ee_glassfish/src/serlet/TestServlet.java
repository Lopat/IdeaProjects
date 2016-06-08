package serlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    private int counter;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        String one = config.getInitParameter("initOne");
        System.out.println(one);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset = UTF-8");
        PrintWriter out = response.getWriter();

        Enumeration en = request.getParameterNames();

        counter++;

        request.getSession().setAttribute("counter", counter);

        try {
            out.println("<html>\n" +
                    "<head>\n" +
                    "<title> Test Servlet </title>\n" +
                    "<link rel=\"stylesheet\" href=\"css\\global.css\">" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1> INSIDE SERVLET BODY </h1>\n");
            while (en.hasMoreElements()) {
                String param = en.nextElement().toString();
                System.out.println(param);
                out.println("<h1>PARAMETER " + param + " = " + request.getParameter(param) + "</h1>");
            }
            out.println(    "<p>Counter = " + request.getSession().getAttribute("counter") + "</p>\n" +
                            "<img src = 'images/cup.jpg'/; class = 'pic'>\n" +
                            "</body>\n" +
                            "</html>");
        }
        finally {
            out.close();
        }
    }
}
