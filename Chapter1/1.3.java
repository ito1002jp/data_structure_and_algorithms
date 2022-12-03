import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "Mr John Smith ";
        url = replaceSpaces(url, 13);
        // url = URLify(url, 13);
        System.out.println(url);
    }
    
    public static String URLify(String url, int trueLength) {
        return url.substring(0, trueLength).replace(" ", "%20");
    }
    
    public static String replaceSpaces(String str, int trueLength) {
        int spaceNum = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        
        int index = trueLength + (spaceNum * 3);
        char[] URLifiedStr = new char[index];
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                URLifiedStr[index - 1] = '0';
                URLifiedStr[index - 2] = '2';
                URLifiedStr[index - 3] = '%';
                index -= 3;
                continue;
            } 
            URLifiedStr[index-1] = str.charAt(i);
            index--;
        }
        return new String(URLifiedStr);
    }
}

