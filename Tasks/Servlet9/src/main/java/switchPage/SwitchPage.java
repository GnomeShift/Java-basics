package switchPage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "switchPage", value = "switch-page")
public class SwitchPage extends HttpServlet {
    private static final int ITEMS_ON_PAGE = 5;
    private List<String> items;

    @Override
    public void init() {
        items = new ArrayList<>();

        for (int i = 1; i <= 25; i++) {
            items.add("Элемент " + i);
        }
    }

    private static int getStartIndex(String numPages) {
        int page = 1;

        try {
            if (numPages != null) {
                page = Integer.parseInt(numPages);

                if (page <= 0) {
                    page = 1;
                }
            }
        }
        catch (NumberFormatException e) {
            page = 1;
        }

        int startIndex = (page - 1) * ITEMS_ON_PAGE;
        return startIndex;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageParam = request.getParameter("page");

        int startIndex = getStartIndex(pageParam);
        int endIndex = Math.min(startIndex + ITEMS_ON_PAGE, items.size());

        List<String> itemsOnPage = items.subList(startIndex, endIndex);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<title>Switch Page</title>");
        out.println("</head><body>");
        out.println("<h1>Элементы</h1>");
        out.println("<ul>");

        for (String item : itemsOnPage) {
            out.println("<li>" + item + "</li>");
        }

        out.println("</ul>");
        out.println("<h2>Навигация</h2>");

        int pageCount = items.size() / ITEMS_ON_PAGE;

        for (int i = 1; i <= pageCount; i++) {
            out.println("<a href=\"switch-page?page=" + i + "\">" + i + "</a> ");
        }

        out.println("</body></html>");
    }
}
