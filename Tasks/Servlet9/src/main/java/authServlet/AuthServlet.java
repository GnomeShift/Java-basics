package authServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "authServlet", value = "/auth-servlet")
public class AuthServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<form action=\"auth-servlet\" method=\"post\">");
        out.println("<label for=\"login\">Логин</label><br>");
        out.println("<input type=\"text\" id=\"login\" name=\"login\"><br>");
        out.println("<label for=\"password\">Пароль</label><br>");
        out.println("<input type=\"password\" id=\"password\" name=\"password\"><br>");
        out.println("<input type=\"submit\" value=\"Отправить\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    public String validateLogin(String login, String password) {
        if (login == null || login.isEmpty()) {
            login = "";
        }
        if (password == null || password.isEmpty()) {
            password = "";
        }

        if (login.equals("admin") && password.equals("admin")) {
            return "Добро пожаловать, " + login + "!";
        }
        else {
            return "Введенные данные неверны!";
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Auth Servlet</title>");
        out.println("</head><body>");
        out.println("<h1>Результат авторизации</h1>");
        out.println("<p>" + validateLogin(login, password) + "</p>");
        out.println("</body></html>");
    }
}
