package filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 11.12.13
 * Time: 20:29
 */
public class LocaleFilter implements Filter {

    private static final String UTF8 = "UTF-8";
    private static Logger logger = Logger.getLogger(LocaleFilter.class);

    @Override
    public void init(FilterConfig config) throws ServletException {
        logger.debug("filter not work");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        response.setCharacterEncoding(UTF8);
        request.setCharacterEncoding(UTF8);
        Locale locale = (Locale) req.getSession().getAttribute("loc");
        if (locale == null) {
            locale = new Locale("ru");
            req.getSession().setAttribute("loc", locale);
        }
        next.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
