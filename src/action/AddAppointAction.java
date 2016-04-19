package action;

import manager.ClassManager;
import manager.Initializable;
import manager.Serv;
import service.AppointmentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to add appointment.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 15.12.13
 * Time: 17:42
 */
public class AddAppointAction implements Initializable, Serv {

    private AppointmentService service;

    @Override
    public void init() {
        service = (AppointmentService) ClassManager.get(AppointmentService.class);
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        String description = String.valueOf(request.getParameter("description"));
        String type = request.getParameter("apptype");
        String id = request.getParameter("id_kart");
        service.addAppointment(id, type, description);
        String idPers = request.getParameter("id_pers");
        return "/work/kart.jsp?id=" + idPers;
    }

}
