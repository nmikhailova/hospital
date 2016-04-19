package domen;

import java.security.InvalidParameterException;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 02.12.13
 * Time: 18:59
 */
public enum Types {
    procedure("процедуры"), remedy("медикоменты"), operations("операция");
    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    private Types(String displayName) {
        this.displayName = displayName;
    }

    public static Types preob(String type) {
        for (Types t : values()) {
            if (t.getDisplayName().equals(type)) return t;
        }
        throw new InvalidParameterException("no such type");
    }
}
