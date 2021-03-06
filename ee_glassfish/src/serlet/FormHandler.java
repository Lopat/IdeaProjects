package serlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "FormHandler", urlPatterns = {"/FormHandler"})
public class FormHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String inputOne = request.getParameter("textInput");
        String[] options = request.getParameterValues("options");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println(
                "<html>\n" +
                "<head>\n" +
                "<title> Form Handler </title>\n" +
                "</head>\n" +
                "<body>\n" +
                "Your text : " +
                inputOne +
                "<br>"
        );

        if(options != null){
            out.println("Options are:<br>");
            for(String option : options){
                out.println(option);
                out.println("<br>");
            }
        }

        out.print(
                "</body>\n" +
                "</html>"
        );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("wrong method");
    }
}
