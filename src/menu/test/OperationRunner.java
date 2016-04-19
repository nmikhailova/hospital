package menu.test;

import dao.AppointmentDB;
import domen.Appointment;
import domen.Types;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 03.12.13
 * Time: 20:37
 */
public class OperationRunner {
    public static void main(String[] args) throws SQLException {
        AppointmentDB o = new AppointmentDB();
        Appointment appointment = new Appointment();
        appointment.setType(Types.operations);
        appointment.setStatus(true);
//        o.create(appointment);
//        o.delete(6);
    }
}
