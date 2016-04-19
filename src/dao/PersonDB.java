package dao;


import domen.Person;
import manager.Initializable;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 23.11.13
 * Time: 17:11
 */
public class PersonDB implements Initializable {

    /**
     * create new person.
     * @param person person.
     * @return
     * @throws SQLException
     */
    public int create(Person person) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "insert into person (familiya,imya,otchestvo,adress,phone,dateBorn) values('"
                + person.getFam() + "','" + person.getName() + "','" + person.getOtch() + "','"
                + person.getAdress() + "','" + person.getPhone() + "','" + person.getDateBorn() + "');";
        PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        ConnectionPool.getInstance().freeConnection(con);
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            return 0;
        }
    }

    public void delete(int person_id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "delete from person where id=" + person_id;
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute(sql);
        ConnectionPool.getInstance().freeConnection(con);
    }

    /**
     * find persons.
     * @param familiya surname.
     * @param name name.
     * @param otchestvo patronomic.
     * @return list of person.
     * @throws SQLException
     */
    public List<Person> findPerson(String familiya, String name, String otchestvo) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "select * from person where familiya regexp'" + familiya + "' and imya regexp'" + name +
                "' and otchestvo regexp'" + otchestvo + "';";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Person> list = new LinkedList<>();
        while (resultSet.next()) {
            Person p = new Person();
            p.setId(resultSet.getInt("id"));
            p.setFam(resultSet.getString("familiya"));
            p.setName(resultSet.getString("imya"));
            p.setOtch(resultSet.getString("otchestvo"));
            p.setDateBorn(resultSet.getInt("dateBorn"));
            p.setAdress(resultSet.getString("adress"));
            p.setPhone(resultSet.getLong("phone"));
            list.add(p);
        }
        ConnectionPool.getInstance().freeConnection(con);
        return list;
    }

    /**
     * find person by id.
     * @param id person id.
     * @return person.
     * @throws SQLException
     */
    public Person find(int id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "select * from person where id=" + id + ";";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        Person p = null;
        if (resultSet.next()) {
            p = new Person();
            p.setId(resultSet.getInt("id"));
            p.setFam(resultSet.getString("familiya"));
            p.setName(resultSet.getString("imya"));
            p.setOtch(resultSet.getString("otchestvo"));
            p.setDateBorn(resultSet.getInt("dateBorn"));
            p.setAdress(resultSet.getString("adress"));
            p.setPhone(resultSet.getLong("phone"));
        }
        ConnectionPool.getInstance().freeConnection(con);
        return p;
    }

    @Override
    public void init() {
    }

}
