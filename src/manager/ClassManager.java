package manager;

import action.*;
import dao.*;
import service.*;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class ClassManager {

    private static Map<Class, Initializable> mapa = new HashMap<Class, Initializable>();

    static {
        //DAO first
        create(UsersDB.class);
        create(PersonDB.class);
        create(AppointmentDB.class);
        create(KartochkaDB.class);
        create(DiagnosDB.class);
        create(DopolnitDB.class);

        //then services
        create(UserService.class);
        create(AppointmentService.class);
        create(LoginService.class);
        create(FindService.class);
        create(DiagnosisService.class);
        create(KartService.class);
        create(PatientService.class);

        //then actions
        create(LoginAction.class);
        create(FindAction.class);
        create(ResultAction.class);
        create(AppointAction.class);
        create(KartAction.class);
        create(DiagnosAction.class);
        create(LogoutAction.class);
        create(AddAppointAction.class);
        create(ExecAppointAction.class);
        create(UpdateDiagnosAction.class);
        create(EndDiagnosAction.class);
        create(EDiagnosAction.class);
        create(AddPatientAction.class);
        create(PatientAction.class);
        create(RuAction.class);
        create(EnAction.class);
    }

    private static void create(Class<? extends Initializable> clazz) {
        try {
            Initializable i = clazz.newInstance();
            i.init();
            mapa.put(clazz, i);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * get class.
     * @param clazz class.
     * @return class.
     */
    public static synchronized Initializable get(Class<? extends Initializable> clazz) {
        if (mapa.containsKey(clazz)) {
            return mapa.get(clazz);
        } else {
            throw new RuntimeException("There is no such class " + clazz.getName());
        }
    }

}
