import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(checkPalindrome("Tact Coa")); // true
        // System.out.println(checkPalindrome("Tact Coaa")); // false
    }
    
    // public static boolean checkPalindrome(String word) {
    //     word = word.toLowerCase();
    //     // アルファベット小文字の数だけ配列を用意する。
    //     int[] char_set = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    //     int val = 0;
    //     for (int i = 0; i < word.length(); i++) {
    //         val = getCharNum(word.charAt(i));
    //         // a-z以外はスキップ
    //         if (val < 0) {
    //             continue;
    //         }
    //         char_set[val]++;
    //     }
        
    //     // 回文かどうかチェックする
    //     // 奇数のアルファベットが複数存在しないことを確認
    //     boolean foundOdd = false;
    //     for (int i = 0; i < char_set.length; i++) {
    //         if (char_set[i] %2 == 1) {
    //             if (foundOdd) {
    //                 return false;
    //             }
    //             foundOdd = true;
    //         }
    //     }
        
    //     return true;
    // }
    
    public static boolean checkPalindrome(String word) {
        word = word.toLowerCase();
        // アルファベット小文字の数だけ配列を用意する。
        int[] char_set = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int val = 0;
        int countOdd = 0;
        for (int i = 0; i < word.length(); i++) {
            val = getCharNum(word.charAt(i));
            // a-z以外はスキップ
            if (val < 0) {
                continue;
            }
            char_set[val]++;
            
            // アルファベットの個数が奇数のものをカウントする
            if (char_set[val] % 2 == 1) {
                countOdd++;
            } else {
                countOdd--;
            }
        }
        
        // 奇数のアルファベットが0、１個以外の場合、回文ではない
        return countOdd <= 1;
    }
    
    public static int getCharNum(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        
        // アルファベット以外は全て-1で返す
        if (val < a && z < val) {
            return -1;
        }
        
        return val - a;
    }
}

