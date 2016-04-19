package dao;

import manager.Initializable;
import domen.Diagnos;
import domen.User;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 01.12.13
 * Time: 21:24
 */
public class DiagnosDB implements Initializable {

    private static Logger logger = Logger.getLogger(DiagnosDB.class);

    /**
     * create first diagnosis.
     * @param diagnos diagnosis.
     * @return
     * @throws SQLException
     */
    public int createIsh(Diagnos diagnos) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "insert into diagnoz (ishodniy, id_doctor) values('"
                + diagnos.getIshodniy() + "','" + diagnos.getDoctor().getId() + "');";
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

    /**
     * create last diagnosis.
     * @param diagnos diagnosis.
     * @throws SQLException
     */
    public void createOk(Diagnos diagnos) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "update diagnoz set oconchatelniy='" + diagnos.getOconchatelniy() + "', " +
                "id_doctor2=" + diagnos.getDoctor2().getId() + " where id=" + diagnos.getId() + ";";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute(sql);
        ConnectionPool.getInstance().freeConnection(con);
    }

    /**
     * delete diagnosis.
     * @param id diagnosis id.
     * @throws SQLException
     */
    public void delete(int id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "delete from diagnoz where id=" + id;
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute(sql);
        logger.debug("diagnosis deleted");
        ConnectionPool.getInstance().freeConnection(con);
    }

    /**
     * find diagnosis.
     * @param id diagnisis id.
     * @return diagnosis.
     * @throws SQLException
     */
    public Diagnos findDiagnos(int id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "select * from diagnoz where id=" + id + ";";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        Diagnos d = null;
        if (resultSet.next()) {
            d = new Diagnos();
            d.setId(id);
            d.setIshodniy(resultSet.getString("ishodniy"));
            User u = new User();
            u.setId(resultSet.getInt("id_doctor"));
            d.setDoctor(u);
            if (d.getDoctor2() != null && d.getOconchatelniy() != null) {
                d.setOconchatelniy(resultSet.getString("oconchat"));
                u.setId(resultSet.getInt("id_doctor2"));
                d.setDoctor2(u);
            }
        }
        ConnectionPool.getInstance().freeConnection(con);
        return d;
    }

    /**
     * update diagnosis.
     * @param diagnos diagnosis.
     * @throws SQLException
     */
    public void update(Diagnos diagnos) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "update diagnoz set ishodniy=\"" + diagnos.getIshodniy().trim() + "\"," +
                "id_doctor=" + diagnos.getDoctor().getId() + " where id=" + diagnos.getId() + ";";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute(sql);
        logger.debug("first diagnosis added");
        ConnectionPool.getInstance().freeConnection(con);
    }

    @Override
    public void init() {
    }

}
