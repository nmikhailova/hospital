package manager;

import action.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class ActionManager {

    private static final Map<String, Serv> mapa = new HashMap<String, Serv>();

    static {
        mapa.put("login", (Serv) ClassManager.get(LoginAction.class));
        mapa.put("find", (Serv) ClassManager.get(FindAction.class));
        mapa.put("results", (Serv) ClassManager.get(ResultAction.class));
        mapa.put("appointment", (Serv) ClassManager.get(AppointAction.class));
        mapa.put("addappointment", (Serv) ClassManager.get(AddAppointAction.class));
        mapa.put("kart", (Serv) ClassManager.get(KartAction.class));
        mapa.put("diagnos", (Serv) ClassManager.get(DiagnosAction.class));
        mapa.put("logout", (Serv) ClassManager.get(LogoutAction.class));
        mapa.put("exec", (Serv) ClassManager.get(ExecAppointAction.class));
        mapa.put("updatediagnos", (Serv) ClassManager.get(UpdateDiagnosAction.class));
        mapa.put("enddiagnos", (Serv) ClassManager.get(EndDiagnosAction.class));
        mapa.put("diagnos", (Serv) ClassManager.get(EDiagnosAction.class));
        mapa.put("addpatient", (Serv) ClassManager.get(AddPatientAction.class));
        mapa.put("patients", (Serv) ClassManager.get(PatientAction.class));
        mapa.put("en", (Serv) ClassManager.get(EnAction.class));
        mapa.put("ru", (Serv) ClassManager.get(RuAction.class));
    }

    /**
     * find actions.
     * @param name name action.
     * @return
     */
    public static synchronized Serv findAction(String name) {
        return mapa.get(name);
    }

}
