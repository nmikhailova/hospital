package service;

import manager.ClassManager;
import manager.Initializable;
import dao.UsersDB;
import domen.User;
import domen.exception.InternalServerError;
import org.apache.log4j.Logger;
import util.Md5;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 28.11.13
 * Time: 20:29
 */
public class LoginService implements Initializable {

    private static Logger logger = Logger.getLogger(LoginService.class);

    private UsersDB userdb;

    @Override
    public void init() {
        userdb = (UsersDB) ClassManager.get(UsersDB.class);
    }

    /**
     * login in.
     * @param l login.
     * @param p pass.
     * @return user.
     */
    public User login(String l, String p) {
        try {
            User user = userdb.findByLogin(l);
            if (user == null)
                return null;
            if (user.getPassword().equalsIgnoreCase(Md5.md5(p)))
                return user;
            else logger.warn("pass not equals");
            return null;
        } catch (SQLException e) {
            logger.error(e);
            throw new InternalServerError(e);
        }
    }

}
