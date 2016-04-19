package menu.test;

import util.Bundle;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 23.11.13
 * Time: 16:39
 */
public class Runner {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Locale l = new Locale("en");
        System.out.println(Bundle.findMessage(l, "login"));
    }


}
