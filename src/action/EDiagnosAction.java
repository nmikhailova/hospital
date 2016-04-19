package action;

import manager.Initializable;
import manager.Serv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to collect necessary data and move to page.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class EDiagnosAction implements Initializable, Serv {

    @Override
    public void init() {

    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("id_diagn", request.getParameter("id_diagn"));
        request.setAttribute("id_person", request.getParameter("id_person"));
        return "/enddiagnos.jsp";
    }

}
