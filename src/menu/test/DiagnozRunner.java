package menu.test;

import dao.DiagnosDB;
import domen.Diagnos;
import domen.User;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 03.12.13
 * Time: 21:04
 */
public class DiagnozRunner {
    public static void main(String[] args) throws SQLException {
        DiagnosDB d = new DiagnosDB();
        Diagnos diagnos = new Diagnos();
        User user = new User();
        user.setId(1);
        diagnos.setId(9);
        diagnos.setIshodniy("pnevmaniya");
        diagnos.setDoctor(user);
        diagnos.setOconchatelniy("zdorov");
        diagnos.setDoctor2(user);
//        d.create(diagnos);
//        d.delete(8);
        d.update(diagnos);
    }
}
