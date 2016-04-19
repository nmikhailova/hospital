package action;

import manager.Initializable;
import manager.Serv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to show patients found.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 14.12.13
 * Time: 22:00
 */
public class ResultAction implements Initializable, Serv {

    @Override
    public void init() {
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        return "/kart.jsp";
    }

}

