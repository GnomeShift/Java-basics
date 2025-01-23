package visitCounter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "visitCounter", value = "/visit-counter")
public class VisitCounter extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Integer visitCounter = (Integer) context.getAttribute("visitCounter");

        if (visitCounter == null) {
            visitCounter = 0;
        }

        visitCounter++;
        context.setAttribute("visitCounter", visitCounter);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet VisitCounter</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Посещений страницы: " + visitCounter + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
