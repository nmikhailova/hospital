package menu.test;

import dao.KartochkaDB;
import domen.Appointment;
import domen.Diagnos;
import domen.Kartochka;
import domen.Person;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 04.12.13
 * Time: 23:34
 */
public class KartochkaRunner {
    public static void main(String[] args) throws SQLException {
        KartochkaDB k = new KartochkaDB();
        Kartochka kartochka = new Kartochka();
        Person person = new Person();
        Diagnos diagnos = new Diagnos();
        Appointment appointment = new Appointment();
        person.setId(5);
        diagnos.setId(3);
        appointment.setId(3);
        kartochka.setPerson(person);
        kartochka.setDiagnos(diagnos);
//        k.create(kartochka);
//         k.delete(3);
        k.findKartochka(4);

    }
}
