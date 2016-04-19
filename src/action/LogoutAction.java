package action;

import manager.Initializable;
import manager.Serv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to logout.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 15.12.13
 * Time: 17:42
 */
public class LogoutAction implements Initializable, Serv {

    @Override
    public void init() {
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return "redirect:/hospital/index.jsp";
    }

}
