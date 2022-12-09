import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int[][] image = {{1,1,1,1}, {0,0,0,0}, {1,1,1,1}, {0,0,0,0}};
        printImage(image);
        rotate(image);
        printImage(image);
    }
    
    // public static int[][] rotate(int[][] image) {
    //     int[][] rotatedImage = {{image[1][0],image[0][0]}, {image[1][1], image[0][1]}};
    //     return rotatedImage;
    // }

    public static boolean rotate(int[][] matrix) {
        // matrixのサイズが0の場合もしくは、正方形ではない場合はfalseで返す
        if (matrix.length == 0 || !isSquare(matrix)) return false;
        
        int n = matrix.length;
        // 外側から順にrotateする
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            
            // 横に１bitずつrotateする
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // 上端の値を保存
                
                // 左端 -> 上端
                matrix[first][i] = matrix[last-offset][first];
                // 下端 -> 左端
                matrix[last-offset][first] = matrix[last][last-offset];
                // 右端 -> 下端
                matrix[last][last-offset] = matrix[i][last];
                // 上端 -> 右端
                matrix[i][last] = top;
            }
        }
        return true;
    }
    
    public static boolean isSquare(int[][] matrix) {
        return matrix.length == matrix[0].length;
    }
    
    public static void printImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}

