package action;

import manager.ClassManager;
import manager.Initializable;
import manager.Serv;
import domen.Person;
import service.FindService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Action to find person.
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class FindAction implements Initializable, Serv {

    private FindService service;

    @Override
    public void init() {
        service = (FindService) ClassManager.get(FindService.class);
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        String fam = request.getParameter("surname");
        String name = request.getParameter("name");
        String otch = request.getParameter("patronomyc");
        List<Person> lp = service.findPersonByName(fam, name, otch);
        request.setAttribute("SNP", lp);
        return "/results.jsp";

    }

}
