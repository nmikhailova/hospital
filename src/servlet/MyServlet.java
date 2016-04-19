package servlet;

import manager.ActionManager;
import manager.Serv;
import org.apache.log4j.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 01.12.13
 * Time: 16:52
 */
public class MyServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(MyServlet.class);

    private static final String REDIRECT = "redirect:";

    private ServletConfig servletConfig;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String actionName = getActionName(request);
        Serv action = ActionManager.findAction(actionName);
        String path;
        try {
            path = action.service(request, response);
        } catch (Exception e) {
            path = "redirect:/hospital/error.html";
        }
        if (path.startsWith(REDIRECT)) {
            response.sendRedirect(path.substring(REDIRECT.length()));
        } else {
            ServletContext sc = servletConfig.getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(path);
            rd.forward(request, response);
        }
    }

    private String getActionName(HttpServletRequest request) {
        String path = request.getRequestURI();
        int slash = path.lastIndexOf("/");
        int period = path.lastIndexOf(".");
        if (period > 0 && period > slash) {
            path = path.substring(slash + 1, period);

        }
        return path;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        try {
            Logger root = Logger.getRootLogger();
            HTMLLayout fileLayout = new HTMLLayout();
            Appender fileAppender = new FileAppender(fileLayout, "my.html", false);
            root.removeAllAppenders();
            root.addAppender(fileAppender);
            root.setLevel(Level.ALL);
        } catch (IOException e) {
            throw new ServletException("error");
        }
        logger.info("Application has been started.");
    }

}
