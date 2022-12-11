import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        
        System.out.println(isRotation(s1, s2));
    }
    
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String tmpS1 = s1 + s1;
        if (isSubstring(tmpS1, s2)) {
            return true;
        }
        return false;
    }
    
    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
    
}

