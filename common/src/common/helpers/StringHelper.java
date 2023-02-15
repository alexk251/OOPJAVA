package common.helpers;

import java.util.ArrayList;
import java.util.List;

public class StringHelper {

    //notes: this checks a string if it is null or empty returns TRUE, otherwise returns FALSE
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

   public static boolean isTooLong(String s) {
        return s.length() > 1000;
   }

   public static String appendString(String s1, String s2) {
        return s1 + " " + s2;
   }

   public static char[] toCharArray(String s) {
        return s.toCharArray();
   }
}
