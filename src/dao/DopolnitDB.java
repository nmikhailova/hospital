package dao;

import manager.Initializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 07.12.13
 * Time: 17:31
 */
public class DopolnitDB implements Initializable {

    @Override
    public void init() {
    }

    /**
     * find appointments.
     *
     * @param idKartochki kart id.
     * @return list appointment.
     * @throws SQLException
     */
    public List<Integer> findApps(int idKartochki) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "select id from appointment where kart_id=" + idKartochki + ";";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Integer> list = new LinkedList<>();
        while (resultSet.next()) {
            list.add(resultSet.getInt("id"));
        }
        ConnectionPool.getInstance().freeConnection(con);
        return list;
    }

}
