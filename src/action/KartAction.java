package action;

import manager.ClassManager;
import manager.Initializable;
import manager.Serv;
import domen.Diagnos;
import domen.Kartochka;
import domen.Person;
import service.DiagnosisService;
import service.FindService;
import service.KartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to find the kart.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class KartAction implements Initializable, Serv {

    private FindService findService;
    private DiagnosisService diagnosisService;
    private KartService kartService;

    @Override
    public void init() {
        findService = (FindService) ClassManager.get(FindService.class);
        diagnosisService = (DiagnosisService) ClassManager.get(DiagnosisService.class);
        kartService = (KartService) ClassManager.get(KartService.class);
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.valueOf(request.getParameter("id"));
        Person p = findService.findPersonById(id);
        Kartochka k = kartService.findKart(id);
        int d = k.getDiagnos().getId();
        Diagnos diagnos = diagnosisService.diagSel(d);
        request.setAttribute("per", p);
        request.setAttribute("kart", k);
        request.setAttribute("diagn", diagnos);
        return "/kart.jsp";
    }

}
