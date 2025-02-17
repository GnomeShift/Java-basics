package requestLogger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(value = "/*")
public class RequestLogger implements Filter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String timestamp = LocalDateTime.now().format(FORMATTER);
        String clientIp = request.getRemoteAddr();
        String requestURI = request.getRequestURI();
        String query = request.getQueryString();

        System.out.println("[" + timestamp + "] Request from: " + clientIp + ", URI: " + requestURI + ": " + (query != null ? "?" + query : ""));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
