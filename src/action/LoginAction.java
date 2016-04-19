package action;

import manager.ClassManager;
import manager.Initializable;
import manager.Serv;
import domen.User;
import domen.exception.InternalServerError;
import service.LoginService;
import util.Bundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

/**
 * Action to perform login.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class LoginAction implements Initializable, Serv {

    private LoginService service;

    @Override
    public void init() {
        service = (LoginService) ClassManager.get(LoginService.class);
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        String l = request.getParameter("login");
        String p = request.getParameter("pass");
        User b = service.login(l, p);
        if (b != null) {
            request.getSession().setAttribute("user", b);
            return "/find_men.jsp";
        } else {
            String e = Bundle.findMessage((Locale) request.getSession().getAttribute("loc"), "message.denied");
            try {
                e = URLEncoder.encode(e, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                throw new InternalServerError(ex);
            }
            return "redirect:/hospital/index.jsp?errormessage=" + e;
        }
    }

}
