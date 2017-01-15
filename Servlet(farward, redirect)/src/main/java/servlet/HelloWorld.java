package servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// request.getParameter(имя-параметра) выдает строку - 
// значение параметра с заданным именем, переданного от клиента серверу в запросе.
// request.getAttribute(имя-атрибута) выдает Java-объект, 
// сохраненный сервером под заданным именем, или null если атрибут с таким именем не существует. 
public class HelloWorld extends HttpServlet {
    private static final Logger log = Logger.getLogger(HelloWorld.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        log.warn("!!!!!!!!!!!!!!!!!!!!");

        if (request.getParameter("redirect") != null) {
            // не сохраняет параметр, показывает в урл страницу на которую переходит
            response.sendRedirect("second");
        } else {
            // сохраняет параметр показывает в урл эту страницу
            getServletContext().getRequestDispatcher("/second").forward(request, response);
        }
    }
}
