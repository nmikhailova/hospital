package domen;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 01.12.13
 * Time: 17:04
 */
public class Diagnos {

    private int id;
    private String ishodniy;
    private String oconchatelniy;
    private User doctor;
    private User doctor2; // выписывающий доктор

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIshodniy() {
        return ishodniy;
    }

    public void setIshodniy(String ishodniy) {
        this.ishodniy = ishodniy;
    }

    public String getOconchatelniy() {
        return oconchatelniy;
    }

    public void setOconchatelniy(String oconchatelniy) {
        this.oconchatelniy = oconchatelniy;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public User getDoctor2() {
        return doctor2;
    }

    public void setDoctor2(User doctor2) {
        this.doctor2 = doctor2;
    }

}
