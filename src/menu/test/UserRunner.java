package menu.test;

import dao.UsersDB;
import domen.User;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 04.12.13
 * Time: 23:35
 */
public class UserRunner {
    public static void main(String[] args) throws SQLException {
        UsersDB u = new UsersDB();
        User user = new User();
        user.setLogin("olololo");
        user.setPassword("hhkhjkhkhkh8786n");
//        u.create(user);
//        u.delete(3);
        u.findByLogin("doctor");
    }
}
