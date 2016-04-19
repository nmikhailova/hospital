package util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 21.12.13
 * Time: 21:48
 */
public class Bundle {

    public static String findMessage(Locale loc, String key) {
        ResourceBundle rb = ResourceBundle.getBundle("resource", loc);
        return rb.getString(key);
    }

}
