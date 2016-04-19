package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Md5 {

    public static String md5(String string) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("md5");
            digest.reset();
            digest.update(string.getBytes());
            byte[] hash = digest.digest();
            Formatter formatter = new Formatter();
            for (byte aHash : hash) {
                formatter.format("%02X", aHash);
            }
            return formatter.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

}
