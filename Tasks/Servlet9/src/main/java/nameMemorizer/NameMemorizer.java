package nameMemorizer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "nameMemorizer", value = "/name-memorizer")
public class NameMemorizer extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<form action=\"name-memorizer\" method=\"post\">");
        out.println("<label for=\"name\">Имя:</label><br>");
        out.println("<input type=\"text\" id=\"name\" name=\"name\"><br>");
        out.println("<input type=\"submit\" value=\"Отправить\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        if (name == null || name.isEmpty()) {
            name = "Гость";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<title>Servlet NameMemorizer</title>");
        out.println("</head><body>");
        out.println("<h1>Результат</h1>");
        out.println("<p>Привет, " + name + "</p>");
        out.println("</body></html>");
    }
}
