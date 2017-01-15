package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowParameterServlet extends HttpServlet {
    public static final String PARAMETER_SESSION = "parameterSession";
    public static final String PARAMETER_CONTEXT = "parameterContext";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param1 = request.getParameter("parameter1");
        String param2 = request.getParameter("parameter2");

        String param3 = request.getParameter("text");
        String param4 = request.getParameter("select");
        String param5 = request.getParameter("check");

        HttpSession session = request.getSession(true); // получить http сессию
        // значение сессии уникально для каждого сеанса
        session.setAttribute(PARAMETER_SESSION, param1); // положить в сессию
        // значение в контексте общее для всех
        getServletContext().setAttribute(PARAMETER_CONTEXT, param1); // положить в аттрибут

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Title</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>param1 = " + param1 + "</h1>");
            out.println("<h2>param2 = " + param2 + "</h2>");
            out.println("<h3>param3 = " + param3 + "</h3>");
            out.println("<h4>param4 = " + param4 + "</h4>");
            out.println("<h5>param5 = " + param5 + "</h5>");
            out.println("<a href='GetInfo'>Show parameter</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
