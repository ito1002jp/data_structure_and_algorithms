import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(compressString("aabcccccaaa")); //a2b1c5a3
        System.out.println(compressString("abcd")); //abcd
    }
    
    /**
     * 与えられた文字列を圧縮する
     * ex) aabcccccaaa => a2b1c5a3
     * - ただし、圧縮した文字列が元の文字列より短くならなかった場合は元の文字列をそのまま返す。
     * - 大文字と小文字のみを対象とする。
     **/
    public static String compressString(String string) {
        StringBuilder compressedStrBuilder = new StringBuilder();
        int countChar = 0;
        for (int i = 0; i < string.length(); i++) {
            countChar++;
            
            // 次の文字が精査中の文字と異なる場合、もしくは精査中の文字が最後の文字である場合は圧縮結果を記録する。
            if (isLastElement(string, i) || string.charAt(i) != string.charAt(i+1)) {
                compressedStrBuilder.append(string.charAt(i));
                compressedStrBuilder.append(countChar);
                countChar = 0;
            }
        }
        
        // 圧縮した文字列が元の文字列より短くならなかった場合は元の文字列をそのまま返す。
        return compressedStrBuilder.length() < string.length() ? compressedStrBuilder.toString() : string;
    }
    
    public static boolean isLastElement(String string, int index) {
        return string.length() == index + 1;
    }
}

