package domen;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 02.12.13
 * Time: 18:53
 */
public class Appointment {

    private int id;
    private boolean status;
    private String opisanie;
    private Types type;
    private Integer id_kart;

    public Integer getId_kart() {
        return id_kart;
    }

    public void setId_kart(Integer id_kart) {
        this.id_kart = id_kart;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

}
