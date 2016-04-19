package action;

import manager.Initializable;
import manager.Serv;
import domen.Types;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to collect necessary data and move to page.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 15.12.13
 * Time: 17:42
 */
public class AppointAction implements Initializable, Serv {

    @Override
    public void init() {
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("types", Types.values());
        request.setAttribute("id_kart", request.getParameter("id_kart"));
        request.setAttribute("id_person", request.getParameter("id_person"));
        return "/appointment.jsp";
    }

}
