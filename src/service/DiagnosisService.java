package service;

import manager.ClassManager;
import manager.Initializable;
import dao.DiagnosDB;
import dao.KartochkaDB;
import domen.Diagnos;
import domen.User;
import domen.exception.InternalServerError;
import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 11.12.13
 * Time: 19:06
 */
public class DiagnosisService implements Initializable {

    private static Logger logger = Logger.getLogger(DiagnosisService.class);
    private DiagnosDB diagnosDB;
    private KartochkaDB kartochkaDB;

    /**
     * add diagnosis.
     * @param d first diagnosis.
     * @param doctor doctor.
     */
    public void addDiagnosis(String d, User doctor) {
        Diagnos diagnos = new Diagnos();
        diagnos.setIshodniy(d);
        diagnos.setDoctor(doctor);
        try {
            diagnosDB.createIsh(diagnos);
        } catch (SQLException e) {
            logger.error(e);
            throw new InternalServerError(e);
        }
    }

    /**
     * add the end diagnosis.
     * @param id diagnosis.
     * @param d last diagnosis.
     * @param doctor doctor.
     * @param idPers id person.
     */
    public void addEndDiagnosis(String id, String d, User doctor, String idPers) {
        Diagnos diagnos = new Diagnos();
        diagnos.setId(Integer.valueOf(id));
        diagnos.setOconchatelniy(d);
        diagnos.setDoctor2(doctor);
        int id_p = Integer.valueOf(idPers);
        try {
            diagnosDB.createOk(diagnos);
            kartochkaDB.vyp(id_p);
        } catch (SQLException e) {
            logger.error(e);
            throw new InternalServerError(e);
        }
    }

    /**
     * find diagnosis.
     * @param id diagnosis.
     * @return first diagnosis.
     */
    public Diagnos diagSel(int id) {
        try {
            return diagnosDB.findDiagnos(id);
        } catch (SQLException e) {
            logger.error(e);
            throw new InternalServerError(e);
        }
    }

    /**
     * update diagnosis.
     * @param id diagnosis.
     * @param d new first diagnosis.
     * @param doctor doctor.
     */
    public void updateDiagnosis(String id, String d, User doctor) {
        Diagnos diagnos = new Diagnos();
        diagnos.setId(Integer.valueOf(id));
        diagnos.setIshodniy(d);
        diagnos.setDoctor(doctor);
        try {
            diagnosDB.update(diagnos);
        } catch (SQLException e) {
            logger.error(e);
            throw new InternalServerError(e);
        }
    }

    @Override
    public void init() {
        diagnosDB = (DiagnosDB) ClassManager.get(DiagnosDB.class);
        kartochkaDB = (KartochkaDB) ClassManager.get(KartochkaDB.class);
    }

}
