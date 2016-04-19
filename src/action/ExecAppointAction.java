package action;

import manager.ClassManager;
import manager.Initializable;
import manager.Serv;
import service.AppointmentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to execute the appointment.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 15.12.13
 * Time: 17:42
 */
public class ExecAppointAction implements Initializable, Serv {

    private AppointmentService service;

    @Override
    public void init() {
        service = (AppointmentService) ClassManager.get(AppointmentService.class);
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        String idapp = request.getParameter("id_app");
        String idPers = request.getParameter("id_person");
        service.execAppointment(idapp);
        return "/work/kart.jsp?id=" + idPers;
    }

}
