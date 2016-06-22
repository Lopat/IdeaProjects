package serlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "redir", urlPatterns = {"/redir"})
public class redir extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");

        if (url != null) {
            response.sendRedirect(url + "\n");
        }

//        request.getSession().setAttribute("sessionAt", url);
//
//        ServletContext context = getServletContext();
//        context.setAttribute("contextAt", url);
//
//        request.getRequestDispatcher("FormHandler").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("wrong method");
    }
}
