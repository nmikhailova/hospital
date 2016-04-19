package service;

import manager.ClassManager;
import manager.Initializable;
import dao.AppointmentDB;
import domen.Appointment;
import domen.Types;
import domen.exception.InternalServerError;
import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 17:15
 */
public class AppointmentService implements Initializable {

    private static Logger logger = Logger.getLogger(AppointmentService.class);
    private AppointmentDB appointmentDB;

    /**
     * add appointment.
     * @param id kart id.
     * @param type
     * @param descr
     * @return
     */
    public Appointment addAppointment(String id, String type, String descr) {
        Appointment appointment = new Appointment();
        appointment.setType(Types.preob(type));
        appointment.setOpisanie(descr);
        appointment.setId_kart(Integer.valueOf(id));

        try {
            appointmentDB.create(appointment);
        } catch (SQLException e) {
            logger.error(e);
            throw new InternalServerError(e);
        }
        return appointment;
    }

    /**
     * execute appointment.                                                  //todo add java docs
     * @param id appointment id.
     */
    public void execAppointment(String id) {
        try {
            appointmentDB.update(id);
        } catch (SQLException e) {
            logger.error(e);
            throw new InternalServerError(e);
        }
    }

    @Override
    public void init() {
        appointmentDB = (AppointmentDB) ClassManager.get(AppointmentDB.class);
    }

}
