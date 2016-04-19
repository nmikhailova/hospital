package domen;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 23.11.13
 * Time: 16:42
 */
public class User {

    private int id;
    private String login;
    private String password;
    private Person person;
    private Role r;

    public Role getR() {
        return r;
    }

    public void setR(Role r) {
        this.r = r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
