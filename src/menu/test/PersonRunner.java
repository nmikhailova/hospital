package menu.test;

import dao.PersonDB;
import domen.Person;
import service.FindService;

import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 04.12.13
 * Time: 23:34
 */
public class PersonRunner {
    public static void main(String[] args) throws SQLException {
        PersonDB p = new PersonDB();
        Person person = new Person();
        person.setId(10);
        person.setFam("Pulkov");
        person.setName("Vitaliy");
        person.setOtch("Igprevich");
        person.setPhone(648999);
        person.setAdress("jhkhkhkhkhkhsdf jdfkh");
        Calendar c = Calendar.getInstance();
        c.set(1995, 4, 30);
//        person.setDateBorn(c.getTime());
//        p.create(person);
//        p.delete(5);
        p.findPerson("ivanov", "ivan", "ivanovich");
        FindService findService = new FindService();
        Object o = findService.findPersonByName(null, "", "vano");
        System.out.println(o);
    }
}
