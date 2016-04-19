package filter;

import org.apache.log4j.Logger;
import util.Bundle;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 17.12.13
 * Time: 21:31
 */
public class SecurityFilter implements Filter {

    private List<String> shared = Arrays.asList("index", "login.do", "ru.do", "en.do", ".css", ".jpg", ".gif");
    private static Logger logger = Logger.getLogger(SecurityFilter.class);

    @Override
    public void init(final FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, javax.servlet.ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        boolean b = false;
        String lurl = url.toLowerCase();
        for (String s : shared) {
            b = b || lurl.contains(s);
        }
        if (b || httpServletRequest.getSession().getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            String e = Bundle.findMessage((Locale) httpServletRequest.getSession().getAttribute("loc"), "message.denied");
            e = URLEncoder.encode(e, "UTF-8");
            String path = "/hospital/index.jsp?errormessage=" + e;
            ((HttpServletResponse) response).sendRedirect(path);
        }
    }

    @Override
    public void destroy() {
    }

}
