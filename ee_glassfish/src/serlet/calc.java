package serlet;

import calc.CalcOperations;
import calc.OperationType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;


@WebServlet(name = "Calculator", urlPatterns = {"/Calculator"})
public class calc extends HttpServlet {

    private int counter = 0;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Как настроить counter?
        response.setContentType("text/html; charset = UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);
        Enumeration<String> en = request.getParameterNames();

        request.getSession().setAttribute("counter", counter);

        out.println("<html>\n" +
                "<head>\n" +
                "<title> Test Servlet </title>\n" +
                "<link rel=\"stylesheet\" href=\"css\\global.css\">" +
                "</head>\n" +
                "<body>\n"
        );

        String op = "";

        try {
            double one = Double.parseDouble(request.getParameter("one"));
            double two = Double.parseDouble(request.getParameter("two"));
            String operation = request.getParameter("operation");
            OperationType operType = OperationType.valueOf(operation.toUpperCase());

            op = ("<h1>" + request.getParameter("one") + " " + operType.getStringValue() +
                    " " + request.getParameter("two") + " = " + makeCalculations(operType, one, two) + "</h1>");

            counter++;
        }
        catch (Exception ex) {
            out.println("Wrong inputs");
            out.println("\n");
          //  response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        ArrayList<String> operationList = null;

        try {
            if (session.isNew()) {
                operationList = new ArrayList<>();
            } else {
                Object attribute = session.getAttribute("formulas");

                if (attribute instanceof ArrayList) {
                    operationList = (ArrayList<String>) session.getAttribute("formulas");
                }
            }

            operationList.add(op);
            session.setAttribute("formulas", operationList);

            out.println("<h1> Number of operations (" + request.getSession().getAttribute("counter") + ")</h1>");

            for (String x : operationList) {
                out.println(x);
            }

        }
        catch (Exception ex) {

            out.println("operation list messed up");
            while (en.hasMoreElements()) {
                out.println(en.nextElement());
            }
        }
        finally {
            out.println("<a href = \"CheckSessionAttributes\">Session Attributes</a>" +
                    "</body>\n" +
                    "</html>"
            );
            out.close();
        }
    }

    private double makeCalculations(OperationType oper, double one, double two) {
        double res = 0.0;
        switch (oper) {
            case ADD: {
                res = CalcOperations.add(one, two);
                break;
            }
            case SUBTRACT: {
                res = CalcOperations.subtract(one, two);
                break;
            }
            case MULTIPLY: {
                res = CalcOperations.multiply(one, two);
                break;
            }
            case DIVIDE: {
                res = CalcOperations.divide(one, two);
                break;
            }
        }
        return res;
    }
}
