package manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface to describe action classes.
 * Created with IntelliJ IDEA.
 * User: Настя
 * Date: 10.12.13
 */
public interface Serv {

    /**
     * Exec action.
     *
     * @param request  http request.
     * @param response http response.
     * @return path to page.
     */
    String service(HttpServletRequest request, HttpServletResponse response);

}
