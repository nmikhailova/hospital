package action;

import manager.ClassManager;
import manager.Initializable;
import manager.Serv;
import domen.User;
import service.DiagnosisService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to collect necessary data and move to page.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class DiagnosAction implements Initializable, Serv {

    private DiagnosisService service;

    @Override
    public void init() {
        service = (DiagnosisService) ClassManager.get(DiagnosisService.class);
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        User doctor = (User) request.getSession().getAttribute("user");
        String d = String.valueOf(request.getParameter("ishodniy"));
        service.addDiagnosis(d, doctor);
        return "/results.jsp";
    }

}
