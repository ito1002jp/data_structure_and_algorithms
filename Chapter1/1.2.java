import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean result = checkPermutation("permission", "missionper");
        System.out.println(result);
    }
    
    public static String sort(String word) {
        char[] content = word.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    
    /**
     * ソートして文字列を比較する
     **/
    public static boolean checkPermutation(String word_a, String word_b) {
        if (word_a.length() != word_b.length()) return false;
        return sort(word_a).equals(sort(word_b));
    }
    
    /**
     * 文字を数えて比較する
     **/
    public static boolean checkPermutation2(String word_a, String word_b) {
        if (word_a.length() != word_b.length()) return false;
        
        // basic ASCIIの文字数だけ配列を用意する
        int[] char_set_a = new int[128];
        int[] char_set_b = new int[128];
        for (int i = 0; i < word_a.length(); i++) {
            // 文字列に含まれる文字をカウントする
            char_set_a[(int)word_a.charAt(i)]++;
            char_set_b[(int)word_b.charAt(i)]++;
        }
        
        // 文字をカウントした配列が同じ場合は二つの文字列は順列である。
        return Arrays.equals(char_set_a, char_set_b);
    }
}

