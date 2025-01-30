package fileUploader;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.UUID;

@WebServlet(name = "fileUploader", value = "/file-uploader")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 3,
        maxRequestSize = 1024 * 1024 * 10)
public class FileUploader extends HttpServlet {

    private static String UPLOAD_DIRECTORY;

    public void init() throws ServletException {
        String deployPath = getServletContext().getRealPath("");
        UPLOAD_DIRECTORY = deployPath + "uploads";
        File uploadDir = new File(UPLOAD_DIRECTORY);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet FileUploader</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"file-uploader\" method=\"post\" enctype=\"multipart/form-data\">");
        out.println("<label for =\"file\">Выберите файл:</label><br>");
        out.println("<input type=\"file\" id=\"file\" name=\"file\"><br>");
        out.println("<input type=\"submit\" value=\"Отправить\">");
        out.println("</form></body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Part filePart = request.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String fileExt = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = UUID.randomUUID() + fileExt;

            filePart.write(UPLOAD_DIRECTORY + File.separator + newFileName);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FileUploader</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Файл успешно загружен!</h2>");
            out.println("<p>Имя файла: " + fileName + "</p>");
            out.println("<p>Сохранен в: " + UPLOAD_DIRECTORY + "\\" + newFileName + "</p>");
            out.println("<a href=\"" + request.getContextPath() + "/\">Назад</a>");
            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception e) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FileUploader</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Ошибка загрузки файла</h2>");
            out.println("<p>Ошибка: " + e.getMessage() + "</p>");
            out.println("<a href=\"" + request.getContextPath() + "/\">Назад</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
