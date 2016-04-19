package service;

import dao.PersonDB;
import domen.Person;
import domen.exception.InternalServerError;
import manager.ClassManager;
import manager.Initializable;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class FindService implements Initializable {

    private static Logger logger = Logger.getLogger(FindService.class);
    private PersonDB personDB;

    /**
     * find persons.
     *
     * @param fam  surname.
     * @param im   name.
     * @param otch patronymic.
     * @return list of persons.
     */
    public List<Person> findPersonByName(String fam, String im, String otch) {
        String familiya = convert(fam);
        String name = convert(im);
        String otchestvo = convert(otch);
        if (familiya == null)
            familiya = "%";
        if (name == null)
            name = "%";
        if (otchestvo == null)
            otchestvo = "%";
        try {
            return personDB.findPerson(familiya, name, otchestvo);
        } catch (SQLException e) {
            logger.warn(e);
            throw new InternalServerError(e);
        }
    }

    /**
     * convertor to replace empty string to *.
     *
     * @param s field to find.
     * @return converted field.
     */
    public String convert(String s) {
        if (s == null || s.isEmpty()) {
            return ".*";
        }
        return s;
    }

    /**
     * find person by id.
     *
     * @param id person id.
     * @return person.
     */
    public Person findPersonById(int id) {
        try {
            return personDB.find(id);
        } catch (SQLException e) {
            logger.error(e);
            throw new InternalServerError(e);
        }
    }

    @Override
    public void init() {
        personDB = (PersonDB) ClassManager.get(PersonDB.class);
    }

}
