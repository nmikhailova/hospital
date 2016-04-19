package dao;

import manager.Initializable;
import domen.Diagnos;
import domen.Kartochka;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 02.12.13
 * Time: 16:57
 */
public class KartochkaDB implements Initializable {

    private static Logger logger = Logger.getLogger(DiagnosDB.class);

    /**
     * create new kart.
     * @param kartochka kart.
     * @return kart id.
     * @throws SQLException
     */
    public int create(Kartochka kartochka) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "insert into kartochka (person_id,diagnoz_id) values("
                + kartochka.getPerson().getId() + "," + kartochka.getDiagnos().getId() + ");";
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
     * delete kart by id.
     * @param id kart id.
     * @throws SQLException
     */
    public void delete(int id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "delete from kartochka where id=" + id + ';';
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute(sql);
        logger.debug("kart deleted");
        ConnectionPool.getInstance().freeConnection(con);
    }

    /**
     * find kart.
     * @param id person id.
     * @return kart.
     * @throws SQLException
     */
    public Kartochka findKartochka(int id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "select * from kartochka where person_id=" + id + ";";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        Kartochka k = null;
        if (resultSet.next()) {
            k = new Kartochka();
            Diagnos d = new Diagnos();
            k.setId(resultSet.getInt("id"));
            k.setVypiska(resultSet.getInt("vypiska") == 1);
            d.setId(resultSet.getInt("diagnoz_id"));
            k.setDiagnos(d);
        }
        ConnectionPool.getInstance().freeConnection(con);
        return k;
    }

    @Override
    public void init() {
    }

    /**
     * discharge person.
     * @param idPers person id.
     * @throws SQLException
     */
    public void vyp(Integer idPers) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        String sql = "update kartochka set vypiska = 1  where person_id=" + idPers + ";";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute(sql);
        ConnectionPool.getInstance().freeConnection(con);
    }

}
