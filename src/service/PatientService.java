package service;

import manager.ClassManager;
import manager.Initializable;
import dao.DiagnosDB;
import dao.KartochkaDB;
import dao.PersonDB;
import domen.Diagnos;
import domen.Kartochka;
import domen.Person;
import domen.User;
import domen.exception.InternalServerError;
import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class PatientService implements Initializable {

    private static Logger logger = Logger.getLogger(PatientService.class);

    private PersonDB personDB;      //инжектирован user db
    private DiagnosDB diagnosDB;      //инжектирован user db
    private KartochkaDB kartochkaDB;      //инжектирован user db

    /**
     * add patient.
     * @param doctor doctor.
     * @param ishpdniy first diagnosis.
     * @param person person.
     */
    public void addPatient(int doctor, String ishpdniy, Person person) {
        User user = new User();
        Diagnos d = new Diagnos();
        Kartochka k = new Kartochka();
        user.setId(doctor);
        d.setDoctor(user);
        d.setIshodniy(ishpdniy);
        k.setPerson(person);
        k.setDiagnos(d);
        try {
            int idPers = personDB.create(person);
            int idD = diagnosDB.createIsh(d);
            d.setId(idD);
            person.setId(idPers);
            k.setPerson(person);
            k.setDiagnos(d);
            kartochkaDB.create(k);
        } catch (SQLException e) {
            logger.error(e);
            throw new InternalServerError(e);
        }
    }

    @Override
    public void init() {
        personDB = (PersonDB) ClassManager.get(PersonDB.class);
        diagnosDB = (DiagnosDB) ClassManager.get(DiagnosDB.class);
        kartochkaDB = (KartochkaDB) ClassManager.get(KartochkaDB.class);
    }

}
