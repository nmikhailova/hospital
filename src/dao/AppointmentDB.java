package dao;


import domen.Appointment;
import domen.Types;
import manager.Initializable;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 02.12.13
 * Time: 16:57
 */
public class AppointmentDB implements Initializable {

    private static Logger logger = Logger.getLogger(AppointmentDB.class);

    /**
     * create appointment.
     * @param appointment appointment.
     * @throws SQLException
     */
    public void create(Appointment appointment) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "insert into appointment (kart_id,status, type, opisanie) values('" + appointment.getId_kart() + "','"
                + "0" + "','" + appointment.getType() + "','" + appointment.getOpisanie() + "');";
//       StringBuilder sb = new StringBuilder("insert into appointment (kart_id,status, type, opisanie) values('")
//               .append(appointment.getId_kart()).append("','").append("0").append("','")
//               .append(appointment.getType()).append("','").append(appointment.getOpisanie()).append("');");
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute(sql);
        logger.debug("appointment added");
        ConnectionPool.getInstance().freeConnection(con);
    }

    /**
     * deleted appointment.
     * @param id id appointment.
     * @throws SQLException
     */
    public void delete(int id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "delete from appointment where id=" + id + ";";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute(sql);
        logger.debug("appointment deleted");
        ConnectionPool.getInstance().freeConnection(con);
    }

    /**
     * find appointment.
     * @param id id appointment.
     * @return appointment.
     * @throws SQLException
     */
    public Appointment select(int id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "select * from appointment where id=" + id + ";";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        Appointment ap = null;
        if (resultSet.next()) {
            ap = new Appointment();
            String type = resultSet.getString("type");
            Types t = Types.valueOf(type);
            ap.setType(t);
            ap.setId(id);
            ap.setOpisanie(resultSet.getString("opisanie"));
            ap.setStatus(resultSet.getBoolean("status"));
        }
        ConnectionPool.getInstance().freeConnection(con);
        return ap;
    }

    /**
     * update status of appointment.
     * @param id id appointment.
     * @throws SQLException
     */
    public void update(String id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "update appointment set status = 1 where id=" + id + ";";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute(sql);
        logger.debug("appointment execute");
        ConnectionPool.getInstance().freeConnection(con);
    }

    @Override
    public void init() {
    }

}
