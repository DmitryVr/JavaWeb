package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetInfo extends HttpServlet {
    public static final String PARAMETER_SESSION = "parameterSession";
    public static final String PARAMETER_CONTEXT = "parameterContext";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        // получить параметры из сессии и из контекста
        // т.к. данные там Object, то преобразует к нужному типу
        String p1 = (String) req.getSession(true).getAttribute(PARAMETER_SESSION);
        String p2 = (String) getServletContext().getAttribute(PARAMETER_CONTEXT);

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Title</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Session parameter = " + p1 + "</h1>");
            out.println("<h2>Servlet context parameter = " + p2 + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
