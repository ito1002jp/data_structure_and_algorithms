import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // boolean result = isUniqueChars("string"); // true
        boolean result = isUniqueChars("apple"); // false
        System.out.println(result);
    }
    
    public static boolean isUniqueChars(String word) {
        if (word.length() > 128) return false;
        
        // basic ASCIIの場合全ての文字数は128文字。
        // 参考：https://www.k-cube.co.jp/wakaba/server/ascii_code.html
        // 拡張 ASCIIの場合255文字。
        // 参考：http://gallery-code.blogspot.com/2010/05/ascii-128-255.html
        // Unicode 11.0 では、Unicode全体に含まれる文字は146言語・13万7374文字に達する。
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (char_set[(int)character]) {
                return false;
            }
            char_set[(int)character] = true;
        }
        return true;
    }
}

