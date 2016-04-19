package menu;

import manager.ClassManager;
import dao.PersonDB;
import dao.UsersDB;
import domen.User;
import service.LoginService;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 27.11.13
 * Time: 18:17
 */
public class Menu {
    static private LoginService loginService = (LoginService) ClassManager.get(LoginService.class);
    static private PersonDB prodDB = new PersonDB();

    public static void main(String[] args) throws SQLException {

        System.out.println("Welcome in hospital!");

        while (true) {
            System.out.println("1.log in");
            System.out.println("2.registration");
            System.out.println("0.exit");
            System.out.print("vvedite chislo:");

            String b = vvodString();

            if ("0".equals(b)) {
                break;
            } else if ("1".equals(b)) {
                oknologina();
            } else if ("2".equals(b)) {
                oknoregistation();
            } else {
                System.out.println("not found");
            }
        }

        System.out.println("Good bye!");
    }


    private static void oknoregistation() throws SQLException {

        System.out.print("input login:");
        String login = vvodString();
        System.out.print("input pass:");
        String password = vvodString();
        System.out.print("podtverdite pass:");
        String password2 = vvodString();
        if (password.equals(password2)) {
            UsersDB u = new UsersDB();
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);

            System.out.println("To book?");
            System.out.println("ok/cancel");
            String d = vvodString();
            if ("cancel".equals(d)) {
            } else if ("ok".equals(d)) {
                u.create(user);
            } else {
                System.out.println("error");
            }

        } else System.out.println("Passwords are not equal\n");

    }


//    private static void init() throws SQLException {
//        User u = new User();
//        u.setLogin("root");
//        u.setPassword("root");
//        userdb.create(u);
//    }

    private static String vvodString() {
        Scanner vv = new Scanner(System.in);
        return vv.next();
    }

    private static void oknologina() {
        System.out.println("enter login");
        String login = vvodString();
        System.out.println("enter pass");
        String pass = vvodString();
        if (loginService.login(login, pass) != null) {
            System.out.println("access granted");
        } else {
            System.out.println("access denied");
        }
    }

}
