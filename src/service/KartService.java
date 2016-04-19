package service;

import manager.ClassManager;
import manager.Initializable;
import dao.AppointmentDB;
import dao.DopolnitDB;
import dao.KartochkaDB;
import domen.Appointment;
import domen.Kartochka;
import domen.exception.InternalServerError;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 28.11.13
 * Time: 20:29
 */
public class KartService implements Initializable {

    private static Logger logger = Logger.getLogger(KartService.class);

    private KartochkaDB kartochkaDB;
    private AppointmentDB appointmentDB;
    private DopolnitDB dopolnitDB;

    @Override
    public void init() {
        kartochkaDB = (KartochkaDB) ClassManager.get(KartochkaDB.class);
        appointmentDB = (AppointmentDB) ClassManager.get(AppointmentDB.class);
        dopolnitDB = (DopolnitDB) ClassManager.get(DopolnitDB.class);
    }

    /**
     * find kart by id person.
     * @param personId id person.
     * @return kert.
     */
    public Kartochka findKart(int personId) {
        try {
            Kartochka ku = kartochkaDB.findKartochka(personId);
            int id = ku.getId();
            List<Integer> appsIds = dopolnitDB.findApps(id);
            List<Appointment> appointments = new LinkedList<>();
            for (Integer i : appsIds) {
                appointments.add(appointmentDB.select(i));
            }
            ku.setAppointments(appointments);
            return ku;
        } catch (SQLException e) {
            logger.error(e);
            throw new InternalServerError(e);
        }
    }

}
