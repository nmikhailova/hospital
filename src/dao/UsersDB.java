package dao;

import manager.Initializable;
import domen.Person;
import domen.Role;
import domen.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 23.11.13
 * Time: 17:04
 */
public class UsersDB implements Initializable {

    /**
     * create user.
     * @param user user
     * @throws SQLException
     */
    public void create(User user) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "insert into users (login,pass) values('"
                + user.getLogin() + "','" + user.getPassword() + "');";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute(sql);
        ConnectionPool.getInstance().freeConnection(con);
    }

    /**
     * delete user.
     * @param id user id.
     * @throws SQLException
     */
    public void delete(int id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();

        String sql = "delete from users where id=" + id;
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute(sql);
        ConnectionPool.getInstance().freeConnection(con);
    }

    /**
     * find user by id.
     * @param login login.
     * @return user.
     * @throws SQLException
     */
    public User findByLogin(String login) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "select * from users where login=?;";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        User u = null;
        if (resultSet.next()) {
            u = new User();
            u.setLogin(resultSet.getString("login"));
            u.setPassword(resultSet.getString("pass"));
            u.setId(resultSet.getInt("id"));
            u.setR(Role.values()[resultSet.getInt("rol")]);
            Person p = new Person();
            p.setId(resultSet.getInt("person_id"));
            u.setPerson(p);
        }
        ConnectionPool.getInstance().freeConnection(con);
        return u;
    }

    @Override
    public void init() {
    }

}
