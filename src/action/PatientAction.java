package action;

import manager.Initializable;
import manager.Serv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to move to page.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class PatientAction implements Initializable, Serv {

    @Override
    public void init() {
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        return "/addpatients.jsp";
    }

}
