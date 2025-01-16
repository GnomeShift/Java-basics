package inputForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "inputForm", value = "/input-form")
public class InputForm extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form action=\"input-form\" method=\"post\">");
        out.println("<label for=\"name\">Name:</label><br>");
        out.println("<input type=\"text\" id=\"name\" name=\"name\"><br>");
        out.println("<label for=\"age\">Age:</label><br>");
        out.println("<input type=\"text\" id=\"age\" name=\"age\"><br>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        int ageInt = Integer.parseInt(age);
        int currentYear = java.time.LocalDate.now().getYear();
        int birthYear = currentYear - ageInt;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet InputForm</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Result</h1>");
        out.println("<p>Имя: " + name + "</p>");
        out.println("<p>Год рождения: " + birthYear + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
