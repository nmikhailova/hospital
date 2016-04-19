package action;

import manager.ClassManager;
import manager.Initializable;
import manager.Serv;
import domen.Person;
import domen.User;
import service.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to add patient.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class AddPatientAction implements Initializable, Serv {

    private PatientService service;

    @Override
    public void init() {
        service = (PatientService) ClassManager.get(PatientService.class);
    }

    /**
     * create new person.
     * @param request  http request.
     * @param response http response.
     * @return redirect.
     */
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        User doctor = (User) request.getSession().getAttribute("user");
        int id_doc = doctor.getId();
        Person person = getPerson(request);
        String firstDiagn = request.getParameter("diagnosa");
        service.addPatient(id_doc, firstDiagn, person);

        return "redirect:/hospital/find_men.jsp";
    }

    private Person getPerson(HttpServletRequest request) {
        Person person = new Person();
        person.setFam(request.getParameter("surname"));
        person.setName(request.getParameter("name"));
        person.setOtch(request.getParameter("patronomyc"));
        person.setAdress(request.getParameter("adress"));
        person.setPhone(Long.valueOf(request.getParameter("phone")));
        person.setDateBorn(Integer.valueOf(request.getParameter("date")));
        return person;
    }

}
