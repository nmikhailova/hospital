package action;

import manager.Initializable;
import manager.Serv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Action to switch language.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 17.12.13
 * Time: 17:42
 */
public class RuAction implements Initializable, Serv {

    @Override
    public void init() {
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("loc", new Locale("ru"));
        return "redirect:/hospital/find_men.jsp";
    }

}
