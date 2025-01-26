package jsonProcessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.fasterxml.jackson.core.JsonProcessingException;

class User {
    public String name;
    public int age;

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

@WebServlet(name = "jsonProcessor", value = "/json-processor")
public class JsonProcessor extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            ObjectMapper mapper = new ObjectMapper();
            User data = mapper.readValue(request.getReader(), User.class);

            String message = "Привет, " + data.name + ", твой возраст " + data.age;

            try {
                out.print(mapper.writeValueAsString(message));
            }
            catch (JsonProcessingException e) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                out.print("{\"error\":\"Ошибка при создании ответа\"}");
            }
        }
        catch (com.fasterxml.jackson.databind.exc.MismatchedInputException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\":\"Некорректный JSON\"}");

        }
        catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"error\":\"Ошибка при чтении запроса\"}");
        }
        finally {
            out.flush();
        }
    }
}