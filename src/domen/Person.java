package domen;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 23.11.13
 * Time: 16:42
 */

public class Person {

    private int id;
    private String fam;
    private String name;
    private String otch;
    private String adress;
    private long phone;
    private int dateBorn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtch() {
        return otch;
    }

    public void setOtch(String otch) {
        this.otch = otch;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(int dateBorn) {
        this.dateBorn = dateBorn;
    }

    @Override
    public String toString() {
        return fam + ' ' + name + ' ' + otch + ", " + dateBorn;
    }

}
