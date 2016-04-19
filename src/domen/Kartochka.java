package domen;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 02.12.13
 * Time: 18:47
 */
public class Kartochka {

    private int id;
    private Person person;
    private Diagnos diagnos;
    private boolean vypiska;
    private List<Appointment> appointments;

    public boolean isVypiska() {
        return vypiska;
    }

    public void setVypiska(boolean vypiska) {
        this.vypiska = vypiska;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Diagnos getDiagnos() {
        return diagnos;
    }

    public void setDiagnos(Diagnos diagnos) {
        this.diagnos = diagnos;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}