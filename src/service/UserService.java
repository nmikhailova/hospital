package service;

import manager.Initializable;
import domen.Person;
import domen.User;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 16:30
 */
public class UserService implements Initializable {

    @Override
    public void init() {
    }

    public void AddUser(String login, String pass, String passSecond, String fam, String name, String otch, String adress, Long phone) {
        User user = new User();
        Person person = new Person();
        if (pass.equals(passSecond)) {
            user.setLogin(login);
            user.setPassword(pass);
            person.setFam(fam);
            person.setName(name);
            person.setOtch(otch);
            person.setAdress(adress);
            person.setPhone(phone);
        }
    }

}
